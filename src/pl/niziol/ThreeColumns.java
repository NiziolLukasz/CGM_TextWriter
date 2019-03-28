package pl.niziol;

import java.util.LinkedList;

public class ThreeColumns {
    public void print(String inputtedText, int[] widthOfColumns){
        System.out.println(getText(inputtedText, widthOfColumns));
    }

    private String getText(String inputtedText, int[] widthOfColumns) {
        StringBuilder result = new StringBuilder();
        Column column = new Column();

        LinkedList<String> wordsList = new StringConverter().convertToStringList(inputtedText);
        int indexOfLastWordInFirstColumn = column.findIndexOfLastWordInColumn(wordsList, 0, inputtedText.length(), widthOfColumns[0], widthOfColumns.length);
        int indexOfLastWordInSecondColumn = column.findIndexOfLastWordInColumn(wordsList, indexOfLastWordInFirstColumn, inputtedText.length(), widthOfColumns[1], widthOfColumns.length);
        // index...Third
        // index...Fourth
        // ...

        LinkedList<String> firstColumn = column.getColumn(wordsList, widthOfColumns[0], 0, indexOfLastWordInFirstColumn);
        LinkedList<String> secondColumn = column.getColumn(wordsList, widthOfColumns[1], indexOfLastWordInFirstColumn + 1, indexOfLastWordInSecondColumn);
        LinkedList<String> thirdColumn = column.getColumn(wordsList, widthOfColumns[2], indexOfLastWordInSecondColumn + 1, wordsList.size() - 1);
        // fourthColumn
        // fifthColumn
        // ...

        String spaces = column.getSpaces(Constants.SPACE_BETWEEN_COLUMNS);
        while (!(firstColumn.isEmpty() && secondColumn.isEmpty() && thirdColumn.isEmpty()) ){
            if(!firstColumn.isEmpty()){
                result.append(firstColumn.pop());
            } else {
                result.append(column.getSpaces(widthOfColumns[0]));
            }
            result.append(spaces);
            if(!secondColumn.isEmpty()){
                result.append(secondColumn.pop());
            } else {
                result.append(column.getSpaces(widthOfColumns[1]));
            }
            result.append(spaces);
            if(!thirdColumn.isEmpty()){
                result.append(thirdColumn.pop());
            }
            result.append("\n");
        }

        return result.toString();
    }
}
