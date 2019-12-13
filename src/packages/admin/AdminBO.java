package packages.admin;

public class AdminBO {
    Admin getAdmin(String username, String password) {
        AdminDAO adDAO = new AdminDAO();
        return adDAO.getAdmin(username, password);
    }
}
