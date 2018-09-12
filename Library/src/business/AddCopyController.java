package business;

import dataaccess.Author;
import dataaccess.Book;
import dataaccess.DataStorageFactory;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCopyController {

    @FXML
    TextField txtISBN;
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
                lblAvailable.setText(book.getAvailability().toString());
            }
        }
    }


}
