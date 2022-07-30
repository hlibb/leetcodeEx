package hw_15;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class bookStatistics {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/hw_15/tolstoy_voyna-i-mir.txt");
        File stats = new File("src/main/java/hw_15/stats.txt");

        if (!stats.exists()) stats.createNewFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        /*
         Зроблено і працює по прикладу, який було показано на слідуючому після цього занятті (ГДЗ)
         */

        /*Map.Entry<String, Long> wordMap;

        wordMap = bufferedReader.lines()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .map(String::trim)
                .map(s ->
                        s.replace("!", "")
                                .replace("?", "")
                                .replace(".", "")
                                .replace(",", "")
                                .replace(":", " ")
                                .replace("-", "")
                )
                .filter(s -> {
                    return !s.contains("росс");
                })
                .filter(s -> s.length() > 3)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .reduce((s, c) -> s.getValue() > c.getValue() ? s : c)
                .get();*/

        /* Моя спроба зробити через класс UniqueWords(String, Long) + WordsStorage який би при додаванні
        однакової строки додавав би до count + 1.
        * */

        WordsStorage words = (WordsStorage) bufferedReader.lines()
        .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .map(String::trim)
                .map(s ->
                        s.replace("!", "")
                                .replace("?", "")
                                .replace(".", "")
                                .replace(",", "")
                                .replace(":", " ")
                                .replace("-", "")
                )
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        PrintWriter printWriter = new PrintWriter(stats);
        String a = words.toString();
        printWriter.write(a);
        System.out.println(a);

    }
}
class UniqueWords {
    String s;
    Long count;

    public UniqueWords(String s, Long count) {
        this.s = s;
        this.count = count;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
class WordsStorage {
    HashSet<UniqueWords> words;

    public WordsStorage(HashSet<UniqueWords> words) {
        this.words = words;
    }

    public void add(UniqueWords uniqueWord) {
        if (words.contains(uniqueWord)) {
            UniqueWords temp = uniqueWord;
            temp.setCount(uniqueWord.getCount() + 1);
            words.remove(uniqueWord);
            words.add(temp);
        }
    }
@Override
    public String toString() {
        for (UniqueWords u : this.words) {
            String s = u.getS() + " = " + u.getCount();
            System.out.println(s);
            return s;
        }
        return "No objects in this string";
    }
}