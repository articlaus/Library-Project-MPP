package dataaccess;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutEntry implements Serializable {
    String memberID;
    String isbn;
    String copyNumber;
    String checkoutDate;
    String dueDate;
    String bookTitle;
    String isDue;


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
        SimpleDateFormat smt = new SimpleDateFormat("MM/dd/yyyy");
        Date dueDate = smt.parse(this.dueDate);
        String isDue = "";
        if (System.currentTimeMillis() > dueDate.getTime()) {
            isDue = "overdue";
        }
        return isDue;
    }

    public void setIsDue(String isDue) {
        this.isDue = isDue;
    }
}
