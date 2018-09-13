

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CheckoutWindowController implements Initializable{
		private String mem = "M001";
		private String isbn = "11111";
		private boolean available = true;
		List<LibraryMember> members;

		@FXML
		private TextField txtMemberID;
		
		@FXML
		private TextField txtIsbn;
		
		@FXML 
		private Button btnCheckout;
		
		@FXML
		private Label lblMessage;
		
	    @FXML
	    void btnCheckoutHandle(ActionEvent event) throws IOException {
	    		String memID = txtMemberID.getText();
	    		String isbn = txtIsbn.getText();
	    			if(!checkMemberIdExist(memID))
	    			{
	    				lblMessage.setText("Member ID doesn't exist");
	    			} 
	    			else
	    			{
	    				if(!checkBookExist(isbn))
	    				{
	    					lblMessage.setText("The book is not available");
	    				}
	    				else
	    				{
	    					//Book b = DataStorageFactory.getBookByIsnb(isbn);
	    			    	Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
	    		            List<Author> authors = new ArrayList<>();
	    		            Author auth = new Author();
	    		            auth.setFirstName("Ganbat");
	    		            auth.setLastName("Bayar");
	    		            auth.setAddress(add);
	    		            auth.setShortBio("Decent Author");
	    		            auth.setCredentials("Creds");
	    		            authors.add(auth);
	    			    	Book b = new Book("C001", "11111", authors, "MPP", true);
	    			    	//----------
	    					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	    					Date date = new Date();  
	    					Calendar c = Calendar.getInstance();
	    					c.setTime(date);  
	    					c.add(Calendar.DATE, b.getMaxCheckoutDays());
	    					CheckoutEntry ce = new CheckoutEntry(memID, isbn, b.getTitle(), b.getCopyNumber(),formatter.format(date), formatter.format(c.getTime()));
	    					//DataStorageFactory.updateAvailabilityOfBook(isbn, false);
	    					//DataStorageFactory.addCheckoutEntry(ce);
	    					application.EventHandlers.addCheckoutEntry(event, this);
	    				}
	    			}
	            }
	    
	    boolean checkMemberIdExist(String memberID) {
	    	for(LibraryMember m : members)
	    	{
	    		if(m.getMemberId().equals(memberID))
	    			return true;
	    	}
	    	return false;
	    }
	    
	    boolean checkBookExist(String isbn) {
	    	//Book b = DataStorageFactory.getBookByIsnb(isbn);
	    	Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
            List<Author> authors = new ArrayList<>();
            Author auth = new Author();
            auth.setFirstName("Ganbat");
            auth.setLastName("Bayar");
            auth.setAddress(add);
            auth.setShortBio("Decent Author");
            auth.setCredentials("Creds");
            authors.add(auth);
	    	Book b = new Book("C001", "11111", authors, "MPP", true);
	    	//----------
	    	return b.getAvailability();
	    }



		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
				// Create list of member
				members = new ArrayList<>();
	            LibraryMember member = new LibraryMember();
	            member.setMemberId("M001");
	            member.setFirstName("Ganbat");
	            member.setLastName("Bayar");
	            member.setPhoneNumber("123");
	            Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
	            member.setAddress(add);
	            members.add(member);
		}
}
