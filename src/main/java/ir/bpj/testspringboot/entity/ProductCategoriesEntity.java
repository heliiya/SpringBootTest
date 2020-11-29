package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_PRODUCT_CATEGORIES", schema = "CONSULAR_EX")
public class ProductCategoriesEntity {
    private int categoryId;
    private ProductEntity productEntity;

    @Id
    @Column(name = "CATEGORY_ID")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoriesEntity that = (ProductCategoriesEntity) o;
        return categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
