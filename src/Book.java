import java.io.Serializable;
public class Book implements Serializable {
	
	//Идентификатор записи
	private int isbn;
	//Тип - брошюра, журнал или книга
	private String typeBook;
	//Наименование книги, журнала или брошюры
	private String nameBook;
	//Год издательства, если это книга или же месяц и год издательства в случае журнала или брошюры
	private int year;
	private String month;
	//Количество страниц
	private int paper;
	//Издательство
	private String publisher;
	
	public Book(){
		isbn = 0;
		typeBook = null;
		nameBook = null;
		year = 0;
		month = null;
		paper = 0;
		publisher = null;
	}
	
	public Book(int isbn, String type, String name, int year, String month, int paper, String publisher){
		this.isbn = isbn;
		this.typeBook = type;
		this.nameBook = name;
		this.year = year;
		this.month = month;
		this.paper = paper;
		this.publisher = publisher;
	}
	
	@Override
	public String toString(){
		return "\nИдентификатор: " + isbn + "\nТип: " + typeBook + "\nНаименование: " + nameBook + "\nГод издательства: " + year
				+ "\nМесяц: " + month + "\nСтраниц: " + paper + "\nИздательство: " + publisher + "\n";
	}
}
