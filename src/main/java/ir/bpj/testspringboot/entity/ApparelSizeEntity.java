package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_APPAREL_SIZE", schema = "CONSULAR_EX")
public class ApparelSizeEntity {
    private long sizeId;
    private Long sizeCode;
    private Long sortOrder;
    private ProductEntity productEntity;

    @Id
    @Column(name = "SIZE_ID")
    public long getSizeId() {
        return sizeId;
    }

    public void setSizeId(long sizeId) {
        this.sizeId = sizeId;
    }

    @Basic
    @Column(name = "SIZE_CODE")
    public Long getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(Long sizeCode) {
        this.sizeCode = sizeCode;
    }

    @Basic
    @Column(name = "SORT_ORDER")
    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
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

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
