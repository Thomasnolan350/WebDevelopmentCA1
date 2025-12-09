import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class LogoutAction implements SessionAware {

    private Map<String, Object> session;

    public String execute() {
        if (session != null) {
            session.clear();  // invalidate “virtual” session
        }
        return "success";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
