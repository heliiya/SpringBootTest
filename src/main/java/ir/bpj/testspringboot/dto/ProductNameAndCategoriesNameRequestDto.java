package ir.bpj.testspringboot.dto;

import java.util.List;

public class ProductNameAndCategoriesNameRequestDto {
    private String productName;
    private List<String> categoriesName;
    private Integer rowNo;

    public ProductNameAndCategoriesNameRequestDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(List<String> categoriesName) {
        this.categoriesName = categoriesName;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }
}
