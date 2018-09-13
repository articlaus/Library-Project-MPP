package business;

import dataaccess.Author;
import dataaccess.Book;
import dataaccess.DataStorageFactory;
import dataaccess.Memory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class AddBookController implements Initializable {

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
    	listAuthors.setText(getAuthorList());
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
        
    	List<Book> books = new ArrayList<>();
        for (int i = 0; i < Integer.valueOf(txtCopies.getText()); i++) {
            Book book = new Book();
            book.setCopyNumber(UUID.randomUUID().toString());
            book.setIsbn(txtIsbn.getText());
            book.setNumberOfCopies(Integer.valueOf(txtCopies.getText()));
            book.setTitle(txtTitle.getText());
            book.setCheckOutDay(Integer.valueOf(txtChkDays.getText()));
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

    private void setData() {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
    }
}
