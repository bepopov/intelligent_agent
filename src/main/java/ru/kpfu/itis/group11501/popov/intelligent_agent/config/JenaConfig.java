package ru.kpfu.itis.group11501.popov.intelligent_agent.config;

import org.aksw.jena_sparql_api.core.SparqlService;
import org.aksw.jena_sparql_api.mapper.jpa.core.SparqlEntityManagerFactory;
import org.aksw.jena_sparql_api.stmt.SparqlQueryParserImpl;
import org.aksw.jena_sparql_api.update.FluentSparqlService;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.util.FileManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.group11501.popov.intelligent_agent.Server;

import javax.persistence.EntityManager;

@Configuration
public class JenaConfig {

    // https://jena.apache.org/documentation/inference/

    private final String COURSE_DATA_FILE =
            PropertiesHolder.getProperties().getProperty("jena.owl.course.file");
    private final String LISTS_DATA_FILE =
            PropertiesHolder.getProperties().getProperty("jena.owl.lists.file");
    private final String SPARQL_DB_URL =
            PropertiesHolder.getProperties().getProperty("sparql.db.url");
    private final String UPDATE_ENDPOINT_URL =
            SPARQL_DB_URL +
            PropertiesHolder.getProperties().getProperty("update.endpoint.path");
    private final String QUERY_ENDPOINT_URL =
            SPARQL_DB_URL +
                    PropertiesHolder.getProperties().getProperty("query.endpoint.path");
    private final String GSP_ENDPOINT_URL =
            SPARQL_DB_URL +
                    PropertiesHolder.getProperties().getProperty("gsp.endpoint.path");

    @Bean
    public Model courseModel() {
        Model model = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model, COURSE_DATA_FILE);
        return model;
    }

    @Bean
    public Model listsModel() {
        Model model = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model, LISTS_DATA_FILE);
        return model;
    }

    @Bean
    public RDFConnection connection() {
        RDFConnection rdfConnection = RDFConnectionFuseki
                .create()
                .updateEndpoint(UPDATE_ENDPOINT_URL)
                .queryEndpoint(QUERY_ENDPOINT_URL)
                .gspEndpoint(GSP_ENDPOINT_URL)
                .build();
        rdfConnection.load("default", courseModel());
        rdfConnection.load("default", listsModel());
        return rdfConnection;
    }

    @Bean
    public SparqlService sparqlService() {
        return FluentSparqlService
                .from(connection())
                .config().configQuery()
                .withParser(SparqlQueryParserImpl.create())
                .withPagination(50000)
                .end()
                .end().create();
    }

    /*
    Сам фреймворк Apache Jena требует написания SPARQL-запросов (как в JDBC),
    что не очень удобно и делает приложение менее изменяемым, поэтому была
    использована библиотека jena-sparql-api, которая реализует
    JPA-спецификацию поверх Apache Jena.
    Ссылка на Github: https://github.com/SmartDataAnalytics/jena-sparql-api

    Note: в библиотеке jena-sparql-api версии 3.7.0-3 отсутствует поддержка Blank Node,
    а также большинства методов CriteriaBuilder и CriteriaQuery.

    Здесь создается объект реализации EntityManager, который позволяет
    обращаться к OWL-онтологии с помощью SPARQL и предоставляет удобный
    интерфейс для разработчика (Criteria API).

    Сами данные хранятся на сервере Apache Jena Fuseki, который необходимо
    предварительно поднять. Используйте application.properties для указания адреса
    поднятого сервера.

    Reasoner должен быть включен на самом сервере Fuseki. Для включения используйте
    конфигурационный файл ccreator.ttl. Он должен лежать в
    apache-jena-fuseki-<version>/run/configuration.
    Не забудьте положить файлы model.ttl и data.ttl в
    apache-jena-fuseki-<version>/run/datasets
     */
    @Bean
    public EntityManager sparqlEntityManager() {
        SparqlEntityManagerFactory emFactory = new SparqlEntityManagerFactory();

        emFactory.getPrefixMapping()
                .setNsPrefix("course", PropertiesHolder.COURSES_ONTOLOGY)
                .setNsPrefix("owl", PropertiesHolder.OWL)
                .setNsPrefix("rdf", PropertiesHolder.RDF)
                .setNsPrefix("schema", PropertiesHolder.SCHEAMA)
                .setNsPrefix("rdfs", PropertiesHolder.RDFS)
                .setNsPrefix("owllist", PropertiesHolder.LIST_SCHEMA)
                .setNsPrefix("listdata", PropertiesHolder.LIST_DATA);

        emFactory.addScanPackageName(Server.class.getPackage().getName());

        //OntModel ontModel = ModelFactory.createOntologyModel(OWL_MEM_MICRO_RULE_INF, model);
       // http://en.wikipedia.org/wiki/Abox

        emFactory.setSparqlService(sparqlService());

        EntityManager em = null;
        try {
            em = emFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em;
    }

}
