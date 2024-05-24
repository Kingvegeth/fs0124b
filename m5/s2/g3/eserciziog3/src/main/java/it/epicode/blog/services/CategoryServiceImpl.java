package it.epicode.blog.services;

import it.epicode.blog.entities.Category;
import it.epicode.blog.repositories.CategoriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public List<Category> getCategories() {
        try {
            return categoriesRepository.findAll();
        } catch (Exception e) {
            log.error("Error fetching categories", e);
            throw new RuntimeException("Error fetching categories");
        }
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        try {
            return categoriesRepository.findById(id);
        } catch (Exception e) {
            log.error(String.format("Error fetching category with id = %s", id), e);
            throw new RuntimeException("Error fetching category");
        }
    }

    @Override
    public Category save(Category category) {
        try {
            return categoriesRepository.save(category);
        } catch (Exception e) {
            log.error("Error saving category", e);
            throw new RuntimeException("Error saving category");
        }
    }

    @Override
    public Category update(Long categoryId, Category category) {
        try {
            if (categoriesRepository.existsById(categoryId)) {
                category.setId(categoryId);
                return categoriesRepository.save(category);
            } else {
                throw new NoSuchElementException("Category not found");
            }
        } catch (NoSuchElementException e) {
            log.error(String.format("Cannot find category with id = %s", categoryId), e);
            throw new RuntimeException("Cannot find category");
        } catch (Exception e) {
            log.error(String.format("Error updating category with id = %s", categoryId), e);
            throw new RuntimeException("Error updating category");
        }
    }

    @Override
    public Category delete(Long categoryId) {
        try {
            var category = categoriesRepository.findById(categoryId).orElseThrow();
            categoriesRepository.delete(category);
            return category;
        } catch (NoSuchElementException e) {
            log.error(String.format("Cannot find category with id = %s", categoryId), e);
            throw new RuntimeException("Cannot find category");
        } catch (Exception e) {
            log.error(String.format("Error deleting category with id = %s", categoryId), e);
            throw new RuntimeException();
        }
    }
}
