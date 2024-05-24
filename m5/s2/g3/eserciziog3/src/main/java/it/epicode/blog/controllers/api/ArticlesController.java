package it.epicode.blog.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.epicode.blog.entities.Article;
import it.epicode.blog.services.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

	@Autowired
	ArticleService articles;

	// GET /articles
	@GetMapping
	public ResponseEntity<List<Article>> getArticles() {
		List<Article> allArticles = articles.getArticles();
		return new ResponseEntity<>(allArticles, HttpStatus.OK);
	}

	// GET /articles/123 -> id = 123
	@GetMapping("{id}")
	public ResponseEntity<Article> getArticle(@PathVariable Long id) {
		return articles.getArticle(id)
				.map(article -> new ResponseEntity<>(article, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// POST /articles
	@PostMapping
	public ResponseEntity<Article> save(@RequestBody Article article) {
		Article savedArticle = articles.save(article);
		return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
	}

	// PUT /articles/123 -> id = 123
	@PutMapping("{id}")
	public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article article) {
		try {
			Article updatedArticle = articles.update(id, article);
			return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// DELETE /articles/123 -> id = 123
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Article> delete(@PathVariable Long id) {
		try {
			Article deletedArticle = articles.delete(id);
			return new ResponseEntity<>(deletedArticle, HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
