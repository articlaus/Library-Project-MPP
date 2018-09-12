package dataaccess;

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
