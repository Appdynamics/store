package com.amazon.aws.samplecode.travellog.util;

import com.amazon.aws.samplecode.travellog.entity.Itinerary;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;


public class RestUtil {
    public static List<Itinerary> getItineraries() {
        String endpoint  = Configuration.getInstance().getProperty("restEndpoint");
        Client restClient = ClientBuilder.newClient();
        return restClient.target("http://" + endpoint + "/travel/rest/itinerary").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Itinerary>>() {
        });
    }
}
