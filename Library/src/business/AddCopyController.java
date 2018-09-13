package business;

import java.io.IOException;

import dataaccess.Author;
import dataaccess.Book;
import dataaccess.DataStorageFactory;
import dataaccess.Memory;
import dataaccess.Role;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCopyController {

    Book book;
    @FXML
    TextField txtISBN;
    @FXML
    TextField txtCopies;
    @FXML
    Label lblTitle;
    @FXML
    Label lblAuthors;
    @FXML
    Label lblAvailable;
    @FXML
    Button btnSearch;
    @FXML
    Button btnAdd;

    @FXML
    public void searchBook(Event e) {
        if (txtISBN.getText().length() <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("ISBN Number empty");
            alert.setContentText("You must Enter a ISBN Number to search\n");
            alert.showAndWait();
        } else {
            Book book = DataStorageFactory.getBookByIsnb(txtISBN.getText());
            if (book == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not Found");
                alert.setHeaderText("Book not Found");
                alert.setContentText("Book with the given ISBN wasn't found\n");
                alert.showAndWait();
            } else {
                lblTitle.setText(book.getTitle());
                String authors = "";
                for (Author author : book.getAuthors()) {
                    authors = authors + author.getFirstName() + " " + author.getLastName() + ",";
                }
                lblAuthors.setText(authors);
                lblAvailable.setText(book.getNumberOfCopies() + "");
                this.book = book;
            }
        }
    }

    @FXML
    public void addCopies() {
        if (book == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not Found");
            alert.setHeaderText("Must Search first");
            alert.setContentText("YOu need to select a book first before adding copies\n");
            alert.showAndWait();
        } else {
            if (txtCopies.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Text Empty");
                alert.setHeaderText("# Copies field Empty");
                alert.setContentText("You must enter the number of copies to add\n");
                alert.showAndWait();
            } else {
                book.setNumberOfCopies(Integer.valueOf(txtCopies.getText()));
                DataStorageFactory.addCopyBook(book);
            }
        }

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
