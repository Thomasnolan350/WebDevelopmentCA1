import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class RegisterClass implements SessionAware {

    private String userName;
    private String password;

    // list of all usernames for the iterator demo
    private ArrayList<String> allUsernames = new ArrayList<>();

    // Struts session map
    private Map<String, Object> session;

    public RegisterClass() {}

    public String registration() {
        // put the current user in the session
        session.put("currentUser", userName);

        // populate the list like in the lab
        allUsernames.add("Tom");
        allUsernames.add("Mary");
        allUsernames.add("Terry");
        allUsernames.add(userName);  // the one who just registered

        // we could also save allUsernames in session if we want
        session.put("allUsernames", allUsernames);

        return "SUCCESS";
    }

    // getters & setters (Struts needs these)
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public ArrayList<String> getAllUsernames() { return allUsernames; }
    public void setAllUsernames(ArrayList<String> allUsernames) { this.allUsernames = allUsernames; }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
