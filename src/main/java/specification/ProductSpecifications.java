package specification;

import ir.bpj.testspringboot.entity.ProductEntity;

import java.util.List;

public class ProductSpecifications {

    public static Specification<ProductEntity> productHasThisName(String productNameParam) {
        return (root, query, cb) -> cb.equal(root.get("productName"), productNameParam);
    }

    public static Specification<ProductEntity> categoryHasTheseNames(List<String> categoriesNameParam) {
        return (root, query, cb) -> root.join("categories").get("categoryName").in(categoriesNameParam);
    }

}