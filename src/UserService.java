import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void addUser(String name, String email) {
        User user = new User(0, name, email);
        try {
            userDAO.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser(int id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(int id, String name, String email) {
        User user = new User(id, name, email);
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }


}
