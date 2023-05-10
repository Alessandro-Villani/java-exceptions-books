package org.java.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quanti libri vuoi inserire?");
		
		int booksNumber = sc.nextInt();
		sc.nextLine();
		
		Book[] books = new Book[booksNumber];
		
		for(int i = 0; i<books.length; i++) {
			
			boolean isCreated = false;
			
			while(isCreated == false) {
				System.out.println("Inserisci Libro " + (i+1) + " di " + books.length);
				System.out.println("Inserisci titolo");
				String title = sc.nextLine();
				int pagesNumber = 0;
				boolean hasPages = false;
				while(hasPages == false) {
					System.out.println("Inserisci numero pagine");
					try {
						pagesNumber = sc.nextInt();
						sc.nextLine();
						hasPages = true;
					} catch (Exception e) {
						System.out.println("Numero di pagine non valido");
						sc.nextLine();
					}
					
				}
				System.out.println("Inserisci autore");
				String author = sc.nextLine();
				System.out.println("Inserisci editore");
				String publisher = sc.nextLine();
				
				try {
					Book book = new Book(title, pagesNumber, author, publisher);
					books[i] = book;
					System.out.println("Libro aggiunto: " + book);
					isCreated = true;
				} catch (Exception e) {
					System.out.println("errore nella creazione di Libro: " + e.getMessage() + "\nRiprova:");
				}
				
			}
			
			
		}
		
		sc.close();
		
		saveBooks(books);
		
		printBooks();
		

	}
	
	public static void saveBooks(Book[] books) {
		
		String content = "";
		
		for (int i = 0; i<books.length; i++) {
			
			content += books[i] + "\n";
			
		}
		
		try {
			FileWriter wr = new FileWriter("C:\\java_projects\\books.txt");
			wr.write(content);
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Errore nella scrittura del file " + e.getMessage());
		}
		
	}
	
	public static void printBooks() {
		
		File books = new File("C:\\java_projects\\books.txt");
		try {
			Scanner reader = new Scanner(books);
			System.out.println("\n----------------------\nELENCO LIBRI\n----------------------\n");
			while(reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("Errore nella lettura del file" + e.getMessage());
			
		}
		
		
		
	}

}
