package com.company;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private int age;
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
