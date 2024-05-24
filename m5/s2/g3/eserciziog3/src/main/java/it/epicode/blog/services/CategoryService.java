package it.epicode.blog.services;

import it.epicode.blog.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();

    Optional<Category> getCategory(Long id);

    Category save(Category category);

    Category update(Long categoryId, Category category);

    Category delete(Long categoryId);
}
