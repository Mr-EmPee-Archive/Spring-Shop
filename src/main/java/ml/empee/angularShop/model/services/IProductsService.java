package ml.empee.angularShop.model.services;

import ml.empee.angularShop.exceptions.ResourceNotFound;
import ml.empee.angularShop.model.product.dto.ProductRequest;
import ml.empee.angularShop.model.product.dto.ProductResponse;

import java.util.List;

public interface IProductsService {
    List<ProductResponse> findProducts();
    ProductResponse findProductByID(Long productID) throws Throwable;
    ProductResponse updateProduct(Long productID, ProductRequest product) throws ResourceNotFound;
    ProductResponse saveProduct(ProductRequest request);
    ProductResponse deleteProduct(Long productID) throws ResourceNotFound;
}