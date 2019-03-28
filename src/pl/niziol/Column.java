package pl.niziol;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Column {
    protected LinkedList<String> getColumn(LinkedList<String> wordsList, int widthOfSingleColumn,int beginIndex, int endIndex) {
        String word, croppedText = "";
        StringBuilder result = new StringBuilder();
        int charCounter = 0, index = beginIndex;
        LinkedList<String> column = new LinkedList<>();

        while (index <= endIndex) {
            while (charCounter < widthOfSingleColumn && index <= endIndex) {
                word = wordsList.get(index);
                charCounter += word.length();
                if(charCounter > widthOfSingleColumn){
                    int cropPoint = word.length() - (charCounter - widthOfSingleColumn) - 1;
                    if(cropPoint == 0){
                        result.append(" ");
                        croppedText = word + " ";
                    }
                    else {
                        result.append(word, 0, cropPoint).append("-");
                        croppedText = word.substring(cropPoint) + " ";
                    }
                }else{
                    result.append(word);
                    charCounter++;
                    if(charCounter != widthOfSingleColumn + 1){
                        result.append(" ");
                    }
                }
                index++;
            }
            column.add(result.toString());
            charCounter = croppedText.length();
            result = new StringBuilder(croppedText);
            croppedText = "";
        }
        if(!result.toString().equals("")){
            column.add(result.toString());
        }
        if(column.getLast().length() < widthOfSingleColumn){
            String temp = (column.getLast() + (IntStream.range(0, widthOfSingleColumn - column.getLast().length()).mapToObj(i -> " ").collect(Collectors.joining(""))));
            column.remove(column.size() - 1);
            column.add(temp);
        }
        return column;
    }

    protected int findIndexOfLastWordInColumn(LinkedList<String> wordsList, int startingIndex, int stringLength, int widthOfSingleColumn, int divine) {
        if(stringLength < widthOfSingleColumn){
            return wordsList.size()/divine;
        }
        int columnBreakPoint = stringLength /divine;
        int charCounter = 0, index = startingIndex;
        for(; (charCounter < columnBreakPoint || charCounter < widthOfSingleColumn) && index != wordsList.size(); index++){ // do until you reach half of text and text have X characters in line, or end of text
            charCounter += wordsList.get(index).length() + 1; // add text length plus one space
        }
        return index;
    }

    public String getSpaces() {
        return IntStream.range(0, Constants.SPACE_BETWEEN_COLUMNS).mapToObj(i -> " ").collect(Collectors.joining(""));
    }
}
