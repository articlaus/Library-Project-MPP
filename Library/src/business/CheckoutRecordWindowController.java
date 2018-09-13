package business;

import dataaccess.Address;
import dataaccess.Author;
import dataaccess.Book;
import dataaccess.CheckoutEntry;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckoutRecordWindowController implements Initializable{

		@FXML private TableView<CheckoutEntry> tblCheckoutRecord;
		@FXML private TableColumn<CheckoutEntry, String> copyNumberCol;
		@FXML private TableColumn<CheckoutEntry, String> checkoutDateCol;
		@FXML private TableColumn<CheckoutEntry, String> dueDateCol;
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// Create list of CheckoutEntry
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
		    Book b1 = new Book("C001", "978-3-598-21500-1", authors, "How to Live", true);
		    Book b2 = new Book("C002", "978-3-598-21500-2", authors, "How to Live 2", true);
		    entries.add(new CheckoutEntry(b1.getCopyNumber(), "08/15/2018", "08/22/2018"));
		    entries.add(new CheckoutEntry(b2.getCopyNumber(), "08/15/2018", "08/22/2018"));
		    //-------
		    
			copyNumberCol.setMinWidth(80);
			copyNumberCol.setEditable(false);
			
			checkoutDateCol.setMinWidth(80);
			checkoutDateCol.setEditable(false);

			dueDateCol.setMinWidth(80);
			dueDateCol.setEditable(false);

			copyNumberCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("copyNumber"));
			checkoutDateCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("checkoutDate"));
			dueDateCol.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("dueDate"));
			
			tblCheckoutRecord.setItems(FXCollections.observableArrayList(entries));
			
		}


		
}
