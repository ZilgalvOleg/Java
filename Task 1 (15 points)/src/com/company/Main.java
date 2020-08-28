package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Author[] authors = new Author[5];
        Book[] books = new Book[5];

        Author author = new Author();
        Book book = new Book();
        author.setAge(23);
        author.setName("Micha");
        author.addBook(book);
        book.setTitle("Life");
        book.setNumberOfPages(350);
        book.addAuthor(author);

        Author author1 = new Author();
        Book book1 = new Book();
        author1.setAge(50);
        author1.setName("Koly");
        author1.addBook(book1);
        book1.setTitle("Winnie-the-Pooh");
        book1.setNumberOfPages(233);
        book1.addAuthor(author1);

        Author author2 = new Author();
        Book book2 = new Book();
        author2.setAge(33);
        author2.setName("Oleg");
        author2.addBook(book2);
        book2.setTitle("Jeeves and Wooster stories");
        book2.setNumberOfPages(450);
        book2.addAuthor(author2);

        Author author3 = new Author();
        Book book3 = new Book();
        author2.setAge(37);
        author2.setName("Vasy");
        author2.addBook(book3);
        book2.setTitle("Harry Potter and the Philosopher's Stone");
        book2.setNumberOfPages(800);
        book2.addAuthor(author3);

        Author author4 = new Author();
        Book book4 = new Book();
        author2.setAge(22);
        author2.setName("Nataly");
        author2.addBook(book4);
        book2.setTitle("Airport");
        book2.setNumberOfPages(452);
        book2.addAuthor(author4);

        authors[0] = author;
        authors[1] = author1;
        authors[2] = author2;
        authors[3] = author3;
        authors[4] = author4;

        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        books[4] = book4;

        Arrays.stream(books)
                .filter((s) -> s.setNumberOfPages > 200);






    }
}
