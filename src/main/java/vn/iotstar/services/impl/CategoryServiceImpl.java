package vn.iotstar.services.impl;

import java.io.File;
import java.util.List;
import vn.iotstar.daos.CategoryDAO;
import vn.iotstar.daos.impl.CategoryDAOImpl;
import vn.iotstar.models.Category;
import vn.iotstar.services.CategoryService;

@SuppressWarnings("unused")

public class CategoryServiceImpl implements CategoryService {

    // Service gọi xuống DAO
    CategoryDAO categoryDao = new CategoryDAOImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void edit(Category category) {
        // Lấy category cũ từ DB
        Category oldCategory = categoryDao.get(category.getCateId());

        oldCategory.setCateName(category.getCateName());

        if (category.getIcons() != null && !category.getIcons().isEmpty()) {

            oldCategory.setIcons(category.getIcons());
        }
        
        categoryDao.edit(oldCategory);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }
}