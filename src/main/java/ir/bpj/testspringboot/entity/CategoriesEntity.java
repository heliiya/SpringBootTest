package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_CATEGORIES", schema = "CONSULAR_EX")
public class CategoriesEntity {
    private int categoryId;
    private Integer parentCategoryId;
    private String categoryName;
    private ProductCategoriesEntity productCategoriesEntity;

    @Id
    @Column(name = "CATEGORY_ID")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "PARENT_CATEGORY_ID")
    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesEntity that = (CategoriesEntity) o;
        return categoryId == that.categoryId &&
                Objects.equals(parentCategoryId, that.parentCategoryId) &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, parentCategoryId, categoryName);
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false)
    public ProductCategoriesEntity getProductCategoriesEntity() {
        return productCategoriesEntity;
    }

    public void setProductCategoriesEntity(ProductCategoriesEntity productCategoriesEntity) {
        this.productCategoriesEntity = productCategoriesEntity;
    }
}
