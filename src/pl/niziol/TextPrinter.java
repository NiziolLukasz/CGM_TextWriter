package pl.niziol;

public class TextPrinter {
    public void print(String string, TextOutputType outputType, TextPrintType printType) {
        if(outputType == TextOutputType.Console) {
            new ConsolePrint().print(string, printType);
        }else{
            throw new IllegalArgumentException("Illegal TextReaderType: " + outputType);
        }
    }
}
