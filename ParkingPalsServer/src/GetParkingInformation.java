import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.status;

@Path("/parkingInformation")
public class GetParkingInformation {

    @GET
    @Produces("text/html")
    public String displayMessage(){
        return "Welcome to the Parking information page";
    }


    // This will start the Parked timer
    // Will need to know User Ticket Number and User Name
    public void setStartParkedTime(){

    }

    // This will end the Parked timer
    // Will need to know User Ticket Number and User Name
    public void setEndParkedTime(){

    }


}
