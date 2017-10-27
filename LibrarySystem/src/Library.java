import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; 


public class Library implements Serializable {
	
	private List<Book> collection;
	
	//Просмотр зарегистрированных изданий в фонде
	public Library() {
		collection = new ArrayList<Book>();	
	}
	
	// Добавление нового издания в фонд
	public void addBook(Book book){
		collection.add(book);
	}
	
	@Override
	public String toString() {
		String total = "\n";
//		for (int i = 0; i < collection.size; i++){
//			Book b = collection.get(i);
//			total = total + b.toString();
//		}
		Iterator<Book> i = collection.iterator();
		while(i.hasNext()){
			Book b = (Book) i.next();
			total = total + b.toString();
			
		}
		return total;
		
	}
	
	

}
