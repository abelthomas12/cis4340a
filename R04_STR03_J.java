import java.math.BigInteger;

public class CompliantStringEncoding {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("530500452766");
        String s = x.toString(); // Valid character data conversion
        System.out.println("BigInteger as string: " + s);
        
        BigInteger recreatedX = new BigInteger(s); // Direct conversion back to BigInteger
        System.out.println("Recreated BigInteger: " + recreatedX);
    }
}
