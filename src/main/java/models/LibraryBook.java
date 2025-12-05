package models;

import java.time.LocalDateTime;

public class LibraryBook {
    private Integer id;
    private String isbn;
    private String title;
    private String authors;
    private String publisher;
    private Integer yearPublication;
    private Integer copiesTotal;
    private Integer copiesAvailable;
    private String location;
    private String subjects;
    private LocalDateTime createdAt;

    public LibraryBook() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthors() { return authors; }

    public void setAuthors(String authors) { this.authors = authors; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public Integer getYearPublication() { return yearPublication; }

    public void setYearPublication(Integer yearPublication) { this.yearPublication = yearPublication; }

    public Integer getCopiesTotal() { return copiesTotal; }

    public void setCopiesTotal(Integer copiesTotal) { this.copiesTotal = copiesTotal; }

    public Integer getCopiesAvailable() { return copiesAvailable; }

    public void setCopiesAvailable(Integer copiesAvailable) { this.copiesAvailable = copiesAvailable; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getSubjects() { return subjects; }

    public void setSubjects(String subjects) { this.subjects = subjects; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
