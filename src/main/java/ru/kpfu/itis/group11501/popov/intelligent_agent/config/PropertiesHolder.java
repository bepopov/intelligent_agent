package ru.kpfu.itis.group11501.popov.intelligent_agent.config;

import java.util.Properties;

public class PropertiesHolder {

    private static Properties properties;
    public static final String COURSES_ONTOLOGY = "http://www.kpfu.ru/admin/ontologies/2019/courses#";

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