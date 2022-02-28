package sentences;

import java.util.List;

public class SentenceTransformer {

    private static final List<Character> PUNCTUATION_MARKS = List.of('.', '!', '?');

    public String shortenSentence(String sentence) {
        validateSentence(sentence);
        String[] temp = sentence.split(" ");
        if (temp.length >= 5) {
            return temp[0] + " ... " + temp[temp.length - 1];
        } else {
            return sentence;
        }
    }

    private void validateSentence(String sentence) {
        if (!Character.isUpperCase(sentence.charAt(0))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        if (!PUNCTUATION_MARKS.contains(sentence.charAt(sentence.length() - 1))) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }
}
