import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection getConnection() throws Exception {
        String url  = "jdbc:mysql://localhost:3306/ecommerce2025";
        String user = "root";        // change if needed
        String pass = "password";    // change if needed

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    public void registerUser(String username, String password) throws Exception {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        }
    }

    public boolean validateLogin(String username, String password) throws Exception {
        String sql = "SELECT id FROM users WHERE username=? AND password=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public List<String> getAllUsers() throws Exception {
        List<String> users = new ArrayList<>();
        String sql = "SELECT username FROM users";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                users.add(rs.getString("username"));
            }
        }
        return users;
    }
}
