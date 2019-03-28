package pl.niziol;

public class ConsolePrint {
    public void print(String string, TextPrintType printType) {
        if(printType == TextPrintType.TwoColumns) {
            new TwoColumns().print(string);
        }else if (printType == TextPrintType.ThreeColumns){
            new ThreeColumns().print(string);
        }
        else{
            throw new IllegalArgumentException("Illegal TextReaderType: " + printType);
        }
    }
}
