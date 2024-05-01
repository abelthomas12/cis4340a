public class UserLogin {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserLogin.class.getName());

    public static void main(String[] args) {
        // Example usage
        String username = "exampleUser123"; // Normally, you'd get this from user input
        boolean loginSuccessful = true; // This would be determined by your authentication logic

        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + sanitizeUser(username));
        } else {
            logger.severe("User login failed for: " + sanitizeUser(username));
        }
    }

    public static String sanitizeUser(String username) {
        return username.replaceAll("[^A-Za-z0-9_]", "");
    }
}
