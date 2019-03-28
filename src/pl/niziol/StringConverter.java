package pl.niziol;

import java.util.LinkedList;
import java.util.Scanner;

public class StringConverter {

    public LinkedList<String> convertToStringList(String string) {
        Scanner scanner = new Scanner(string).useDelimiter(" ");
        LinkedList<String> textList = new LinkedList<>();
        while (scanner.hasNext()) {
            textList.add(scanner.next());
        }
        return textList;
    }
}
