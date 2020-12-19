package subway.view;

public class OutputView {
    private static final int START_INDEX = 0;

    private final StringBuilder sb;

    public OutputView(StringBuilder sb) {
        this.sb = sb;
    }

    public void printOptions(String[] strings) {
        sb.append(Prefix.ENTER.getPrefix());
        for (String string : strings) {
            sb.append(string).append(Prefix.ENTER.getPrefix());
        }
        sb.append(Prefix.ENTER.getPrefix());
        sb.append(Prefix.CHOOSE_FUNCTION.getPrefix());
        System.out.println(sb.toString());
        clearSb();
    }

    public void printSharp(String text) {
        sb.append(Prefix.ENTER.getPrefix());
        sb.append(Prefix.SHARP.getPrefix());
        sb.append(text);

        System.out.println(sb.toString());
        clearSb();
    }

    private void clearSb() {
        sb.delete(START_INDEX, sb.length());
    }
}
