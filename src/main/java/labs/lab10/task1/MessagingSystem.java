package labs.lab10.task1;

public class MessagingSystem {

    @RequiresPermission(level = "admin")
    @CanSendMessage
    public void sendMessage(User user, String message) {
        if (isAdmin(user)) {
            System.out.println(user.getUsername() + " (Admin) sent: " + message);
        } else {
            System.out.println(user.getUsername() + " (Regular) is restricted from sending messages.");
        }
    }

    private boolean isAdmin(User user) {
        Class<?> userClass = user.getClass();
        if (userClass.isAnnotationPresent(UserPermission.class)) {
            String permissionLevel = userClass.getAnnotation(UserPermission.class).level();
            return "admin".equals(permissionLevel);
        }
        return false;
    }

    public static void main(String[] args) {
        User regularUser = new RegularUser("JohnDoe");
        User adminUser = new AdminUser("AdminJane");

        MessagingSystem system = new MessagingSystem();

        System.out.println("Messaging System Test");
        system.sendMessage(regularUser, "Hello world");
        system.sendMessage(adminUser, "System message");
    }
}
