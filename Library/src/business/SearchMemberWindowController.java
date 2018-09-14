package business;

import java.io.IOException;
import java.util.List;

import dataaccess.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchMemberWindowController {

    @FXML
    private TextField txtMemberID;

    @FXML
    private Label memberInfo;

    @FXML
    void searchMember(ActionEvent event) throws IOException {
        //EventHandler.searchMember(event, this);

        String memberID = txtMemberID.getText();
        LibraryMember member = DataStorageFactory.readMember(memberID);
        if (member == null)
            memberInfo.setText("Member not found.");
        else
            memberInfo.setText(member.toString());
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
    	switch (Memory.getRole()) {
        case LIBRARIAN:
            EventHandler.login(event, this, Role.LIBRARIAN);
            break;
        case BOTH:
            EventHandler.login(event, this, Role.BOTH);
            break;
        case ADMIN:
            EventHandler.login(event, this, Role.ADMIN);
            break;
    	}
   }

    @FXML
    void printRecord(ActionEvent event) throws IOException {
        String memberID = txtMemberID.getText();

        if (memberID.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Please Enter ID");
            alert.setContentText("Please enter Member id to search\n");
            alert.showAndWait();
        } else {

            List<CheckoutEntry> entries = DataStorageFactory.getCheckoutEntries(Long.valueOf(memberID));
            if (entries == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Record not found");
                alert.setHeaderText("No checkout Records Fount");
                alert.setContentText("No Records found please try again with different user\n");
                alert.showAndWait();
            } else {
                String txt = "This Members Checkout Record is \n";
                txt += "Book Title \t ISBN \n Copy Number\t Checkout Date\t Due Date";

                for (CheckoutEntry entry : entries) {
                    txt = txt + "\n" + entry.toString();
                }
                memberInfo.setText(txt);
                System.out.println(txt);
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Checkout records");
//            alert.setHeaderText("Memeber Records");
//            alert.setContentText(txt);
//            alert.showAndWait();
            }
        }
    }

}
