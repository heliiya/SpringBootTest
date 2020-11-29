package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_PRODUCT_COLORS", schema = "CONSULAR_EX")
public class ProductColorsEntity {
    private int colorId;
    private ProductEntity productEntity;

    @Id
    @Column(name = "COLOR_ID")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductColorsEntity that = (ProductColorsEntity) o;
        return colorId == that.colorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId);
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
