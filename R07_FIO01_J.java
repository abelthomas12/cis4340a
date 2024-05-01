import java.io.File;
import java.io.IOException;

public class FilePathValidation {

    public static void main(String[] args) {
        String unsafePath = "../etc/passwd";  // Example of an unsafe path input

        try {
            // Non-compliant example
            File nonCompliantFile = createFileNonCompliant(unsafePath);
            System.out.println("Non-compliant file created: " + nonCompliantFile.getAbsolutePath());

            // Compliant example
            File compliantFile = createFileCompliant(unsafePath);
            if (compliantFile != null) {
                System.out.println("Compliant file created: " + compliantFile.getAbsolutePath());
            } else {
                System.out.println("Invalid file path detected and prevented.");
            }
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        }
    }

    // Non-compliant method: Does not validate the file path
    public static File createFileNonCompliant(String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();  // This can lead to path traversal attacks
        return file;
    }

    // Compliant method: Validates the file path to avoid path traversal
    public static File createFileCompliant(String filePath) throws IOException {
        // Check if the file path is safe
        if (filePath.contains("..") || !filePath.startsWith("/")) {
            // Log and handle invalid file paths appropriately
            return null;  // Rejecting unsafe paths
        }
        File file = new File(filePath);
        file.createNewFile();  // Safely creating the file
        return file;
    }
}
