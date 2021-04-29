package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public int addDigits(String input) {
        if (!isValidString(input)) {
            return -1;
        }

        int counter = 0;
        for (Character item : input.toCharArray()) {
            if (Character.isDigit(item)) {
                counter += Integer.parseInt(item.toString());
            }
        }
        return counter;
    }

    private boolean isValidString(String str) {
        return str != null && !str.isEmpty();
    }
}
