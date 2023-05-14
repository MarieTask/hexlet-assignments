package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String input;

    public ReversedSequence (String input) {
        this.input = reverse(input);
    }

    public static String reverse(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        return stringBuilder.reverse().toString();
    }

    @Override
    public int length() {
        return input.length();
    }

    @Override
    public char charAt(int index) {
        return input.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return input.substring(start, end);
    }
}
// END
