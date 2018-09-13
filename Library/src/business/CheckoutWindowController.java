package business;

import dataaccess.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class CheckoutWindowController implements Initializable {
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
    void btnCheckoutHandle(ActionEvent event) {
        String memID = txtMemberID.getText();
        String isbn = txtIsbn.getText();
        if (!checkMemberIdExist(memID)) {
            lblMessage.setText("Member ID doesn't exist");
        } else {
            if (!checkBookExist(isbn)) {
                lblMessage.setText("The book is not available");
            } else {
                Book b = DataStorageFactory.getBookByIsnb(isbn);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, b.getCheckOutDay());
                CheckoutEntry ce = new CheckoutEntry(memID, isbn, b.getTitle(), b.getCopyNumber(), formatter.format(date), formatter.format(c.getTime()));
                DataStorageFactory.addCheckoutEntry(ce);
                System.out.println("A new entry is added");
                //*****	  popup the CheckoutRecord window
            }
        }


    }


    boolean checkMemberIdExist(String memberID) {
        for (LibraryMember m : members) {
            if (m.getMemberId().equals(memberID))
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
        return b.getAvailability();
    }
    
    @FXML
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Create list of member
        members = new ArrayList<>();
        LibraryMember member = new LibraryMember();
        member.setMemberId("2");
        member.setFirstName("Ganbat");
        member.setLastName("Bayar");
        member.setPhoneNumber("123");
        Address add = new Address("1000N 4th Street", "Fairfield", "IA", "52557");
        member.setAddress(add);
        members.add(member);
    }
}
