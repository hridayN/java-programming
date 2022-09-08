package BitManipulation;

public class BitManipulationBasics {
    public static void main(String[] args) {
        int n = 5;
        //GetBit(n, 3);
        // SetBit(2, 2);
        // ClearBit(5, 2);
        UpdateBit(13, 3, 0);
    }

    public static int GetBit(int n, int position) {
        // Calculate bitMask(by left-shifting the bits of 1(in binary) by position times bits
        int bitMask = 1 << position;

        // Here, single & indicates we are performing logical AND
        int result = bitMask & n;
        if (result == 0) {
            System.out.println(String.format("%dth bit in %d is: 0", position, n));
        } else {
            System.out.println(String.format("%dth bit in %d is: 1", position, n));
        }
        return result;
    }

    public static int SetBit(int n, int position) {
        // Calculate bitMask(by left-shifting the bits of 1(in binary) by position times bits
        int bitMask = 1 << position;

        // Here, single | indicates we are performing logical OR
        int result = bitMask | n;
        System.out.println(String.format("%d's Updated value: %d", n, result));
        return result;
    }

    public static int ClearBit(int n, int position) {
        // Calculate bitMask(by left-shifting the bits of 1(in binary) by position times bits
        int bitMask = 1 << position;

        // Here, single ~ indicates we are performing logical NOT
        int notBitMask = ~(bitMask);

        // Here, single & indicates we are performing logical AND
        int result = notBitMask & n;
        System.out.println(String.format("%d's Updated value: %d", n, result));
        return result;
    }

    public static int UpdateBit(int n, int position, int valueToSet) {
        int result = 0;
        switch (valueToSet) {
            case 0: result = ClearBit(n, position); break;
            case 1: result = SetBit(n, position); break;
        }
        //System.out.println(String.format("%d's Updated value: %d", n, result));
        return result;
    }
}
