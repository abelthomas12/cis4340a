import java.io.File;

public class FileDeletion {
    public static void main(String[] args) {
        deleteFile();
    }

    public static void deleteFile() {
        File someFile = new File("someFileName.txt");
        // Attempt to delete the file
        if (!someFile.delete()) {
            System.out.println("Failed to delete the file: " + someFile.getName());
            // Implement further handling here, such as logging or retrying
        } else {
            System.out.println("File deleted successfully: " + someFile.getName());
        }
    }
}
