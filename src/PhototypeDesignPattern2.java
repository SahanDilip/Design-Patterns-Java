import java.util.ArrayList;
import java.util.List;

class Book{
    private String bName;
    private int bId;

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    @Override
    public String toString() {
        return "BookShop{" + "bName='" + bName + '\'' + ", bId=" + bId + '}';
    }
}


class BookShop implements Cloneable{
    private String BookshopName;
    List<Book> booklist = new ArrayList<>();

    public String getBookshopName() {
        return BookshopName;
    }

    public void setBookshopName(String bookshopName) {
        BookshopName = bookshopName;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }
    public void loadData(){
        for(int k = 0; k<=10; k++){
            Book bk = new Book();
            bk.setbId(k);
            bk.setbName("Book"+k);
            getBooklist().add(bk);
        }
    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop shop3 = new BookShop();
        for(Book b : this.getBooklist()){
            shop3.getBooklist().add(b);
        }
        return shop3;

    }

    @Override
    public String toString() {
        return "BookShop{" + "BookshopName='" + BookshopName + '\'' + ", booklist=" + booklist + '}';
    }
}


public class PhototypeDesignPattern2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop shop1 = new BookShop();
        shop1.setBookshopName("Sudarshi");
        shop1.loadData();


        //BookShop shop2 = new BookShop();
        BookShop shop2 = shop1.clone();
        shop1.booklist.remove(2);
        shop2.setBookshopName("Malpiyali");
        System.out.println(shop1);
        System.out.println(shop2);
    }

}
