import java.io.DataInputStream;
import java.io.IOException;

public class IntegerReader {
    public static void main(String[] args) {
        // Example usage with a placeholder for the input stream
        try (DataInputStream dis = new DataInputStream(System.in)) {
            long result = getInteger(dis);
            System.out.println("The unsigned integer is: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long getInteger(DataInputStream is) throws IOException {
        return is.readInt() & 0xFFFFFFFFL; // Apply bitmask to handle unsigned data
    }
}
