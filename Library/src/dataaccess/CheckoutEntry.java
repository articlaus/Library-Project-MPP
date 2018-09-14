package dataaccess;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutEntry implements Serializable {

    private static final long serialVersionUID = -8381203775279850403L;
    String memberID;
    String isbn;
    String copyNumber;
    String checkoutDate;
    String dueDate;
    String bookTitle;


    public CheckoutEntry(String memberID, String isbn, String bookTitle, String copyNumber, String checkoutDate, String dueDate) {
        this.memberID = memberID;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.copyNumber = copyNumber;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    public CheckoutEntry(String copyNumber, String checkoutDate, String dueDate) {
        this.copyNumber = copyNumber;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCopyNumber(Book book) {
        return book.getCopyNumber();
    }

    public String getIsDue() throws ParseException {
        SimpleDateFormat smt = new SimpleDateFormat("dd/MM/yyyy");
        Date dueDate = smt.parse(this.dueDate);
        String isDue = "";
        if (System.currentTimeMillis() > dueDate.getTime()) {
            System.out.println(this.dueDate + "\n");
            System.out.println(dueDate.getTime() + "- Due\n");
            System.out.println(System.currentTimeMillis() + "-current");
            isDue = "overdue";
        } else {
            isDue = "Not Overdue";
        }
        return isDue;
    }

    @Override
    public String toString() {
        return bookTitle + '\t' + isbn + '\t' + copyNumber + '\t' + checkoutDate + '\t' + dueDate + '\t';
    }
}
