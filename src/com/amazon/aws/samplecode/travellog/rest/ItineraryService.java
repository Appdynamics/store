package com.amazon.aws.samplecode.travellog.rest;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Itinerary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.context.*;
import java.util.List;

@Path("/itinerary")
@Component
public class ItineraryService {

    @Autowired
    private TravelLogDAO travelLogDao;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Itinerary> getIntineraties() {
        /* tired of troubleshooting jersey/spring integration*/
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        travelLogDao = (TravelLogDAO)ctx.getBean("travelLogDao");
        return travelLogDao.getBookedIntinerary();
    }
}
