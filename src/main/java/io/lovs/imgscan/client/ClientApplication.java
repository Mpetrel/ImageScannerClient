package io.lovs.imgscan.client;

import io.lovs.imgscan.client.listener.ApplicationStartListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClientApplication.class);
        app.setHeadless(false);
        app.addListeners(new ApplicationStartListener());
        app.run(args);
    }
}
