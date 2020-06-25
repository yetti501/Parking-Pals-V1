import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses(){
        HashSet h = new HashSet<Class<?>>();
        h.add(GetTicketInformation.class);
        h.add(AdditionalServices.class);
        h.add(GetParkingInformation.class);
        h.add(GetUserInformation.class);
        h.add(APIHelpers.class);
        return h;
    }
}
