package dataaccess;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorageFactory {

    public static String OUTPUT_DIR = System.getProperty("user.dir") + "\\Library\\src\\dataaccess\\storage\\";

    public static void saveMemebr(LibraryMember libraryMember) {
        try {
            List<LibraryMember> members = new ArrayList<>();
            FileInputStream fix = new FileInputStream(new File(OUTPUT_DIR + "LibraryMember.txt"));
            ObjectInputStream ois = new ObjectInputStream(fix);
            members = (List<LibraryMember>) ois.readObject();
            members.add(libraryMember);
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "LibraryMember.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(members);
            oos.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String txt = "Current Members Are: \n";
            for (LibraryMember member : members) {
                txt = txt + member.getFirstName() + "-" + member.getLastName() + "\n";
            }
            alert.setTitle("Success");
            alert.setHeaderText("Member Created");
            alert.setContentText("Successfully created a Library Member\n" + txt);
            alert.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Write the Initial Value here
     */
    public static void createInitialData() {
        try {

            List<LibraryMember> members = new ArrayList<>();
            LibraryMember member = new LibraryMember();
            member.setMemberId(1L);
            member.setFirstName("Ganbat");
            member.setLastName("Bayar");
            member.setPhoneNumber("123");
            member.setAddress(new Address("1000N 4th Street", "Fairfield", "IA", "52557"));
            members.add(member);
            FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "LibraryMember.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(members);
            oos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
