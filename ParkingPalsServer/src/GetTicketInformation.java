import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;

@Path("/")
public class GetTicketInformation {

    @GET
    @Produces("text/html")
    @Path("/testDB")
    public String displayMessage() throws SQLException {
        //String something = JDBC.executeQuery("SELECT * FROM parkingpal.ticketdata;");
        //return something;

        return JDBC.executeQuery("SELECT * FROM parkingpal.ticketdata;");
        //return "This is a sample string";
    }

    @GET
    @Path("/getAllTicketInformation/{ticketNum}")
    @Produces("text/html")
    public String getAllTicketInformation(@PathParam("ticketNum") double ticketNum) throws SQLException {
        String ticketNumber = String.valueOf(ticketNum);
        String stallNumber = getStallNumberSTR();
        String cost = getTicketCostSTR();
        String startTime = getTicketStartTimeSTR();
        String endTime = getTicketEndTimeSTR();
        String deltaTime= getParkedTimeSTR();

        return ("Ticket Number: " + ticketNumber +
                "Stall Number: " + stallNumber +
                "Parking Cost: " + cost +
                "Start Time: " + startTime +
                "End Time: " + endTime +
                "Total Time: " + deltaTime);
    }

    private String getStallNumberSTR() throws SQLException {
//        Client client = ClientBuilder.newClient();
//        WebTarget myResource = client.target("http://localhost:8080/ParkingPalsServer/getStallNumber");
//        Response response = myResource.request().get();
        String something = JDBC.executeQuery("SELECT * FROM parkingpal;");
        return something;

//        return "123";
    }

    private String getTicketCostSTR(){
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8080/ParkingPalsServer/getTicketCost");
        Response response = myResource.request().get();

        return "$12.42";
    }

    private String getTicketStartTimeSTR(){
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8080/ParkingPalsServer/getTicketStartTime");
        Response response = myResource.request().get();

        return "10:42:15";
    }

    private String getTicketEndTimeSTR(){
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://localhost:8080/ParkingPalsServer/getTicketEndTime");
        Response response = myResource.request().get();

        return "16:36:40";
    }

    private String getParkedTimeSTR(){
        long startTime = Long.parseLong(getTicketStartTimeSTR());
        long endTime = Long.parseLong(getTicketEndTimeSTR());

        Timestamp newStart = new Timestamp(startTime);
        Timestamp newEnd = new Timestamp(endTime);

        long deltaTime = newEnd.getTime() - newStart.getTime();

        return Long.toString(deltaTime);
    }

    @Path("/ticketNumber/{ticketNum}")
    @GET
    @Produces("text/html")
    public Response getTicketNumber(@PathParam("ticketNum")double ticketNum){
        if(ticketNum == 123){
            return Response.status(Response.Status.OK)
                    .header("status", "successful")
                    .header("ticketNumber", ticketNum)
                    .header("Location", "https://localhost:44373/HomePage.aspx")
                    .build();

        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("Status", "failure")
                    .header("Error", "The ticket number does not match")
                    .header("Location", "https://localhost:44373/ErrorPage.aspx")
                    .build();
        }
    }

    @Path("/getTicketNumber")
    @GET
    @Produces("text/html")
    public Response getTicketNumber(){
        return Response.status(Response.Status.OK)
            .header("status", "successful")
            .header("ticketNumber", 123)
            .build();
//        return 123;
    }

    @Path("/getStallNumber")
    @GET
    @Produces("text/html")
    public Response getStallNumber(){
        return Response.status(Response.Status.OK)
                .header("status", "successful")
                .header("ticketStallNumber", 007)
                .build();
    }

    @Path("/getTicketCost")
    @GET
    @Produces("text/html")
    public Response getTicketCost(){
        return Response.status(Response.Status.OK)
                .header("status", "successful")
                .header("ticketCost", 13.42)
                .build();
    }

    @Path("/getTicketStartTime")
    @GET
    @Produces("text/html")
    public Response getTicketStartTime(){
        return Response.status(Response.Status.OK)
                .header("status", "successful")
                .header("ticketStartTime", "10:41:36")
                .build();
    }

    @Path("/getTicketEndTime")
    @GET
    @Produces("text/html")
    public Response getTicketEndTime(){
        return Response.status(Response.Status.OK)
                .header("status", "successful")
                .header("ticketEndTime", "14:24:52")
                .build();
    }

    @Path("/getTicketTotalTime")
    @GET
    @Produces("text/html")
    public Response getTicketTotalTime(){
        return Response.status(Response.Status.OK)
                .header("status", "successful")
                .header("ticketTotalTime", "3:41:16")
                .build();
    }
}




















