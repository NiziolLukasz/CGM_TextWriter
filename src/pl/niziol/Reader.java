package pl.niziol;

public class Reader {
    public String getText(TextReaderType type) {
        if(type == TextReaderType.Console) {
            return new ConsoleReader().read();
        }
        throw new IllegalArgumentException("Illegal TextReaderType: " + type);
    }
}
