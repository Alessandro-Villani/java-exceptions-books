package org.java.library;

public class Book {
	
	private String title;
	private int pagesNumber;
	private String author;
	private String publisher;
	
	public Book(String title, int pagesNumber, String author, String publisher) throws Exception {
		setTitle(title);
		setPagesNumber(pagesNumber);
		setAuthor(author);
		setPublisher(publisher);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws Exception {
		if(title.equals("")) throw new Exception("Il titolo è vuoto");
		this.title = title;
	}

	public int getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(int pagesNumber) throws Exception {
		if(pagesNumber <= 0) throw new Exception("Il numero di pagine è inferiore o uguale a 0");
		this.pagesNumber = pagesNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) throws Exception {
		if(author.equals("")) throw new Exception("L'autore è vuoto");
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		String bookString = getPublisher().isEmpty() ? 
				"Titolo: " + getTitle() + ", Autore: " + getAuthor() + ", Pagine: " + getPagesNumber() 
				: 
				"Titolo: " + getTitle() + ", Autore: " + getAuthor() + ", Editore: " + getPublisher() + ", Pagine: " + getPagesNumber();
		return bookString;
	}
	
	

}
