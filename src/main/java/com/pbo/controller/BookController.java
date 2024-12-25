package com.pbo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pbo.model.Book;
import com.pbo.repository.BookRepository;
import com.pbo.services.StorageService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StorageService storageService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable String bookId) {
        return bookRepository.findById(bookId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build()); // TODO(youkwhd): 404 notFound isn't quite right: https://developer.x.com/en/support/x-api/error-troubleshooting
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String q) {
        return bookRepository.findByTitleContainingIgnoreCase(q);
    }

    @GetMapping("/recommendation")
    public List<Book> getTop10Books() {
        return bookRepository.findTop10ByOrderByRatingTotalDesc();
    }

    @GetMapping("/upcoming")
    public List<Book> getUpcomingBooks() {
        return bookRepository.findUpcomingBooks(LocalDate.now());
    }

    @GetMapping("/images/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        try {
            Path path = Paths.get(storageService.getStorageFolderPath(), filename);
            byte[] imageBytes = Files.readAllBytes(path);
            String contentType = Files.probeContentType(path);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/{id}/cover")
    public ResponseEntity<?> postBookCover(@PathVariable String id, @RequestParam MultipartFile cover) throws IOException {
        storageService.validateCoverHeader(cover);
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        String filename = storageService.writeFile(cover);
        String url = "http://localhost:5000/api/books/images/" + filename;
        book.setBookImageUrl(url);
        bookRepository.save(book);

        return new ResponseEntity<>(url, HttpStatus.OK);
    }
}
