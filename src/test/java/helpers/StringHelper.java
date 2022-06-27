package helpers;

public class StringHelper {
    public static boolean areWordsEqual(String firstWord, String secondWord, boolean isCaseSensitive) {
        if (firstWord.contains(" ") || secondWord.contains(" "))
            throw new RuntimeException("Parameters contain whitespaces.");
        return isCaseSensitive ? firstWord.equals(secondWord) : firstWord.equalsIgnoreCase(secondWord);
    }

    public static boolean areSentencesEqual(String firstSentence, String secondSentence, boolean isCaseSensitive) {
        return isCaseSensitive ? firstSentence.equals(secondSentence) : firstSentence.equalsIgnoreCase(secondSentence);
    }

    public static int getWordsCountFromText(String text) {
        return text.split(" ").length;
    }

    public static int getCharsCount(String text) {
        return text.length();
    }


    /**
     * Will edit given string if it finds matching
     *
     * @param oldString    char to remove
     * @param charToRemove String for edit
     * @return String
     */
    public static String removeFirstOccurrenceOf(char charToRemove, String oldString) {
        String regex;
        if (!Character.isLetter(charToRemove)) {
            regex = String.format("[\\%c]", charToRemove);
            // Create regex for matching character
            // will remove given non-alphanumeric characters from the string
            return oldString.replaceFirst(regex, "");
        }
        // Create regex for matching character
        regex = String.format("%c+", charToRemove);
        // will replace all occurrences of the regex with a single char
        return oldString.replaceAll(regex, String.valueOf(charToRemove));
    }

    /**
     * Remove all digits from String
     *
     * @param character character to remove
     * @param oldString String for edit
     * @return String
     */
    public static String removeChar(char character, String oldString) {
        String regex;
        // Create regex for matching digit(s) or character(s)
        if (Character.isDigit(character)) {
            regex = String.format("%c+", character);
        } else {
            regex = String.format("\\%c+", character);
        }

        // will remove all digits from the oldString
        return oldString.replaceAll(regex, "");
    }

    /**
     * Remove whitespace before given character
     * @param character character
     * @param text  String
     * @return String
     */
    public static String removeWhitespaceBeforeChar(char character, String text) {
        String regex = String.format("\\s+(?=[^\\%c]?\\%c)", character,character);
        return text.replaceAll(regex, "");
    }

    /**
     * Remove whitespace, if there are more than one consecutive whitespaces
     * @param text  String
     * @return String
     */
    public static String removeWhitespaces(String text) {
        String regex = "\\s{2,}";
        return text.replaceAll(regex," ");
    }
}



