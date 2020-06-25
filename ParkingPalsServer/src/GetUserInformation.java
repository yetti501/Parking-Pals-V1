import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/getUserInformation")
public class GetUserInformation {

    @GET
    @Produces("text/html")
    public String displayMessage(){
        return "This is the get user information page.";
    }

    @GET
    @Path("/getAllUserInoformation")
    @Produces("text/html")
    // This will get all the user information that is available
    // Need to make sure that the user is logged in correctly
    // aka they need to have proper credentials.
    public String getAllUserInformation(){
//        String userName = getUserName();
//        String userEmail = getUserEmail();
//        String userPhoneNumber = getUserPhoneNumber();
//        String userAddress = getUserAddress();
//        String userAccountTrype = getUserAccountType();
//        String userPassword = getUserPassword();
//        String UserInforAll = ("Username: " + userName +
//                "Email: " + userEmail +
//                "Phone Number: " + userPhoneNumber +
//                "Address: " + userAddress +
//                "Account Type: " + userAccountType +
//                "Password: " + userPassword);
        return "User Information";
    }

    @GET
    @Path("/checkCredentials/{username},{password}")
    @Produces("text/html")
    public String getCheckCredentials(@PathParam("username")String username, @PathParam("password") String password, @Context HttpHeaders headers){
        if(username.equals("sampleUser")) { // SELECT username FROM parkingpal.userprofile.username;
            if (password.equals("pass")){ // SELECT password FROM parkingpal.userprofile.password;
                return "Successful Test";
            }else {
                return "Invalid Password";
            }
        } else {
            return "Invalid Username";
        }
    }

//    @POST
//    @Path("/postCredentials")
//    @Produces("text/html")
//    public void postCheckCredentials(@Context HttpHeaders headers){
//        String username = headers.getRequestHeader("username").toString();
//        String password = headers.getRequestHeader("password").toString();
//
//    }

    @GET
    @Path("/checkCredentials")
    @Produces("text/html")
    public Response getCheckCredentials(@Context HttpHeaders headers){
        String username = headers.getRequestHeader("username").toString();
        String password = headers.getRequestHeader("password").toString();
//        return username + " " + password;
        if(username.equals("[sampleUser]")) { // SELECT username FROM parkingpal.userprofile.username;
            if (password.equals("[pass]")){ // SELECT password FROM parkingpal.userprofile.password;
                return Response.status(Response.Status.OK)
                        .header("status", "successful")
                        .header("valid", true)
                        .build();
            }else {
                return Response.status(Response.Status.OK)
                        .header("status", "failure")
                        .header("Error", "Invalid Password")
                        .header("valid", false)
                        .build();
            }
        } else {
            return Response.status(Response.Status.OK)
                    .header("status", "failure")
                    .header("Error", "Invalid username")
                    .header("valid", false)
                    .build();
        }
    }

    @GET
    @Path("/getUserName")
    @Produces("text/html")
    // This will get the username.
    public Response getUserName(){
        return Response.status(Response.Status.OK)
                .header("status", "successful")
                .header("userName", "SampleUserName")
                .build();
//        return 123;
    }

    @GET
    @Path("/getUserEmail")
    @Produces("text/html")
    // This will get the users email.
    public Response getUserEmail(){
        return Response.status(Response.Status.OK)
                .header("status","successful")
                .header("userEmail", "Sample@email.com")
                .build();
    }

    @GET
    @Path("/getUserPhoneNumber")
    @Produces("text/html")
    public Response getUserPhoneNumber(){
        return Response.status(Response.Status.OK)
                .header("status","successful")
                .header("userPhoneNumber", "000-000-0000")
                .build();
    }

    @GET
    @Path("/getUserAddress")
    @Produces("text/html")
    public Response getUserAddress(){
        return Response.status(Response.Status.OK)
                .header("status","successful")
                .header("userAddress", "1234 Main Street, Tacoma, Washington, 98402")
                .build();
    }

    @GET
    @Path("/getUserAccountType")
    @Produces("text/html")
    public Response getUserAccountType(){
        return Response.status(Response.Status.OK)
                .header("status","successful")
                .header("userAccountType", "Free, Standard, Premium")
                .build();
    }

    @GET
    @Path("/getUserPassword")
    @Produces("text/html")
    public Response getUserPassword(){
        return Response.status(Response.Status.OK)
                .header("status","successful")
                .header("userPassword", "password")
                .build();
    }


}
