package pl.niziol;

public class Reader {
    public String getText(TextReaderType type) {
        if(type == TextReaderType.Console) {
            return new ConsoleReader().readLine();
        }
        throw new IllegalArgumentException("Illegal TextReaderType: " + type);
    }
    public int[] readWidthOfColumns(int numberOfColumns, TextReaderType type) {
        if(type == TextReaderType.Console) {
            return new ConsoleReader().readWidthOfColumns(numberOfColumns);
        }
        throw new IllegalArgumentException("Illegal TextReaderType: " + type);
    }

    public int readNumberOfColumns(TextReaderType type){
        if(type == TextReaderType.Console) {
            return new ConsoleReader().readNumberOfColumns();
        }
        throw new IllegalArgumentException("Illegal TextReaderType: " + type);
    }
}
