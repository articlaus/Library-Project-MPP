package dataaccess;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8998327748244130113L;
    private String copyNumber;
    private String isbn;
    private List<Author> authors;
    private String title;
    private Boolean availability;
    private Integer numberOfCopies;
    private Integer checkOutDay;

    public Book() {
    }

    public Book(String copyNumber, String isbn, List<Author> authors, String title, Boolean availability, Integer checkOutDay) {
        this.copyNumber = copyNumber;
        this.isbn = isbn;
        this.authors = authors;
        this.title = title;
        this.availability = availability;
        this.checkOutDay = checkOutDay;
    }

    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Integer getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(Integer checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    @Override
    public String toString() {
        return "Book{" +
                "copyNumber='" + copyNumber + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", availability=" + availability +
                ", numberOfCopies=" + numberOfCopies +
                ", checkOutDay=" + checkOutDay +
                '}';
    }
}
