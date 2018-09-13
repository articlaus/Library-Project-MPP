package application;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class DataStorageFactory {

    public static String OUTPUT_DIR = System.getProperty("user.dir") + "/src/storage/";

    public static void saveMemebr(LibraryMember libraryMember) {
        try {
            List<LibraryMember> members;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "LibraryMember.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            members = (List<LibraryMember>) ois.readObject();
            members.add(libraryMember);
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "LibraryMember.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(members);
            oos.close();
            readMember();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readMember() {
        try {
            List<LibraryMember> members;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "LibraryMember.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            members = (List<LibraryMember>) ois.readObject();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String txt = "Current Members Are: \n";
            for (LibraryMember member : members) {
                txt = txt + member.getFirstName() + "-" + member.getLastName() + "\n";
            }
            alert.setTitle("Success");
            alert.setHeaderText("Member Created");
            alert.setContentText("Successfully created a Library Member\n" + txt);
            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Book getBookByIsnb(String isbn) {
        try {
            List<Book> books;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "Book.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            books = (List<Book>) ois.readObject();
            Book ret = null;
            Integer count = 0;
            for (Book book : books) {
                if (book.getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
                    ret = book;
                    count++;
                }
            }
            if (ret != null)
                ret.setCounts(count);
            return ret;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void addBook(Book book) {
        try {
            List<Book> books;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "Book.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            books = (List<Book>) ois.readObject();
            for (int i = 0; i < book.getCounts(); i++) {
                Book bk = book;
                bk.setCopyNumber(UUID.randomUUID().toString());
                books.add(bk);
            }
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "Book.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Write the Initial Value here
     */
    public static void createInitialData() {
        try {
            //For Library Members
            List<LibraryMember> members = new ArrayList<>();
            LibraryMember member = new LibraryMember();
            member.setMemberId("M001");
            member.setFirstName("Ganbat");
            member.setLastName("Bayar");
            member.setPhoneNumber("123");
            Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
            member.setAddress(add);
            members.add(member);
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "LibraryMember.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(members);
            oos.close();

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
            books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-1", authors, "How to Live", true));
            books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-2", authors, "How to Live 2", true));
            fos = new FileOutputStream(OUTPUT_DIR + "Book.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.close();

            //Add CheckoutEntry
            List<CheckoutEntry> entries = new ArrayList<>();
            Book b1 = new Book(UUID.randomUUID().toString(), "978-3-598-21500-1", authors, "How to Live", true);
            Book b2 = new Book(UUID.randomUUID().toString(), "978-3-598-21500-2", authors, "How to Live 2", true);
            entries.add(new CheckoutEntry(b1.getCopyNumber(), "08/15/2018", "08/22/2018"));
            entries.add(new CheckoutEntry(b2.getCopyNumber(), "08/15/2018", "08/22/2018"));
            fos = new FileOutputStream(OUTPUT_DIR + "CheckoutEntry.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(entries);
            oos.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static List<CheckoutEntry> getCheckoutEntryList(String txtFileName){
   	 try {
            List<CheckoutEntry> objects;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + txtFileName));
            ObjectInputStream ois = new ObjectInputStream(fix);
            objects = (List<CheckoutEntry>) ois.readObject();
            return objects;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
   }
    
    public static CheckoutEntry getCheckoutEntryByIsbn(String isbn) {
        try {
            List<CheckoutEntry> entries;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "CheckoutEntry.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            entries = (List<CheckoutEntry>) ois.readObject();
            CheckoutEntry ret = null;
            Integer count = 0;
            for (CheckoutEntry entry : entries) {
                if (entry.getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
                    ret = entry;
                    count++;
                }
            }
            return ret;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void addCheckoutEntry(CheckoutEntry entry) {
        try {
            List<CheckoutEntry> ces;
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "CheckoutEntry.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            ces = (List<CheckoutEntry>) ois.readObject();
            ces.add(entry);
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "CheckoutEntry.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ces);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
//    public static List<Objects> getObjectList(String txtFileName){
//    	 try {
//             List<Objects> objects;
//             FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + txtFileName));
//             ObjectInputStream ois = new ObjectInputStream(fix);
//             objects = (List<Objects>) ois.readObject();
//             return objects;
//         } catch (Exception ex) {
//             ex.printStackTrace();
//             return null;
//         }
//    }
}
