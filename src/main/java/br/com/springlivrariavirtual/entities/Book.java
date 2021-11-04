package br.com.springlivrariavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bookName;
	private String bookAuthor;
	private String bookPublishCompany;
	private String bookEdition;
	private int bookQuantityStock;
	private double bookPrice;
	
	public Book() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublishCompany() {
		return bookPublishCompany;
	}

	public void setBookPublishCompany(String bookPublishCompany) {
		this.bookPublishCompany = bookPublishCompany;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public int getBookQuantityStock() {
		return bookQuantityStock;
	}

	public void setBookQuantityStock(int bookQuantityStock) {
		this.bookQuantityStock = bookQuantityStock;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
}
