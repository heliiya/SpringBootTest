package ir.bpj.testspringboot.dto;

import ir.bpj.testspringboot.entity.CategoryEntity;
import ir.bpj.testspringboot.entity.ColorEntity;
import ir.bpj.testspringboot.entity.ProductEntity;

import java.util.List;

public class ProductDto {
    private long productId;
    private String productName;
    private String otherData;
    private List<CategoryEntity> categories;
    private List<ColorEntity> colorEntities;

    public ProductDto() {
    }

    public ProductDto(ProductEntity entity) {
        this.productId = entity.getProductId();
        this.productName = entity.getProductName();
        this.otherData = entity.getOtherData();
        this.categories = entity.getCategories();
        this.colorEntities = entity.getColorEntities();
    }

    public ProductEntity getEntity(){
        ProductEntity entity = new ProductEntity();
        entity.setProductId(productId);
        entity.setProductName(productName);
        entity.setOtherData(otherData);
        entity.setCategories(categories);
        entity.setColorEntities(colorEntities);
        return entity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public List<ColorEntity> getColorEntities() {
        return colorEntities;
    }

    public void setColorEntities(List<ColorEntity> colorEntities) {
        this.colorEntities = colorEntities;
    }

    @Override
    public String toString() {
        return "{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", otherData='" + otherData + '\'' +
                ", categories=" + categories +
                ", colorEntities=" + colorEntities +
                '}';
    }
}
