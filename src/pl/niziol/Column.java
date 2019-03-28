package pl.niziol;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Column {
    private String word;
    private StringBuilder result;
    private int charCounter;
    private int columnWidth;

    private String getWord() {
        return word;
    }

    private void setWord(String word) {
        this.word = word;
    }

    private StringBuilder getResult() {
        return result;
    }

    private void setResult(StringBuilder result) {
        this.result = result;
    }

    private int getCharCounter() {
        return charCounter;
    }

    private void setCharCounter(int charCounter) {
        this.charCounter = charCounter;
    }

    private int getColumnWidth() {
        return columnWidth;
    }

    private void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    protected LinkedList<String> getColumn(LinkedList<String> wordsList, TextWarpType wrapType, int columnWidth, int beginIndex, int endIndex) {
        setResult(new StringBuilder());
        setCharCounter(0);
        setColumnWidth(columnWidth);
        String croppedText = "";
        int index = beginIndex;
        LinkedList<String> column = new LinkedList<>();

        while (index <= endIndex) {
            while (getCharCounter() < getColumnWidth() && index <= endIndex) {
                setWord(wordsList.get(index));
                setCharCounter(getCharCounter() + getWord().length());
                if (getCharCounter() > getColumnWidth()) {
                    croppedText = wrapWordIfTooLong(croppedText, wrapType);
                } else {
                    getResult().append(getWord());
                    setCharCounter(getCharCounter() + 1);
                    if (getCharCounter() != getColumnWidth() + 1) {
                        getResult().append(" ");
                    }
                }
                index++;
            }
            column.add(getResult().toString());
            setCharCounter(croppedText.length());
            setResult(new StringBuilder(croppedText));
            croppedText = "";
        }
        if (!getResult().toString().equals("")) {
            column.add(getResult().toString());
        }
        if (column.getLast().length() < columnWidth) {
            String temp = (column.getLast() + (IntStream.range(0, columnWidth - column.getLast().length()).mapToObj(i -> " ").collect(Collectors.joining(""))));
            column.remove(column.size() - 1);
            column.add(temp);
        }
        return column;
    }

    private String wrapWordIfTooLong(String croppedText, TextWarpType wrapType) {
        if (wrapType == TextWarpType.Wrap) {
            return wrapWord(croppedText);
        } else if (wrapType == TextWarpType.Cut) {
            return cutWord(croppedText);
        } else {
            throw new IllegalArgumentException("Illegal TextWarpType: " + wrapType);
        }

    }

    private String wrapWord(String croppedText) {

        int cropPoint = getWord().length() - (getCharCounter() - getColumnWidth());
        getResult().append(getSpaces(cropPoint));
        croppedText = getWord() + " ";

        return croppedText;
    }

    private String cutWord(String croppedText) {
        int cropPoint = getWord().length() - (getCharCounter() - getColumnWidth()) - 1;
        if (cropPoint == 0) {
            getResult().append(" ");
            croppedText = getWord() + " ";
        } else {
            getResult().append(getWord(), 0, cropPoint).append("-");
            croppedText = getWord().substring(cropPoint) + " ";
        }

        return croppedText;
    }

    protected int findIndexOfLastWordInColumn(LinkedList<String> wordsList, int startingIndex, int stringLength, int widthOfSingleColumn, int divine) {
        if (stringLength < widthOfSingleColumn) {
            return wordsList.size() / divine;
        }
        int columnBreakPoint = stringLength / divine;
        int charCounter = 0, index = startingIndex;
        for (; (charCounter < columnBreakPoint || charCounter < widthOfSingleColumn) && index != wordsList.size(); index++) { // do until you reach half of text and text have X characters in line, or end of text
            charCounter += wordsList.get(index).length() + 1; // add text length plus one space
        }
        return index;
    }

    public String getSpaces(int numberOfSpaces) {
        return IntStream.range(0, numberOfSpaces).mapToObj(i -> " ").collect(Collectors.joining(""));
    }


}
