package it.epicode.blog.controllers.api;

import it.epicode.blog.entities.Author;
import it.epicode.blog.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    AuthorService authors;

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors() {
        List<Author> allAuthors = authors.getAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        return authors.getAuthor(id)
                .map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {
        Author savedAuthor = authors.save(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {
        try {
            Author updatedAuthor = authors.update(id, author);
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Author> delete(@PathVariable Long id) {
        try {
            Author deletedAuthor = authors.delete(id);
            return new ResponseEntity<>(deletedAuthor, HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
