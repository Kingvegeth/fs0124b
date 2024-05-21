package it.epicode.blog.services;

import it.epicode.blog.entities.Author;
import it.epicode.blog.repositories.AuthorsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorsRepository authors;

    @Override
    public List<Author> getAuthors() {
        try {
            return authors.findAll();
        } catch(Exception e) {
            log.error("Error fetching authors", e);
            throw new RuntimeException("Error fetching authors");
        }
    }

    @Override
    public Optional<Author> getAuthor(Long id) {
        try {
            return authors.findById(id);
        } catch (Exception e) {
            log.error(String.format("Error fetching author with id = %s", id), e);
            throw new RuntimeException("Error fetching authors");
        }
    }

    @Override
    public Author save(Author author) {
        try {
            return authors.save(author);
        } catch (Exception e) {
            log.error("Error saving author", e);
            throw new RuntimeException("Error saving author");
        }
    }

    @Override
    public Author update(Long authorId, Author author) {
        try {
            if (authors.existsById(authorId)) {
                author.setId(authorId);
                return authors.save(author);
            } else {
                throw new NoSuchElementException("Author not found");
            }
        } catch (NoSuchElementException e) {
            log.error(String.format("Cannot find author with id = %s", authorId), e);
            throw new RuntimeException("Cannot find author");
        } catch (Exception e) {
            log.error(String.format("Error updating author with id = %s", authorId), e);
            throw new RuntimeException("Error updating author");
        }
    }

    @Override
    public Author delete(Long authorId) {
        try {
            var author = authors.findById(authorId).orElseThrow();
            authors.delete(author);
            return author;
        } catch (NoSuchElementException e) {
            log.error(String.format("Cannot find author with id = %s", authorId), e);
            throw new RuntimeException("Cannot find author...");
        } catch (Exception e) {
            log.error(String.format("Error deleting author with id = %s", authorId), e);
            throw new RuntimeException();
        }
    }
}
