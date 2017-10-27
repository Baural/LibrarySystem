import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManageSystem {

	static String fileName = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String[] args) {
		while (running) {
			// Осуществлять вывод меню доступных команд
			System.out.println("\nВведите 0 для загрузки полного списка библиотечного фонда"
			// Выход
					+ "\nВведите 1 для сохранения и выхода"
					// Просмотр зарегистрированных изданий в фонде
					+ "\nВведите 2 чтобы увидеть полный список изданий в библиотечном фонде"
					// Добавление нового издания в фонд
					+ "\nВведите 3 для добавления информации об издании в библиотечный фонд");
			// Просмотр информации выбранного издания
			// Удаление выбранного издания
			
			int answer = in.nextInt();
			switch (answer) {
			case 0:
				System.out.println("Enter the file name to load");
				loadScript(in.next());	
				break;
				
			case 1:
				saveAndQuit();
				break;
			case 2:
				System.out.println(lib.toString());
				break;
			case 3:
				addBook();
				break;
			}

		}
		System.exit(0);

	}

	private static void addBook() {
		// TODO Auto-generated method stub
		
		int isbn;
		String typeBook;
		String nameBook;
		int year;
		String month;
		int paper;
		String publisher;
		
		System.out.println("Введите ISBN: ");
		isbn = in.nextInt();
		
		System.out.println("Введите тип: ");
		typeBook = in.next();
		
		System.out.println("Введите название/наименование: ");
		nameBook = in.next();
		
		System.out.println("Введите год издания: ");
		year = in.nextInt();
		
		System.out.println("Введите месяц: ");
		month = in.next();
		
		System.out.println("Введите количество страниц: ");
		paper = in.nextInt();
		
		System.out.println("Введите название издательства: ");
		publisher = in.next();
		
		Book b = new Book(isbn, typeBook, nameBook, year, month, paper, publisher);
		lib.addBook(b);
		
	}

	private static void saveAndQuit() {
		System.out.println("Введите, пожалуйста, название файла: ");
		fileName = in.next() + ".ser ";
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void loadScript(String name) {

		FileInputStream fis = null;
		ObjectInputStream in = null;
		File file = new File(name + " .ser");
		if (file.exists()) {

			try {
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				lib = (Library) in.readObject();
				fis.close();
				in.close();

			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("\nидентификатор не существует!");
		}
		
	}
	
}
