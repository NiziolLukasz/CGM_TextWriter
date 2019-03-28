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
        try{
            return Integer.parseInt(read());
        }catch (Exception e){
            throw new IllegalArgumentException("Wrong Integer value: " + e.getLocalizedMessage());
        }
    }
}
