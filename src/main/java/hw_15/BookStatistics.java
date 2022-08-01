package hw_15;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BookStatistics {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/hw_15/tolstoy_voyna-i-mir.txt");

        File stats = new File("src/main/java/hw_15/stats.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PrintWriter printWriter = new PrintWriter(stats);

        File temp = new File("src/main/java/hw_15/temp.txt");
        FileReader fileReaderTemp = new FileReader(temp);
        BufferedReader bufferedReaderStats = new BufferedReader(fileReaderTemp);
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
                                .replace("«", "")
                                .replace("»", "")
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

        bufferedReaderStats.lines()
                .sorted()
                .forEach(s -> printWriter.write(s + "\n"));

    }
}
