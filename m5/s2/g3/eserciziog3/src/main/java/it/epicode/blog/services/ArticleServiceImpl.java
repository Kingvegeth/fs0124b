package it.epicode.blog.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.blog.entities.Article;
import it.epicode.blog.repositories.ArticlesRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticlesRepository articles;

	@Override
	public List<Article> getArticles() {
		try {
			return articles.findAll();
		} catch (Exception e) {
			log.error("Error fetching articles", e);
			throw new RuntimeException("Error fetching articles");
		}
	}

	@Override
	public Optional<Article> getArticle(Long id) {
		try {
			return articles.findById(id);
		} catch (Exception e) {
			log.error(String.format("Error fetching article with id = %s", id), e);
			throw new RuntimeException("Error fetching articles");
		}
	}

	@Override
	public Article save(Article article) {
		try {
			return articles.save(article);
		} catch (Exception e) {
			log.error("Error saving article", e);
			throw new RuntimeException("Error saving article");
		}
	}

	@Override
	public Article update(Long articleId, Article article) {
		try {
			if (articles.existsById(articleId)) {
				article.setId(articleId);
				return articles.save(article);
			} else {
				throw new NoSuchElementException("Article not found");
			}
		} catch (NoSuchElementException e) {
			log.error(String.format("Cannot find article with id = %s", articleId), e);
			throw new RuntimeException("Cannot find article");
		} catch (Exception e) {
			log.error(String.format("Error updating article with id = %s", articleId), e);
			throw new RuntimeException("Error updating article");
		}
	}

	@Override
	public Article delete(Long articleId) {
		try {
			var article = articles.findById(articleId).orElseThrow();
			articles.delete(article);
			return article;
		} catch (NoSuchElementException e) {
			log.error(String.format("Cannot find article with id = %s", articleId), e);
			throw new RuntimeException("Cannot find article...");
		} catch (Exception e) {
			log.error(String.format("Error deleting article with id = %s", articleId), e);
			throw new RuntimeException();
		}
	}
}
