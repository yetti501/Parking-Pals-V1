import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Path("/service")
public class AdditionalServices {

    /* These are Ian's API Codes */
    String key_collectapi = "apikey 1zorWuv54N5q9OTrwuOpsc:4q5KRx9FzotEGEnpBJJyUh";
    String key_mygasfeedapi = "3a9afokhzz";
    String key_tomtom =  "iuL58osMVRnaKp0BQFKgGqXovClzzY0x";
    String key_LPR =  "sk_ae28c4b6e230e1f0adeb6b18";

    /**
     * get user ip
     * @return userip
     */
    @Path("/IP")
    @GET
    public String getIP(){
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://api.ipify.org");
        String ip = myResource.request(MediaType.APPLICATION_JSON)
                .get(String.class);

        return ip;
    }

    /**
     * get local zipcode
     * @return zipcode
     */
    @Path("/Zip")
    @GET
    public String getZip(){
        String myip = getIP();
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://ip-api.com/json/"+myip);
        Response res = myResource.request().get();
        JsonObject value = res.readEntity(JsonObject.class);

        String zipcode = value.getString("zip");
        Response.status(200)
                .header("zipcode", zipcode)
                .build();

        return zipcode;
    }

    /**
     * get city name from zipcode
     * @return city
     */
    @Path("/City")
    @GET
    public String getCity(){
        String myzip = getZip();

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("https://www.zipcodeapi.com/rest/UbTY2GUcxGcMo8kO9rFJOBEpbGoqR8Z7sh009HJT7DuZTJdI9cTEoWRNUvZYjaKr/info.json/"+myzip+"/degrees/");
        Response res = myResource.request().get();
        JsonObject value = res.readEntity(JsonObject.class);
        // get city
        String city = value.getString("city");

        return city;
    }

    /**
     * get state name from zipcode
     * @return state
     */
    @Path("/State")
    @GET
    public String getState(){
        String myzip = getZip();

        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("https://www.zipcodeapi.com/rest/UbTY2GUcxGcMo8kO9rFJOBEpbGoqR8Z7sh009HJT7DuZTJdI9cTEoWRNUvZYjaKr/info.json/"+myzip+"/degrees/");
        Response res = myResource.request().get();
        JsonObject value = res.readEntity(JsonObject.class);
        // get city
        String state = value.getString("state");

        return state;
    }

