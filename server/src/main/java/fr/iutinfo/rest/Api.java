package fr.iutinfo.rest;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/v1/")
public class Api extends ResourceConfig {

    public Api() {
        packages("fr.iutinfo.rest");
        //register(LoggingFilter.class);
        //register(AuthFilter.class);
        //register(RolesAllowedDynamicFeature.class);
        BDDFactory.initiializeBdd();
    }

}
