package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_APPAREL_SIZE", schema = "CONSULAR_EX")
public class ApparelSizeEntity {
    private int sizeId;
    private Integer sizeCode;
    private Integer sortOrder;
    private ProductEntity productEntity;

    @Id
    @Column(name = "SIZE_ID")
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Basic
    @Column(name = "SIZE_CODE")
    public Integer getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(Integer sizeCode) {
        this.sizeCode = sizeCode;
    }

    @Basic
    @Column(name = "SORT_ORDER")
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApparelSizeEntity that = (ApparelSizeEntity) o;
        return sizeId == that.sizeId &&
                Objects.equals(sizeCode, that.sizeCode) &&
                Objects.equals(sortOrder, that.sortOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, sizeCode, sortOrder);
    }
}
