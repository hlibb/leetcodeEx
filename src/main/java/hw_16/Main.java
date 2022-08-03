package hw_16;

public class Main {
    public static void main(String[] args) throws Exception {
        Catalog c = new Catalog();
        c.loadBooks();
        do {
            System.out.println(c.start);
            switch (c.sc.nextLine()) {
                case ("1"):
                    c.add();
                    break;

                case ("2"):
                    c.delete();
                    break;

                case ("3"):
                    c.show();
                    break;

                case ("-1"):
                    return;

                default:
                    System.err.println("Unknown error");
                    System.out.println(c.start);
                    break;
            }
        } while (!c.sc.hasNext("-1"));
        c.uploadBooks();
    }
}
