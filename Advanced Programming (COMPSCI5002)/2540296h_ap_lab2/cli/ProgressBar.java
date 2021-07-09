package cli;

public class ProgressBar {
    public static String get(double v) {
        String text = "|";
        boolean first = true;
        int div = 4;
        for (int i = 0; i < 100/div; i++) {
            if (i < v/div) {
                text += "=";
            } else {
                if (first) {
                    text += ">";
                    first = false;
                } else {
                    text += " ";
                }
            }
        }
        text += "| " + ((int) v+1) + "%\r";
        return text;
    }
}
