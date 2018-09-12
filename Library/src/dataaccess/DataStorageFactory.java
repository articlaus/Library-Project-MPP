package dataaccess;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataStorageFactory {

    public static String OUTPUT_DIR = System.getProperty("user.dir") + "\\Library\\src\\dataaccess\\storage\\";
    static String LIB_MEM = "LibraryMember.txt";
    static String BKS = "Book.txt";
    static String AUTH = "Author.txt";

    /**
     * Method that handles every read Operation
     *
     * @param fileName file to read
     * @return read Objects
     */
    private static Object read(String fileName) {
        try {
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + fileName));
            ObjectInputStream ois = new ObjectInputStream(fix);
            return ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Method that writes given object to file for storage
     *
     * @param datas    data to be written
     * @param fileName file to be written to
     */
    public static void write(List datas, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datas);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void saveMemebr(LibraryMember libraryMember) {
        List<LibraryMember> members = (List<LibraryMember>) read(LIB_MEM);
        members.add(libraryMember);
        write(members, LIB_MEM);
        readMember();
    }

    public static void readMember() {
        List<LibraryMember> members = (List<LibraryMember>) read(LIB_MEM);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String txt = "Current Members Are: \n";
        for (LibraryMember member : members) {
            txt = txt + member.getFirstName() + "-" + member.getLastName() + "\n";
        }
        alert.setTitle("Success");
        alert.setHeaderText("Member Created");
        alert.setContentText("Successfully created a Library Member\n" + txt);
        alert.showAndWait();
    }

    public static Book getBookByIsnb(String isbn) {
        List<Book> books = (List<Book>) read(BKS);
        Book ret = null;
        Integer count = 0;
        for (Book book : books) {
            if (book.getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
                ret = book;
                count++;
            }
        }
        if (ret != null)
            ret.setNumberOfCopies(count);
        return ret;
    }

    public static void addCopyBook(Book book) {
        List<Book> books = (List<Book>) read(BKS);
        for (int i = 0; i < book.getNumberOfCopies(); i++) {
            Book bk = book;
            bk.setCopyNumber(UUID.randomUUID().toString());
            books.add(bk);
        }
        write(books, BKS);
    }

    public static void addNewBooks(List<Book> books) {
        write(books, BKS);
        for (Book book : books) {
            System.out.println("Books added -" + book + "\n");
        }
    }


    public static List<Author> getAuthors() {
        return (List<Author>) read(AUTH);

    }

    /**
     * Write the Initial Value here
     */
    public static void createInitialData() {
        //For Library Members
        List<LibraryMember> members = new ArrayList<>();
        LibraryMember member = new LibraryMember();
        member.setMemberId(1L);
        member.setFirstName("Ganbat");
        member.setLastName("Bayar");
        member.setPhoneNumber("123");
        Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
        member.setAddress(add);
        members.add(member);
        write(members, LIB_MEM);

        //Add Books
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        Author auth = new Author();
        auth.setFirstName("Ganbat");
        auth.setLastName("Bayar");
        auth.setAddress(add);
        auth.setShortBio("Decent Author");
        auth.setCredentials("Creds");
        authors.add(auth);
        auth = new Author();
        auth.setFirstName("Dawit");
        auth.setLastName("Habte");
        auth.setAddress(add);
        auth.setShortBio("An Author");
        auth.setCredentials("Creds");
        authors.add(auth);
        books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-1", authors, "How to Live", true));
        books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-2", authors, "How to Live 2", true));
        write(books, BKS);

        //write Authors
        write(authors, AUTH);

    }
}
