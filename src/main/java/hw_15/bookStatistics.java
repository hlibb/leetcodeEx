package hw_15;

import java.io.*;
import java.sql.SQLOutput;
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
        PrintWriter printWriter = new PrintWriter(stats);

        /*
         Зроблено і працює по прикладу, який було показано на слідуючому після цього занятті (ГДЗ) але з доробками
         */

        File temp = new File("src/main/java/hw_15/temp.txt");
        temp.createNewFile();
        PrintWriter tempWriter = new PrintWriter(temp);

        Map.Entry<String, Long> wordMap;

        bufferedReader.lines()
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
                                .replace("[", " ")
                                .replace("]", " ")
                                .replace("(", "")
                                .replace(")", "")
                                .replace("»", "")
                                .replace("«", "")
                                .replace("…", "")
                                .replace("„", "")
                )
                .filter(s -> {
                    return !s.contains("росс");
                })
                .filter(s -> s.length() > 3)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((s, aLong) -> {
                    tempWriter.write("--> " + s + " <-- " + aLong + "\n");
                });

        FileReader fileReaderTemp = new FileReader(temp);
        BufferedReader bufferedReaderStats = new BufferedReader(fileReaderTemp);
        bufferedReaderStats.lines()
                .sorted()
                .forEach(s -> printWriter.write(s + "\n"));

        temp.delete();

                /*.entrySet()
                .stream()
                .sorted()
                //.reduce((s, c) -> s.getValue() > c.getValue() ? s : c)
                //.get();
                .collect(Collectors.toList());

 Моя спроба зробити через класс UniqueWords(String, Long) + WordsStorage який би при додаванні
        однакової строки додавав би до count + 1.

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
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

    }
}
/*
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
}*/
