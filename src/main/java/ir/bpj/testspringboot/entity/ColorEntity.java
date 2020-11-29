package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_COLOR", schema = "CONSULAR_EX")
public class ColorEntity {
    private int colorId;
    private Integer colorCode;
    private String colorName;
    private ProductColorsEntity productColorsEntity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorEntity that = (ColorEntity) o;
        return colorId == that.colorId &&
                Objects.equals(colorCode, that.colorCode) &&
                Objects.equals(colorName, that.colorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, colorCode, colorName);
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_COLOR_ID", referencedColumnName = "COLOR_ID", nullable = false)
    public ProductColorsEntity getProductColorsEntity() {
        return productColorsEntity;
    }

    public void setProductColorsEntity(ProductColorsEntity productColorsEntity) {
        this.productColorsEntity = productColorsEntity;
    }
}
