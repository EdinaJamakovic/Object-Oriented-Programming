package labs.lab10.task1;

@UserPermission(level = "admin")
public class AdminUser extends User {
    public AdminUser(String username) {
        super(username);
    }
}

