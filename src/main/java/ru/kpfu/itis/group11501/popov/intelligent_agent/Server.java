package ru.kpfu.itis.group11501.popov.intelligent_agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {

    /*
    TODO: Add there relational database in order to save the inserted data
     */

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Server.class);
        app.run(args);
    }

}
