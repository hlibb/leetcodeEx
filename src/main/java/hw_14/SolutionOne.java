package hw_14;
import java.util.*;
import java.util.stream.Stream;

public class SolutionOne {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseAlphabeth = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] alphabeth = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        HashSet<String> entcodedWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char[] wordInCharArr = words[i].toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < wordInCharArr.length; j++) { //['e','e','e'] runs through
                String [] array = words[i].split("");
                for (int k = 0; k < alphabeth.length; k++) {
                    if (Objects.equals(array[j], alphabeth[k])) stringBuilder.append(morseAlphabeth[k]);
                }
            }
            String result = String.valueOf(stringBuilder);
            entcodedWords.add(result);
            //"aaa" -> ['a','a','a'] -> [".-", ".-", ".-"] -> ".-.-.-" -> List.add
        }
        return entcodedWords.size();
    }


    /*String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-",
            "...-",".--","-..-","-.--","--.."};

// COPY-PASTED SOLUTION >>>

    Set<String> seen = new HashSet();
        for (String word: words) {
        StringBuilder code = new StringBuilder();
        for (char c: word.toCharArray())
            code.append(MORSE[c]);
        seen.add(code.toString());
    }
        return seen.size();
}*/

    public static void main(String[] args) {
        String[] words = {"gin","zen","gig","msg"};
        SolutionOne s = new SolutionOne();
        System.out.println(s.uniqueMorseRepresentations(words));
    }
}
