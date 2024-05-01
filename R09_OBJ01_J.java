public class FieldAccessibility {

    // Non-compliant: Public fields can be directly accessed and modified
    public static class NonCompliantUserData {
        public String username;
        public String password;

        public NonCompliantUserData(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // Compliant: Private fields with public getter and setter methods
    public static class CompliantUserData {
        private String username;
        private String password;

        public CompliantUserData(String username, String password) {
            setUsername(username);
            setPassword(password);
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

    public static void main(String[] args) {
        // Non-compliant usage
        NonCompliantUserData nonCompliantUser = new NonCompliantUserData("user", "pass123");
        nonCompliantUser.password = "newPassword";  // Directly modifying the password field

        // Compliant usage
        CompliantUserData compliantUser = new CompliantUserData("user", "pass123");
        compliantUser.setPassword("newPassword123");  // Setting the password through a method
    }
}
