package pl.niziol;

public class TextPrinter {
    public void print(String string, TextOutputType outputType, int[] widthOfColumns) {
        if(outputType == TextOutputType.Console) {
            new ConsolePrint().print(string, widthOfColumns);
        }else{
            throw new IllegalArgumentException("Illegal TextReaderType: " + outputType);
        }
    }
}