    /**
     * get weather type
     * @return weather the weather type of local city, e.g. Fog
     */
    @Path("/Weather")
    @GET
    public Response getWeather(){
        String weather = "";
        String myzip = getZip();

        Client client = ClientBuilder.newClient();

        try {
            WebTarget myResource = client.target("http://api.openweathermap.org/data/2.5/weather?zip=" + myzip + "&appid=3f5f6a2b55dd80bcb9cc9de668aab415&units=metric");
            Response res = myResource.request().get();
            JsonObject value = res.readEntity(JsonObject.class);
            // get weather
            JsonArray weatherInfo = value.getJsonArray("weather");
            // get weather type, e.g. Fog
            weather = weatherInfo.getJsonObject(0).get("main").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(weather.equals("")){
            return Response.status(Response.Status.PARTIAL_CONTENT)
                    .header("status", "successful")
                    .header("Weather", "Cannot find weather information for you area.")
                    .build();
        } else if(!(weather.equals(""))) {
            return Response.status(Response.Status.OK)
                    .header("Status", "successful")
                    .header("Weather", weather)
                    .build();
        } else {
            return Response.status(Response.Status.REQUEST_TIMEOUT)
                    .header("Status", "failure")
                    .header("Weather", null)
                    .build();
        }
//        if (weather.equals("")) return "Cannot find weather in your location!";
//
//        return weather.replace("\"","");
    }

//    /**
//     * return local weather type and reminder of road condiction
//     * @return string reminder of road condiction
//     */
//    @Path("/WeatherReminder")
//    @GET
//    public String getWeatherReminder(){
//        String weather = getWeather();
//        if(weather.equals("Rain")||weather.equals("Fog")||weather.equals("Snow")) {
//            return "It is " +weather+ ", please take care when you drive!";
//        }else{
//            return "It is " +weather+ ", enjoy your driving!";
//        }
//    }

    /*
    @Path("/weather")
    @GET
    public Response getWeather() {
        String myZip = getZip();
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("api.openweathermap.org/data/2.5/weather?zip=" + myZip + ",us");
        Response response = myResource.request().get();
        if (response.getStatus() == 404) {
            Response.ResponseBuilder rb = Response.status(Response.Status.EXPECTATION_FAILED);
            response = rb
                    .header("status", "failure")
                    .header("Error", "There is a problem with the API Server.")
                    .build();
            return response;
        } else if (response.getStatus() == 200) {
            JsonObject root = response.readEntity(JsonObject.class);
            JsonObject weather = root.getJsonObject("weather");
            String mainWeather = weather.get("main").toString();
            String descriptionWeather = weather.get("description").toString();
            JsonObject main = root.getJsonObject("main");
            double temperatureKalvin = ((Number) main.getJsonObject("temp")).doubleValue();
            double temperatureCelsius = APIHelpers.k2c(temperatureKalvin);
            double temperatureFahrenheit = APIHelpers.c2f(temperatureCelsius);

            Response.ResponseBuilder rb = Response.status(Response.Status.OK);
            response = rb
                    .header("status", "success")
                    .header("Kalvin", temperatureKalvin)
                    .header("Celsius", temperatureCelsius)
                    .header("Fahrenheit", temperatureFahrenheit)
                    .build();
            return response;

        } else {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            response = rb
                    .header("Status", "failure")
                    .header("Error", "check the uri or request path")
                    .build();
            return response;
        }
    }
    */

    /**
     *
     * return lowest gas price to user
     * @return GasPrice local gas price
     */
    @Path("/GasPrice")
    @GET
    public Response getGasPrice(){
        String Price = "";

        // get geolocation
        String lat_lon = getGeolocation();
        String lat = lat_lon.split(" ")[0];
        String lon = lat_lon.split(" ")[1];

        // get client
        Client client = ClientBuilder.newClient();

        try {
            // get resource
            WebTarget myResource = client.target("http://api.mygasfeed.com/stations/radius/"+lat+"/"+lon+"/10/reg/Price/"+key_mygasfeedapi+".json");
            Response response = myResource.request().get();

            // return json
            JsonObject value = response.readEntity(JsonObject.class);
            // get stations
            JsonArray stations = value.getJsonArray("stations");

            // avoid the situation when Price is "N/A"
            for(int i=0;i<=stations.size();i++){
                Price = stations.getJsonObject(i).getString("reg_price");
                if (Price.equals("N/A")) continue;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(Price.equals("")){
            return Response.status(Response.Status.PARTIAL_CONTENT)
                    .header("status", "successful")
                    .header("Price", "There are not gas stations near by.")
                    .build();

        } else if(!(Price.equals(""))) {
            return Response.status(Response.Status.OK)
                    .header("Status", "successful")
                    .header("Price", Price)
                    .build();
        } else {
            return Response.status(Response.Status.REQUEST_TIMEOUT)
                    .header("Status", "failure")
                    .header("Price", null)
                    .build();
        }

        // if no stations found
//        if(Price.equals("")) return "There are no stations nearby!";

//        return Price;
    }

    /**
     * get user geolocation
     * @return lat,long
     */
    @Path("/Geo")
    @GET
    public String getGeolocation(){
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target("http://ip-api.com/json/");
        Response res = myResource.request().get();
        JsonObject value = res.readEntity(JsonObject.class);

        Object lat = value.get("lat");
        Object lon = value.get("lon");

        return lat.toString()+" "+lon.toString();
    }

    /**
     *
     * return traffic condiction to user
     * when current Travel Time is higher than free flow travel time, traffic condiction is considered bad
     * @return condiction
     */
    @Path("/Traffic")
    @GET
    public String getTrafficCondiction(){
        String condiction = "";

        // get geolocation
        String lat_lon = getGeolocation();
        String lat = lat_lon.split(" ")[0];
        String lon = lat_lon.split(" ")[1];

        // get client
        Client client = ClientBuilder.newClient();

        try {
            // get resource
            WebTarget myResource = client.target("https://api.tomtom.com/traffic/services/4/flowSegmentData/absolute/10/json?point="+lat+"%2C"+lon+"&unit=KMPH&key="+key_tomtom);
            Response response = myResource.request().get();

            // return json
            JsonObject value = response.readEntity(JsonObject.class);
            // get flow data
            JsonObject flowSegmentData = value.getJsonObject("flowSegmentData");
            // get time
            int currentTravelTime = flowSegmentData.getInt("currentTravelTime");
            int freeFlowTravelTime = flowSegmentData.getInt("freeFlowTravelTime");
            if (currentTravelTime>freeFlowTravelTime){
                condiction="Bad!";
            }else condiction = "Good!";

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (condiction.equals("")) return "Cannot find value!";

        return condiction;
    }


    /**
     *
     * return license plate recognition result to user
     * http request content-type: "application/x-www-form-urlencoded"
     * @param image_path the path of image file "/Users/ianren/IdeaProjects/ParkingPal/test.jpg"
     * @return json_content result of license plate recognition
     */
    @javax.ws.rs.Path("/LPR")
    @POST
    public String postLPR(@FormParam("image_path") String image_path){
        String json_content = "";

        try
        {
            String secret_key = key_LPR;

            // Read image file to byte array
            java.nio.file.Path path = Paths.get(image_path);
            byte[] data = Files.readAllBytes(path);

            // Encode file bytes to base64
            byte[] encoded = Base64.getEncoder().encode(data);

            // Setup the HTTPS connection to api.openalpr.com
            URL url = new URL("https://api.openalpr.com/v2/recognize_bytes?recognize_vehicle=1&country=us&secret_key=" + secret_key);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setFixedLengthStreamingMode(encoded.length);
            http.setDoOutput(true);

            // Send our Base64 content over the stream
            try(OutputStream os = http.getOutputStream()) {
                os.write(encoded);
            }

            int status_code = http.getResponseCode();
            if (status_code == 200)
            {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        http.getInputStream()));
                //String json_content = "";
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    json_content += inputLine;
                in.close();

                // return result
                return json_content;
            }
            else
            {
                return "Got non-200 response: " + status_code;
            }

        }
        catch (MalformedURLException e)
        {
            return "Bad URL";
        }
        catch (IOException e)
        {
            return "Failed to open connection";
        }

    }

}
