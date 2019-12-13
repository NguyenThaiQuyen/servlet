package packages.admin;
public class Admin {
    private String id;
    private String username;
    private String password;

    public Admin(String _id, String _username, String _password) {
        this.id = _id;
        this.username = _username;
        this.password = _password;
    }

    public String getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}