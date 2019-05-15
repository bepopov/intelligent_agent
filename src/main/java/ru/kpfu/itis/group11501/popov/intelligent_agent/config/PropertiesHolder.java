package ru.kpfu.itis.group11501.popov.intelligent_agent.config;

import java.util.Properties;

public class PropertiesHolder {

    private static Properties properties;
    public static final String RDFS = "http://www.w3.org/2000/01/rdf-schema#";
    public static final String OWL = "http://www.w3.org/2002/07/owl#";
    public static final String RDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    public static final String SCHEAMA = "http://schema.org/";
    public static final String COURSES_ONTOLOGY = "http://www.kpfu.ru/admin/ontologies/2019/courses#";
    public static final String LIST_SCHEMA = "http://www.co-ode.org/ontologies/list.owl#";
    public static final String LIST_DATA = "http://www.co-ode.org/ontologies/lists/2008/09/11/list.owl#";

    static{
        properties = new Properties();
        try {
            properties.load(PropertiesHolder.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (Exception e) {
            System.out.println("Can't load properties");
            throw new IllegalStateException(e.getMessage());
        }
    }

    public static Properties getProperties(){
        return properties;
    }
}