package pl.niziol;

import java.util.LinkedList;

public class Columns {

    public void print(String inputtedText, int[] widthOfColumns, TextWarpType wrapType) {
        System.out.println(getText(inputtedText, widthOfColumns, wrapType));
    }

    private String getText(String inputtedText, int[] widthOfColumns, TextWarpType wrapType) {
        LinkedList<String> wordsList = new StringConverter().convertToStringList(inputtedText);
        int[] indexes = findLastIndexes(wordsList, inputtedText.length(), widthOfColumns);
        LinkedList<LinkedList<String>> columns = getAllColumns(wordsList, wrapType, widthOfColumns, indexes);
        StringBuilder result = organizeColumns(columns, widthOfColumns);

        return result.toString();
    }

    private StringBuilder organizeColumns(LinkedList<LinkedList<String>> columns, int[] widthOfColumns) {
        Column column = new Column();
        StringBuilder result = new StringBuilder();
        for (int i = 0;; i++) {
            if(!columns.get(i).isEmpty()){
                result.append(columns.get(i).pop());
            } else {
                result.append(column.getSpaces(widthOfColumns[i]));
            }
            result.append(column.getSpaces(Constants.SPACE_BETWEEN_COLUMNS));

            if(i == columns.size() - 1){
                for (int j = 0; j < columns.size(); j++) {
                    if(!columns.get(j).isEmpty()){
                        break;
                    }else if(j == columns.size() - 1){
                        return result;
                    }
                }
                i = -1;
                result.append("\n");
            }
        }
    }

    private LinkedList<LinkedList<String>> getAllColumns(LinkedList<String> wordsList, TextWarpType wrapType, int[] widthOfColumns, int[] indexes) {
        LinkedList<LinkedList<String>> columns = new LinkedList<>();
        Column column = new Column();

        columns.add(column.getColumn(wordsList, wrapType, widthOfColumns[0], indexes[0], indexes[1]));
        for (int i = 1; i < widthOfColumns.length; i++) {
            columns.add(column.getColumn(wordsList, wrapType, widthOfColumns[i], indexes[i] + 1, indexes[i + 1]));
        }
        return columns;
    }

    private int[] findLastIndexes(LinkedList<String> wordsList, int stringLength, int[] widthOfColumns) {
        int[] indexes = new int[widthOfColumns.length + 1];
        Column column = new Column();
        indexes[0] = 0;
        for (int i = 1; i < widthOfColumns.length; i++) {
            indexes[i] = column.findIndexOfLastWordInColumn(wordsList, indexes[i - 1], stringLength, widthOfColumns[i - 1], widthOfColumns.length);
        }
        indexes[indexes.length - 1] = wordsList.size() - 1;
        return indexes;
    }
}