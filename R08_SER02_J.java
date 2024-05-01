import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SealedObject;

public class SensitiveDataSerialization {

    public static void main(String[] args) {
        try {
            // Example sensitive data
            String sensitiveData = "Sensitive Credit Card Information";

            // Non-compliant serialization
            serializeDataNonCompliant(sensitiveData, "nonCompliant.ser");

            // Compliant serialization with encryption
            SecretKey key = KeyGenerator.getInstance("AES").generateKey(); // Generate AES key
            serializeDataCompliant(sensitiveData, "compliant.ser", key);
        } catch (Exception e) {
            System.err.println("Exception during serialization: " + e.getMessage());
        }
    }

    // Non-compliant method: Serializes data without encryption
    public static void serializeDataNonCompliant(String data, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(data);
        }
    }

    // Compliant method: Serializes data with encryption
    public static void serializeDataCompliant(String data, String fileName, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        SealedObject sealedObject = new SealedObject(data, cipher);
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(sealedObject);
        }
    }
}
