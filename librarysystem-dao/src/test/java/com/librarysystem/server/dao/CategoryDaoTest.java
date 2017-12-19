package com.librarysystem.server.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.librarysystem.server.domain.CategoryEntity;

public class CategoryDaoTest extends BaseDaoTests
{
    @Autowired
    private CategoryDao categoryDao;

    protected void setUp() throws Exception
    {
        System.out.println("setup: Loading application context");
        System.out.println("setup: Done loading application context");
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
        System.out.println("tearDown: START");
        System.out.println("tearDown: FINISH");
    }

    private long _categoryId = 0;

    private String _categoryName = "Name";
    private String _categoryCode = "CODE";

    private long _editedBy = 1;
    private long _enteredBy = 1;
    private LocalDateTime _editedDate = LocalDateTime.now();
    private LocalDateTime _enteredDate = LocalDateTime.now();

    private CategoryEntity create()
    {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryId(_categoryId);

        categoryEntity.setCategoryCode(_categoryCode);
        categoryEntity.setCategoryName(_categoryName);

        categoryEntity.setEditedBy(_editedBy);
        categoryEntity.setEditedDate(_editedDate);
        categoryEntity.setEnteredBy(_enteredBy);
        categoryEntity.setEnteredDate(_enteredDate);

        return categoryEntity;
    }

    // CategoryEntity create(CategoryEntity categoryEntity);
    @Test
    public void testCategoryCreate()
    {
        System.out.println("testCategoryCreate: START");

        CategoryEntity categoryEntity = create();

        categoryEntity = categoryDao.create(categoryEntity);

        assertNotNull(categoryEntity);
        assertNotSame(0, categoryEntity.getCategoryId());
        assertEquals(_categoryName, categoryEntity.getCategoryName());
        assertEquals(_categoryCode, categoryEntity.getCategoryCode());

        System.out.println("testCategoryCreate: FINISH");
    }

    // CategoryEntity updateCategoryEntity(CategoryEntity categoryEntity);
    @Test
    public void testCategoryUpdate()
    {
        System.out.println("testCategoryUpdate: START");

        CategoryEntity categoryEntity = create();

        categoryEntity = categoryDao.create(categoryEntity);

        assertNotNull(categoryEntity);
        assertNotSame(0, categoryEntity.getCategoryId());
        assertEquals(_categoryName, categoryEntity.getCategoryName());
        assertEquals(_categoryCode, categoryEntity.getCategoryCode());

        String categoryname = "upd_name";
        String categorycode = "upd_code";
        categoryEntity.setCategoryName(categoryname);
        categoryEntity.setCategoryCode(categorycode);

        categoryEntity = categoryDao.update(categoryEntity);

        assertNotNull(categoryEntity);
        assertNotSame(0, categoryEntity.getCategoryId());
        assertEquals(categoryname, categoryEntity.getCategoryName());
        assertEquals(categorycode, categoryEntity.getCategoryCode());

        System.out.println("testCategoryUpdate: FINISH");
    }

    // void deleteCategoryEntity(long categoryId);
    // void deleteCategoryEntity(CategoryEntity categoryEntity);

    // CategoryEntity getCategoryEntity(long categoryId);
    @Test
    public void testGetCategoryEntityById()
    {
        System.out.println("testGetCategoryEntity: START");

        CategoryEntity categoryEntity = create();

        categoryEntity = categoryDao.create(categoryEntity);

        assertNotNull(categoryEntity);
        assertNotSame(0, categoryEntity.getCategoryId());
        assertEquals(_categoryName, categoryEntity.getCategoryName());
        assertEquals(_categoryCode, categoryEntity.getCategoryCode());

        long categoryId = categoryEntity.getCategoryId();
        categoryEntity = categoryDao.getById(categoryId);

        assertNotNull(categoryEntity);
        assertNotSame(0, categoryEntity.getCategoryId());
        assertEquals(_categoryName, categoryEntity.getCategoryName());
        assertEquals(_categoryCode, categoryEntity.getCategoryCode());

        System.out.println("testGetCategoryEntity: FINISH");
    }

    // CategoryEntity getCategoryEntityByCategoryname(String categoryname);
    @Test
    public void testGetCategoryEntityByCategoryCode()
    {
        System.out.println("testGetCategoryEntityByCategoryCode: START");

        CategoryEntity categoryEntity = create();

        categoryEntity = categoryDao.create(categoryEntity);

        assertNotNull(categoryEntity);
        assertNotSame(0, categoryEntity.getCategoryId());
        assertEquals(_categoryName, categoryEntity.getCategoryName());
        assertEquals(_categoryCode, categoryEntity.getCategoryCode());

        String categoryCode = categoryEntity.getCategoryCode();
        categoryEntity = categoryDao.getCategoryEntityByCode(categoryCode);

        assertNotNull(categoryEntity);
        assertNotSame(0, categoryEntity.getCategoryId());
        assertEquals(categoryCode, categoryEntity.getCategoryCode());

        System.out.println("testGetCategoryEntityByCategoryCode: FINISH");
    }

    // List<CategoryEntity> getAllCategoryEntityList();
    @Test
    public void testGetAllCategoryEntityList()
    {
        System.out.println("testGetAllCategoryEntityList: START");

        List<CategoryEntity> categoryList = categoryDao.getAllCategoryEntityList();

        assertNotNull(categoryList);
        assertEquals(true, categoryList.size() > 0);

        System.out.println("testGetAllCategoryEntityList: FINISH");
    }

}
