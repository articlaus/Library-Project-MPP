package business;

import dataaccess.Author;
import dataaccess.Book;
import dataaccess.DataStorageFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class AddBookController implements Initializable {

    @FXML
    TextField txtTitle;

    @FXML
    TextField txtIsbn;

    @FXML
    TextField txtChkDays;
    @FXML
    TextField txtCopies;
    @FXML
    Label lblAuths;
    @FXML
    ComboBox cmbAuth;

    List<Author> authors = new ArrayList<>();

    @FXML
    public void addAuthor() {
        if (cmbAuth.getValue() != null) {
            if (authors.contains(cmbAuth.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Already Exist");
                alert.setHeaderText("Selected Author exist");
                alert.setContentText("The Author is already added, please select different one\n");
                alert.showAndWait();
            } else {
                authors.add((Author) cmbAuth.getValue());
                StringBuilder str = new StringBuilder();
                for (Author author : authors) {
                    str.append(author.toString()).append(", ");
                }
                lblAuths.setText(str.toString());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Non Selected");
            alert.setHeaderText("Must Select an Author");
            alert.setContentText("Please select an Author from the List\n");
            alert.showAndWait();
        }
    }

    @FXML
    public void addBook() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < Integer.valueOf(txtCopies.getText()); i++) {
            Book book = new Book();
            book.setCopyNumber(UUID.randomUUID().toString());
            book.setAuthors(authors);
            book.setIsbn(txtIsbn.getText());
            book.setNumberOfCopies(Integer.valueOf(txtCopies.getText()));
            book.setTitle(txtTitle.getText());
            book.setCheckOutDay(Integer.valueOf(txtChkDays.getText()));
            books.add(book);
        }

//        book.setAvailability();
        DataStorageFactory.addNewBooks(books);
    }

    private void setData() {
        List<Author> autnors = DataStorageFactory.getAuthors();
        cmbAuth.getItems().clear();
        cmbAuth.getItems().addAll(autnors);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
    }
}
