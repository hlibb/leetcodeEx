package hw_16;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Catalog {

    Scanner sc = new Scanner(System.in);

    File catalog = new File("src/main/java/hw_16/Bib.txt");

    FileReader catalogReader = new FileReader(catalog);

    BufferedReader bufferedCatalogReader = new BufferedReader(catalogReader);

    List<String> books = new ArrayList<>(Collections.singleton(bufferedCatalogReader.lines().collect(Collectors.joining("\n"))));

    PrintWriter printCatalogWriter = new PrintWriter(catalog);
    String start =
            "________________________\n" +
                    "1 - Add book" +
                    "\n2 - Delete book" +
                    "\n3 - View catalog" +
                    "\n-1 - Exit" +
                    "\n________________________";

    public void deleteFile() throws IOException {
        catalogReader.close();
        bufferedCatalogReader.close();
        printCatalogWriter.close();
        catalog.delete();
    }

    public void loadBooks() {
        bufferedCatalogReader.lines().forEach(books::add);
    }

    public Catalog() throws FileNotFoundException {
    }

    public void add() {
        System.out.println("Enter the new book:");
        String result = sc.nextLine();
        result = result.trim();
        if (result.equals("")) return;
        books.add(result);
        System.out.println("Book is successfully added!");
        System.out.println(start);
    }

    public void delete() throws IOException {
        System.out.println("Enter the book to delete:");
        String temp = sc.nextLine();
        if (books.contains(temp)) {
            books.remove(temp);
            for(String str : books) {
                printCatalogWriter.write(str + System.lineSeparator());
            }
            printCatalogWriter.flush();
            System.out.println("Book is successfully deleted!");
            System.out.println(start);
        } else {
            System.out.println("Book does not exists");
            System.out.println(start);
        }
    }

    public void show() {
        System.out.println("+++++ CATALOG +++++");
        books.forEach(System.out::println);
        System.out.println(start);
    }

    public void uploadBooks() throws IOException {
        if (!catalog.exists()) catalog.createNewFile();
        for(String str : books) {
            printCatalogWriter.write(str + System.lineSeparator());
        }
        printCatalogWriter.flush();
    }
}
