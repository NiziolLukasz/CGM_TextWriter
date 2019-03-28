package pl.niziol;

public class TextPrinter {
    public void print(String string, TextOutputType outputType, int[] widthOfColumns, TextWarpType wrapType) {
        if(outputType == TextOutputType.Console) {
            new ConsolePrint().print(string, widthOfColumns, wrapType);
        }else{
            throw new IllegalArgumentException("Illegal TextReaderType: " + outputType);
        }
    }
}
