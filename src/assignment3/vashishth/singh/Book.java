package assignment3.vashishth.singh;

public class Book {
	private String bookTitle;
	private double bookPrice;
	private String bookAuthor;
	private String bookPublication;
	public Book() {
		super();
	}
	public Book(String bookTitle, double bookPrice, String bookAuthor, String bookPublication) {
		super();
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublication = bookPublication;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublication() {
		return bookPublication;
	}
	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}
	@Override
	public String toString() {
		return "Book [bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + ", bookAuthor=" + bookAuthor
				+ ", bookPublication=" + bookPublication + "]";
	}
}
