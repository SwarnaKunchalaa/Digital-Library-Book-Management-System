package com.ajackus.library.services;

import com.ajackus.library.exceptions.InvalidProductException;
import com.ajackus.library.models.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private List<Book> bookCollection = new ArrayList<>();
    private long idCounter = 1L;

     public Book addBook(Book book) {
         if (book.getTitle().isBlank() || book.getAuthor().isBlank() || book.getGenre().isBlank()) {
             throw new InvalidProductException("Book fields cannot be empty");
         }
         book.setBookId(idCounter++);
         bookCollection.add(book);
         return book;
     }

     public Book getBookById(long id) {
         for(Book book : bookCollection) {
             if(id==book.getBookId()){
                 return book;
             }
         }
         return null;
     }
     public List<Book> getBookCollection() {
         return bookCollection;
     }
     public Book getBookByIdAndTitle(long id, String title) {
         for(Book book : bookCollection) {
            if(id==book.getBookId() && title.equals(book.getTitle())){
                return book;
            }
         }
         return null;
     }
     public Book updateBook(long id, Book updatedBook) {
         for (Book book : bookCollection) {
             if (book.getBookId()==id) {
                 book.setTitle(updatedBook.getTitle());
                 book.setAuthor(updatedBook.getAuthor());
                 book.setIsAvailable(updatedBook.getIsAvailable());
                 book.setGenre(updatedBook.getGenre());
                 return book;
             }
         }
         return null;
     }
     public boolean deleteBookById(long id) {
         return bookCollection.removeIf(book -> book.getBookId()==id);
     }









}
