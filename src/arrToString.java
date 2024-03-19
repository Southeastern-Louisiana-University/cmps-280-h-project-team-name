public class arrToString {
    public String arrToString(char[] word) {
        String s = "";
        for (int i: word) {
            s += (char)i;
        }

        return s;
    }
}
