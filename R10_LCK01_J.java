public class SynchronizationPractices {

    // Non-compliant: Synchronizing on a publicly accessible object
    public static class NonCompliantSynchronization {
        public static final Object lock = new Object();

        public void performAction() {
            synchronized (lock) {
                // Critical section code
                System.out.println("Non-compliant synchronization performed.");
            }
        }
    }

    // Compliant: Using a private final object to synchronize
    public static class CompliantSynchronization {
        private final Object lock = new Object();

        public void performAction() {
            synchronized (lock) {
                // Critical section code
                System.out.println("Compliant synchronization performed.");
            }
        }
    }

    public static void main(String[] args) {
        NonCompliantSynchronization nonCompliantSync = new NonCompliantSynchronization();
        CompliantSynchronization compliantSync = new CompliantSynchronization();

        nonCompliantSync.performAction();
        compliantSync.performAction();
    }
}
