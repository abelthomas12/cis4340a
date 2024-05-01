public class ThreadInterruptionHandling {

    // Non-compliant: Ignoring InterruptedException
    public static class NonCompliantThread extends Thread {
        public void run() {
            try {
                Thread.sleep(1000);  // Simulating some long-running operation
            } catch (InterruptedException e) {
                // Improper handling: ignoring the exception
            }
            System.out.println("Non-compliant thread finished.");
        }
    }

    // Compliant: Properly handling InterruptedException
    public static class CompliantThread extends Thread {
        public void run() {
            try {
                Thread.sleep(1000);  // Simulating some long-running operation
            } catch (InterruptedException e) {
                // Proper handling: restore the interrupted status
                Thread.currentThread().interrupt();
                // Optionally, you can handle the situation further or exit the method
                System.out.println("Compliant thread interrupted and exiting.");
                return;  // Exiting the thread as it has been interrupted
            }
            System.out.println("Compliant thread finished normally.");
        }
    }

    public static void main(String[] args) {
        NonCompliantThread nonCompliantThread = new NonCompliantThread();
        CompliantThread compliantThread = new CompliantThread();

        nonCompliantThread.start();
        compliantThread.start();

        try {
            // Interrupting both threads to simulate external interruption
            nonCompliantThread.interrupt();
            compliantThread.interrupt();

            nonCompliantThread.join();
            compliantThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status in main thread
        }

        System.out.println("Main thread finished.");
    }
}
