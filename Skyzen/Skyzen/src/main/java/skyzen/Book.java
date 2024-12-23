package skyzen;

import java.util.HashSet;
import java.util.Set;

public class Book {
    private String title;
    private String author;
    private String plot;
    private int pages;
    private int rating;
    private String imageUrl;
    private String country;

    public Book(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public Book(String title, String author, String plot, int pages, String country) {
        this.title = title;
        this.author = author;
        this.plot = plot;
        this.pages = pages;
        this.country = country;
    }

    public Book(String title, String author, String plot, int pages, String imageUrl, String country) {
        this.title = title;
        this.author = author;
        this.plot = plot;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPlot() {
        return plot;
    }

    public int getPages() {
        return pages;
    }

    public int getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

	public String getCountry() {
		return country;
	}

}

