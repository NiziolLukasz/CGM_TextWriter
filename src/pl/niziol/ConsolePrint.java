package pl.niziol;

public class ConsolePrint {
    public void print(String string, int[] widthOfColumns) {
        switch(widthOfColumns.length){
            case 1:
                break;
            case 2:
                new TwoColumns().print(string, widthOfColumns);
                break;
            case 3:
                new ThreeColumns().print(string, widthOfColumns);
                break;

            default: throw new IllegalArgumentException("Illegal number of column: " + widthOfColumns.length);
        }
    }
}
