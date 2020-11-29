package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_PRODUCT", schema = "CONSULAR_EX")
public class ProductEntity {
    private int productId;
    private String productName;
    private String otherData;

    @Id
    @Column(name = "PRODUCT_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "OTHER_DATA")
    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(otherData, that.otherData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, otherData);
    }
}
