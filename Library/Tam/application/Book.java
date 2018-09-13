package application;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    private String copyNumber;
    private String isbn;
    private List<Author> authors;
    private String title;
    private Boolean availability;
    private Integer counts;
    private int maxCheckoutDays;

    

    public int getMaxCheckoutDays() {
		return maxCheckoutDays;
	}

	public void setMaxCheckoutDays(int maxCheckoutDays) {
		this.maxCheckoutDays = maxCheckoutDays;
	}

	public Book(String copyNumber, String isbn, List<Author> authors, String title, Boolean availability) {
        this.copyNumber = copyNumber;
        this.isbn = isbn;
        this.authors = authors;
        this.title = title;
        this.availability = availability;
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

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}
