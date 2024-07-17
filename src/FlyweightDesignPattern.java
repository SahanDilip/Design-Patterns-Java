import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Books {
    public final String name;
    public final double price;
    public final Booktype type;

    public Books(String name, double price, Booktype type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}

class Booktype {
    public final String types;
    public final String distributor;
    public final String otherData;

    public Booktype(String types, String distributor, String otherData) {
        this.types = types;
        this.distributor = distributor;
        this.otherData = otherData;
    }
}

class Bookfactory {
    private static final Map<String, Booktype> bookTypes = new HashMap<>();

    private Bookfactory() {}

    public static Booktype getBookType(String types, String distributor, String otherData) {
        if (bookTypes.get(types) == null) {
            bookTypes.put(types, new Booktype(types, distributor, otherData));
        }
        return bookTypes.get(types);
    }
}

class Store {
    private final List<Books> books = new ArrayList<>();

    public List<Books> getBooks() {
        return books;
    }

    public void storeBook(String name, double price, String type, String distributor, String otherData) {
        Booktype booktype = Bookfactory.getBookType(type, distributor, otherData);
        books.add(new Books(name, price, booktype));
    }
}

public class FlyweightDesignPattern {
    public static void main(String[] args) {
        Store store = new Store();
        store.storeBook("The Catcher in the Rye", 10.99, "Fiction", "Penguin Books", "First edition");
        for (Books book : store.getBooks()) {
            System.out.println("Title: " + book.type.types);
            System.out.println("Distributor: " + book.type.distributor);
            System.out.println("OtherData: " + book.type.otherData);
        }
    }
}