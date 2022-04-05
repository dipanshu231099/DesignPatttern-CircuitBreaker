package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

@Path("/service")
public class Service {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        Integer video_status;
        try {
            video_status = VideoAvialability();
        } catch (RuntimeException e) {
            System.out.println("Video Service Poor ...");
        }
        return "Hello\n";
    }

    // @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 0.6)
    // public Integer VideoAvialability() throws Exception{
    //     FutureTask<Integer> stream_quality = new FutureTask(new StreamCheck("http://localhost:8000/getVideoStream/"));
    //     if(stream_quality.get()==3){
    //         throw new RuntimeException("Service failed.");
    //     }
    //     return 0;
    // }
}