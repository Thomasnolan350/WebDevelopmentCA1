import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class LoginAction implements SessionAware {

    private String loginUsername;
    private String loginPassword;

    private Map<String, Object> session;

    public LoginAction() {}

    public String login() {
        // SUPER simple “login” – accepts any non-empty user/pass
        if (loginUsername != null && !loginUsername.trim().isEmpty()
                && loginPassword != null && !loginPassword.trim().isEmpty()) {

            // store the logged-in user in the session
            session.put("currentUser", loginUsername);
            return "success";
        }
        return "failure"; // e.g. back to login page
    }

    // getters + setters so Struts tags can populate them
    public String getLoginUsername() { return loginUsername; }
    public void setLoginUsername(String loginUsername) { this.loginUsername = loginUsername; }

    public String getLoginPassword() { return loginPassword; }
    public void setLoginPassword(String loginPassword) { this.loginPassword = loginPassword; }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
