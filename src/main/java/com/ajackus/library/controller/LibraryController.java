package com.ajackus.library.controller;

//import com.ajackus.library.DigitalLibraryBookManagementSystemApplication;
import com.ajackus.library.DigitalLibraryBookManagementSystemApplication;
import com.ajackus.library.models.Book;
import com.ajackus.library.exceptions.InvalidProductException;
import com.ajackus.library.services.LibraryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/library")
public class LibraryController {

    LibraryService libraryService;

    LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book)  {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.addBook(book));
        }
        catch (InvalidProductException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return libraryService.getBookCollection();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id) {
       Book book = libraryService.getBookById(id);
       if(book == null) {
           throw new NullPointerException("Book not found");
       }
       return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("/find/{id}/{title}")
    public ResponseEntity<Book> getBookByIdAndTitle(@PathVariable Long id, @PathVariable String title) {
        Book book = libraryService.getBookByIdAndTitle(id, title);
        if(book==null){
            throw new NullPointerException("Book not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book updateBook) {
        Book book = libraryService.updateBook(id, updateBook);
        if(book == null) {
            throw new NullPointerException("Book not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if(libraryService.deleteBookById(id))
            return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }

    @PostMapping("/exit")
    public void  exitApplication() {
        if (DigitalLibraryBookManagementSystemApplication.context != null) {
            DigitalLibraryBookManagementSystemApplication.context.close();
        }
        System.exit(0);
    }

}
