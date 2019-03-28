package pl.niziol;

import java.util.LinkedList;

public class ThreeColumns {
    public void print(String inputtedText){
        System.out.println(getText(inputtedText));
    }

    private String getText(String inputtedText) {
        Column column = new Column();
        StringBuilder result;

        LinkedList<String> wordsList = new StringConverter().convertToStringList(inputtedText);
        int indexOfLastWordInFirstColumn = column.findIndexOfLastWordInColumn(wordsList, 0, inputtedText.length(), Constants.THREE_COLUMN_WIDTH, 3);
        int indexOfLastWordInSecondColumn = column.findIndexOfLastWordInColumn(wordsList, indexOfLastWordInFirstColumn, inputtedText.length(), Constants.THREE_COLUMN_WIDTH, 3);
        // index...Third
        // index...Fourth
        // ...

        LinkedList<String> firstColumn = column.getColumn(wordsList, Constants.THREE_COLUMN_WIDTH, 0, indexOfLastWordInFirstColumn);
        LinkedList<String> secondColumn = column.getColumn(wordsList, Constants.THREE_COLUMN_WIDTH, indexOfLastWordInFirstColumn + 1, indexOfLastWordInSecondColumn);
        LinkedList<String> thirdColumn = column.getColumn(wordsList, Constants.THREE_COLUMN_WIDTH, indexOfLastWordInSecondColumn + 1, wordsList.size() - 1);
        // fourthColumn
        // fifthColumn
        // ...

        result = arrangeTheColumns(firstColumn, secondColumn, thirdColumn); // fourthColumn, fifthColumn, ...

        return result.toString();
    }

    private StringBuilder arrangeTheColumns(LinkedList<String> firstColumn, LinkedList<String> secondColumn, LinkedList<String> thirdColumn){
        StringBuilder result = new StringBuilder();
        String spaces = new Column().getSpaces();
        while (!(firstColumn.isEmpty() && secondColumn.isEmpty() && thirdColumn.isEmpty()) ){
            if(!firstColumn.isEmpty()){
                result.append(firstColumn.pop());
            }
            result.append(spaces);
            if(!secondColumn.isEmpty()){
                result.append(secondColumn.pop());
            }
            result.append(spaces);
            if(!thirdColumn.isEmpty()){
                result.append(thirdColumn.pop());
            }
            result.append("\n");
        }
        return result;
    }
}
