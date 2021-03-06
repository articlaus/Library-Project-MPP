package business;

import dataaccess.Author;
import dataaccess.Book;
import dataaccess.DataStorageFactory;
import dataaccess.Memory;
import dataaccess.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddBookController {

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtChkDays;
    
    @FXML
    private TextField txtCopies;
    
    @FXML
    private Label listAuthors;
        
    @FXML
    private Button btnPlus;
    
    @FXML
    private Button btnSave;
    

    List<Author> authors = new ArrayList<>();

    @FXML
    public void addAuthor(ActionEvent event) throws IOException {
    	EventHandler.addAuthor(event, this);
    	authors = convertToAuthorList(Memory.getListFromMem());
    	String list = getAuthorList();
    	listAuthors.setText(list);
    }
    
    private String getAuthorList() {
    	String formattedList = "";
    	for(Author a : authors) {
    		formattedList += a.getFirstName() + " " + a.getLastName() + "\n";
    	}
    	return formattedList;
    }

    @FXML
    public void addBook() {
    	Memory.clearMemory();					// clear memory 
    	int numCopies;
    	// check format
    	try {
    		numCopies = Integer.valueOf(txtCopies.getText());
    	} catch (NumberFormatException e) {
        	EventHandler.displayErrorMessage("Error", "Number of copies should be a number");
        	return;
        }
    	
    	List<Book> books = new ArrayList<>();
        for (int i = 0; i < numCopies; i++) {
            Book book = new Book();
            
            // Create and add title
            String title = txtTitle.getText();
            if (title.isEmpty()) {
            	EventHandler.displayErrorMessage("No Title", "Book should have a title");
            	return;
            }
            book.setTitle(title);
            
            // Ensure maximum checkout date is in proper format
            try {
            	book.setCheckOutDay(Integer.valueOf(txtChkDays.getText()));
            } catch (NumberFormatException e) {
            	EventHandler.displayErrorMessage("Error", "Max Checkout Days should be a number");
            	return;
            }
            
            book.setCopyNumber(UUID.randomUUID().toString());
            book.setIsbn(txtIsbn.getText());
            book.setNumberOfCopies(numCopies);
            book.setAuthors(authors);
            books.add(book);
            book.setAvailability(true);
        }
        DataStorageFactory.addNewBooks(books);
    }
    
    // convert collection to list of authors
    private List<Author> convertToAuthorList (List<Object> collection) {
    	List<Author> list = new ArrayList<>();
    	for(Object o : collection) {
    		list.add((Author)o);
    	}
    	return list;
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
    	switch(Memory.getRole()) {
    	case BOTH:
    		EventHandler.login(event, this, Role.BOTH);
    		break;
    	case ADMIN:
    		EventHandler.login(event, this, Role.ADMIN);
    		break;
    	case LIBRARIAN:
    		// should be unreachable
    		break;
    	}
    }
}
