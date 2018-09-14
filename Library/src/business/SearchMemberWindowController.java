package business;

import java.io.IOException;

import dataaccess.DataStorageFactory;
import dataaccess.LibraryMember;
import dataaccess.Memory;
import dataaccess.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    		memberInfo.setText("Member not found." );
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
    void printRecord(ActionEvent event) throws IOException{
    	String memberID = txtMemberID.getText();
    	LibraryMember member = DataStorageFactory.readMember(memberID);
    	if (member != null)
    		System.out.println(member);
    }

}
