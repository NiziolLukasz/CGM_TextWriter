package pl.niziol;

public class ConsolePrint {
    public void print(String string, int[] widthOfColumns, TextWarpType wrapType) {
        new Columns().print(string, widthOfColumns, wrapType);
    }
}
