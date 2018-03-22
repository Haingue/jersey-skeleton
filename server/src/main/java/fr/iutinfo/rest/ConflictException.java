import javax.ws.rs.ClientErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ConflictException extends ClientErrorException{

    public ConflictException(Response.Status status) {
        super(Response.Status.CONFLICT); // 409
    }
}
