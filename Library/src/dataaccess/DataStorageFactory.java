package dataaccess;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataStorageFactory {

    private static String OUTPUT_DIR = System.getProperty("user.dir") + "/Library/src/dataaccess/storage/";
    //    private static String OUTPUT_DIR = "C:/Users/Arti/IdeaProjects/Library-Project-MPP/Library/src/dataaccess/storage";
    private static String LIB_MEM = "LibraryMember.txt";
    private static String BKS = "Book.txt";
    private static String AUTH = "Author.txt";
    private static String EMPL = "Employees.txt";
    private static String CHK = "CheckoutEntry.txt";
    private static String CKR = "CheckoutRecord.txt";

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
            Object ob = ois.readObject();
            ois.close();
            return ob;
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
    public static void write(List<?> datas, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datas);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void saveMember(LibraryMember libraryMember) {
        @SuppressWarnings("unchecked")
        List<LibraryMember> members = (List<LibraryMember>) read(LIB_MEM);
        members.add(libraryMember);
        write(members, LIB_MEM);
        displayMembers();
    }

    public static void displayMembers() {
        @SuppressWarnings("unchecked")
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

    public static LibraryMember readMember(String memberID) {
        List<LibraryMember> members = (List<LibraryMember>) read(LIB_MEM);
        for (LibraryMember m : members) {
            if (m.getMemberId().equals(Long.valueOf(memberID)))
                return m;
        }
        return null;
    }

    public static List<CheckoutEntry> getCheckoutEntries(Long id) {
        List<CheckoutRecord> checkoutRecords = (List<CheckoutRecord>) read(CKR);
        for (CheckoutRecord checkoutRecord : checkoutRecords) {
            if (checkoutRecord.getMemberId().equals(id)) {
                return checkoutRecord.getEntryList();
            }
        }
        return null;
    }

    public static List<LibraryMember> getMembers() {
        List<LibraryMember> members = (List<LibraryMember>) read(LIB_MEM);
        return members;
    }

    public static Book getBookByIsnb(String isbn) {
        @SuppressWarnings("unchecked")
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

    public static List<Book> getBooksByIsnb(String isn) {
        List<Book> books = (List<Book>) read(BKS);
        List<Book> ret = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().toLowerCase().equals(isn.toLowerCase())) {
                ret.add(book);
            }
        }
        return ret;
    }

    public static void addCopyBook(Book book) {
        @SuppressWarnings("unchecked")
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


    @SuppressWarnings("unchecked")
    public static List<Author> getAuthors() {
        return (List<Author>) read(AUTH);

    }

    @SuppressWarnings("unchecked")
    public static List<Employee> getEmployees() {
        return (List<Employee>) read(EMPL);
    }


    public static List<CheckoutEntry> getCheckoutEntryList(String txtFileName) {
        try {
            List<CheckoutEntry> objects = (List<CheckoutEntry>) read(CHK);
            return objects;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<CheckoutEntry> getCheckoutEntryByIsbn(String isbn) {
        try {
            List<CheckoutEntry> entries = (List<CheckoutEntry>) read(CHK);
            List<CheckoutEntry> rEntries = new ArrayList<>();
            CheckoutEntry ret = null;
            Integer count = 0;
            for (CheckoutEntry entry : entries) {
                if (entry.getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
                    ret = entry;
                    rEntries.add(ret);
                    count++;
                }
            }
            return rEntries;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void addCheckoutEntry(CheckoutEntry entry) {
        try {
            List<CheckoutEntry> ces = (List<CheckoutEntry>) read(CHK);
            ces.add(entry);
            write(ces, CHK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static CheckoutRecord checkoutRecords(Long id) {
        List<CheckoutRecord> records = (List<CheckoutRecord>) read(CKR);
        for (CheckoutRecord record : records) {
            if (record.getMemberId().equals(id))
                return record;
        }
        return null;
    }

    public static void addRecord(CheckoutRecord record) {
        List<CheckoutRecord> records = (List<CheckoutRecord>) read(CKR);
        for (CheckoutRecord checkoutRecord : records) {
            if (checkoutRecord.memberId.equals(record.memberId)) {
                records.remove(checkoutRecord);
                records.add(record);
            }
        }
        write(records, CKR);
    }


    /**
     * Write the Initial Value file
     */
    public static void createInitialData() {

        // Create three different employees
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("user1", "pass1", Role.LIBRARIAN);
        Employee e2 = new Employee("user2", "pass2", Role.ADMIN);
        Employee e3 = new Employee("user3", "pass3", Role.BOTH);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        write(employees, EMPL);

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
        books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-1", authors, "How to Live", true, 21));
        books.add(new Book(UUID.randomUUID().toString(), "978-3-598-21500-2", authors, "How to Live 2", true, 7));
        write(books, BKS);
        write(authors, AUTH);
//        readCk();
    }


    private static void readCk() {
        try {
            Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
            List<Author> authors = new ArrayList<>();
            Author auth = new Author();
            auth.setFirstName("Ganbat");
            auth.setLastName("Bayar");
            auth.setAddress(add);
            auth.setShortBio("Decent Author");
            auth.setCredentials("Creds");
            authors.add(auth);
            List<CheckoutEntry> entries = new ArrayList<>();
            Book b1 = new Book(UUID.randomUUID().toString(), "978-3-598-21500-1", authors, "How to Live", true, 21);
            Book b2 = new Book(UUID.randomUUID().toString(), "978-3-598-21500-2", authors, "How to Live 2", true, 7);
            entries.add(new CheckoutEntry("1", "978-3-598-21500-2", "Book", b1.getCopyNumber(), "08/15/2018", "08/22/2018"));
            entries.add(new CheckoutEntry("1", "978-3-598-21500-2", "Book", b1.getCopyNumber(), "08/15/2018", "08/22/2018"));
            CheckoutRecord checkoutRecord = new CheckoutRecord(1L, entries);
            List<CheckoutRecord> checkoutRecords = new ArrayList<>();
            checkoutRecords.add(checkoutRecord);
            write(entries, CHK);
            write(checkoutRecords, CKR);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateAvailabilityOfBook(String isbn, boolean availability) {
        try {
            List<Book> books = (List<Book>) read(BKS);
            for (Book b : books)
                if (b.getIsbn().equals(isbn))
                    b.setAvailability(availability);
            write(books, BKS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<CheckoutEntry> addInitialCheckOuts() {
        try {
            return (List<CheckoutEntry>) read(CHK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
