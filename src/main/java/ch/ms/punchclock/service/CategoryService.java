package ch.ms.punchclock.service;

import ch.ms.punchclock.model.Category;
import ch.ms.punchclock.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return (List<Category>) categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setTitle(category.getTitle());
        categoryRepository.save(categoryToUpdate);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


}
