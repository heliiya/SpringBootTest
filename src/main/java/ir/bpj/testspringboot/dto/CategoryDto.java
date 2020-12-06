package ir.bpj.testspringboot.dto;

import ir.bpj.testspringboot.entity.CategoryEntity;
import ir.bpj.testspringboot.entity.ProductEntity;

import java.util.List;

public class CategoryDto {
    private long categoryId;
    private Long parentCategoryId;
    private String categoryName;
    private List<ProductEntity> products;

    public CategoryDto() {
    }

    public CategoryDto(CategoryEntity entity) {
        this.categoryId = entity.getCategoryId();
        this.parentCategoryId = entity.getParentCategoryId();
        this.categoryName = entity.getCategoryName();
        this.products = entity.getProducts();
    }

    public CategoryEntity getEntity(){
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryId(categoryId);
        entity.setParentCategoryId(parentCategoryId);
        entity.setCategoryName(categoryName);
        entity.setProducts(products);
        return entity;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "{" +
                "categoryId=" + categoryId +
                ", parentCategoryId=" + parentCategoryId +
                ", categoryName='" + categoryName + '\'' +
                ", products=" + products +
                '}';
    }
}
