package br.ifsul.entity;

import java.util.ArrayList;
import java.util.List;

public class LivroBiblioteca {

	private List<Bookshelf> bookshelfs = new ArrayList<>();
	private List<Book> books = new ArrayList<>();
	
	public LivroBiblioteca() {
		super();
	}

	public LivroBiblioteca(List<Bookshelf> bookshelfs, List<Book> books) {
		super();
		this.bookshelfs = bookshelfs;
		this.books = books;
	}
	
	public List<Bookshelf> getBookshelfs() {
		return bookshelfs;
	}
	public void setBookshelfs(List<Bookshelf> bookshelfs) {
		this.bookshelfs = bookshelfs;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
