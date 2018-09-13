package business;

import dataaccess.CheckoutEntry;
import dataaccess.DataStorageFactory;
import dataaccess.Memory;
import dataaccess.Role;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CheckoutRecordWindowController implements Initializable {

    @FXML
    private TableView<CheckoutEntry> tblCheckoutRecord;
    @FXML
    private TableColumn<CheckoutEntry, String> copyNumberCol;
    @FXML
    private TableColumn<CheckoutEntry, String> checkoutDateCol;
    @FXML
    private TableColumn<CheckoutEntry, String> dueDateCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create list of CheckoutEntry

        //-------
        List<CheckoutEntry> entries = DataStorageFactory.addInitialCheckOuts();

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

    public void back(ActionEvent event) throws IOException {
        switch(Memory.getRole()) {
            case LIBRARIAN:
                EventHandler.login(event, this, Role.LIBRARIAN);
                break;
            case BOTH:
                EventHandler.login(event, this, Role.BOTH);
                break;
            case ADMIN:
                // this should be unreachable
        }
    }


}
