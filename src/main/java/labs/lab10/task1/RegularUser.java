package labs.lab10.task1;

@UserPermission(level = "regular")
public class RegularUser extends User {
    public RegularUser(String username) {
        super(username);
    }
}
