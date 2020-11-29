package ir.bpj.testspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "TEST_COLOR", schema = "CONSULAR_EX")
public class ColorEntity {
    private int colorId;
    private Integer colorCode;
    private String colorName;
    private ProductEntity productEntity;

    @Id
    @Column(name = "COLOR_ID")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "COLOR_CODE")
    public Integer getColorCode() {
        return colorCode;
    }

    public void setColorCode(Integer colorCode) {
        this.colorCode = colorCode;
    }

    @Basic
    @Column(name = "COLOR_NAME")
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @ManyToOne
    @JoinTable(name = "TEST_PRODUCT_COLOR", joinColumns = @JoinColumn(name = "COLOR_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
