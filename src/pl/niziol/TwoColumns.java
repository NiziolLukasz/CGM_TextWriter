package pl.niziol;

import java.util.LinkedList;
public class TwoColumns {

    public void print(String inputtedText){
        System.out.println(getText(inputtedText));
    }

    private String getText(String inputtedText) {
        Column column = new Column();
        StringBuilder result = new StringBuilder();

        LinkedList<String> wordsList = new StringConverter().convertToStringList(inputtedText);
        String spaces = column.getSpaces();
        int indexOfLastWordInFirstColumn = column.findIndexOfLastWordInColumn(wordsList, 0, inputtedText.length(), Constants.TWO_COLUMN_WIDTH, 2);

        LinkedList<String> firstColumn = column.getColumn(wordsList, Constants.TWO_COLUMN_WIDTH, 0, indexOfLastWordInFirstColumn);
        LinkedList<String> secondColumn = column.getColumn(wordsList, Constants.TWO_COLUMN_WIDTH, indexOfLastWordInFirstColumn + 1, wordsList.size() - 1);

        while (!(firstColumn.isEmpty() && secondColumn.isEmpty())){
            if(!firstColumn.isEmpty()){
                result.append(firstColumn.pop());
            }
            result.append(spaces);
            if(!secondColumn.isEmpty()){
                result.append(secondColumn.pop());
            }
            result.append("\n");
        }
        return result.toString();
    }


}
