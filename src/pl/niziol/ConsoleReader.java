package pl.niziol;

import java.util.Scanner;

public class ConsoleReader {
    public String read() {
        return new Scanner(System.in).nextLine();
    }

    public int readNumberOfColumns() {
        return readInteger();
    }

    private int readInteger() {
        try {
            return Integer.parseInt(read());
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong Integer value: " + e.getLocalizedMessage());
        }
    }

    public int[] readWidthOfColumns(int numberOfColumns) {
        int[] result = new int[numberOfColumns];
        for (int i = 0; i < numberOfColumns; ) {
            System.out.println("Enter the value of the " + (i+1) + " column:");
            result[i] = readInteger();
            if (result[i] < 1) {
                System.out.println("Width of column must be higher than 0");
            } else {
                i++;
            }
        }
        return result;
    }
}
