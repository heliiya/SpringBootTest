package ir.bpj.testspringboot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEST_PRODUCT", schema = "CONSULAR_EX")
public class ProductEntity {
    private long productId;
    private String productName;
    private String otherData;
    private List<CategoryEntity> categories;
    private List<ColorEntity> colorEntities;

    @Id
    @Column(name = "PRODUCT_ID")
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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

    @ManyToMany
    @JoinTable(name = "TEST_PRODUCT_CATEGORY", joinColumns = @JoinColumn(name = "PRODUCT_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categoryEntities) {
        this.categories = categoryEntities;
    }

    @OneToMany
    @JoinTable(name = "TEST_PRODUCT_COLOR", joinColumns = @JoinColumn(name = "PRODUCT_ID"), inverseJoinColumns = @JoinColumn(name = "COLOR_ID"))
    public List<ColorEntity> getColorEntities() {
        return colorEntities;
    }

    public void setColorEntities(List<ColorEntity> colorEntities) {
        this.colorEntities = colorEntities;
    }

}