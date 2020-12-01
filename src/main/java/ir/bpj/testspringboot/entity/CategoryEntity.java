package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEST_CATEGORY", schema = "CONSULAR_EX")
public class CategoryEntity {
    private long categoryId;
    private Long parentCategoryId;
    private String categoryName;
    private List<ProductEntity> products;

    @Id
    @Column(name = "CATEGORY_ID")
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "PARENT_CATEGORY_ID")
    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    @Basic
    @Column(name = "CATEGORY_NAME")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @ManyToMany(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> productEntities) {
        this.products = productEntities;
    }
}
