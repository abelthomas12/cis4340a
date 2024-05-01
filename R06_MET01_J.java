public class CompliantMethod {
    public static void main(String[] args) {
        try {
            System.out.println("Result: " + getAbsAdd(100, 200));
            System.out.println("Result: " + getAbsAdd(Integer.MIN_VALUE, 1)); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    public static int getAbsAdd(int x, int y) {
        if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Input cannot be Integer.MIN_VALUE");
        }
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        if (absX > Integer.MAX_VALUE - absY) {
            throw new IllegalArgumentException("Integer overflow");
        }
        return absX + absY;
    }
}
