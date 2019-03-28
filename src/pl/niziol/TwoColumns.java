package pl.niziol;

import java.util.LinkedList;

public class TwoColumns {

    public void print(String inputtedText, int[] widthOfColumns, TextWarpType wrapType) {
        System.out.println(getText(inputtedText, widthOfColumns, wrapType));
    }

    private String getText(String inputtedText, int[] widthOfColumns, TextWarpType wrapType) {
        Column column = new Column();
        StringBuilder result = new StringBuilder();

        LinkedList<String> wordsList = new StringConverter().convertToStringList(inputtedText);
        String spaces = column.getSpaces(Constants.SPACE_BETWEEN_COLUMNS);
        int indexOfLastWordInFirstColumn = column.findIndexOfLastWordInColumn(wordsList, 0, inputtedText.length(), widthOfColumns[0], widthOfColumns.length);

        LinkedList<String> firstColumn = column.getColumn(wordsList, wrapType, widthOfColumns[0], 0, indexOfLastWordInFirstColumn);
        LinkedList<String> secondColumn = column.getColumn(wordsList, wrapType, widthOfColumns[1], indexOfLastWordInFirstColumn + 1, wordsList.size() - 1);

        while (!(firstColumn.isEmpty() && secondColumn.isEmpty())) {
            if (!firstColumn.isEmpty()) {
                result.append(firstColumn.pop());
            } else {
                result.append(column.getSpaces(widthOfColumns[0]));
            }
            result.append(spaces);
            if (!secondColumn.isEmpty()) {
                result.append(secondColumn.pop());
            }
            result.append("\n");
        }
        return result.toString();
    }


}
