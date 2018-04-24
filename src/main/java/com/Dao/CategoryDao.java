package com.Dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao
{
 public boolean addCategory(Category c);
 public boolean deleteCategory(Category c);
 public boolean updateCategory(Category c);
 public List<Category> displayAll(Category c);
 
}
