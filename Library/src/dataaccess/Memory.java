package dataaccess;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	private static List<Book> tempBookCollection = new ArrayList<>();
    private static List<Author> tempAuthorCollection = new ArrayList<>();
    
    private static List<Object> tempCollection = new ArrayList<>();
    
    public static List<Book> getBooksFromMemory() {
    	return tempBookCollection;
    }
    
    public static void addBookToMemory(Book book) {
    	tempBookCollection.add(book);
    }
    
    public static void addAuthorToMemory(Author a) {
    	tempAuthorCollection.add(a);
    }
    
    public static List<Author> getAuthoursFromMemory() {
    	return tempAuthorCollection;
    }
    
    public static void addObjectToMem(Object o) {
    	tempCollection.add(o);
    }
    
    public static List<Object> getListFromMem() {
    	return tempCollection;
    }
    
    public static void clearMemory() {
    	//tempBookCollection = new ArrayList<>();
    	//tempAuthorCollection = new ArrayList<>();
    	tempCollection = new ArrayList<>();
    }
}
