package com.socialapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class SocialApiApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SocialApiApplication.class, args);
        launchBrowser();
    }

    public static void launchBrowser() throws Exception {
        System.setProperty("java.awt.headless", "false");
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("http://localhost:8080"));
    }
}
