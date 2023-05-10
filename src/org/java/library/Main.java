package org.java.library;

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
				System.out.println("Inserisci numero pagine");
				int pagesNumber = sc.nextInt();
				sc.nextLine();
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
		

	}

}
