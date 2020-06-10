package fr.ing.interview.kata.webapp.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class RestApplication extends ResourceConfig {

    public RestApplication() {
        packages("fr.ing.interview.kata.webapp.rest");
    }
}
