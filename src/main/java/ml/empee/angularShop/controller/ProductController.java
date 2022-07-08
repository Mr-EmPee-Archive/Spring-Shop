package ml.empee.angularShop.controller;

import ml.empee.angularShop.exceptions.ResourceNotFound;
import ml.empee.angularShop.model.product.dto.ProductRequest;
import ml.empee.angularShop.model.product.dto.ProductResponse;
import ml.empee.angularShop.model.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> findProducts() {
        return ResponseEntity.ok(productsService.findProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> findProductByID(@PathVariable(value = "id") Long prodID) throws ResourceNotFound {
        return ResponseEntity.ok(productsService.findProductByID(prodID));
    }


    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productsService.saveProduct(request));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable(value = "id") Long prodID, @Valid @RequestBody ProductRequest request) {
        try {
            return ResponseEntity.ok(productsService.updateProduct(prodID, request));
        } catch (ResourceNotFound e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable(value = "id") Long prodID) {
        try {
            return ResponseEntity.ok(productsService.deleteProduct(prodID));
        } catch (ResourceNotFound e) {
            throw new RuntimeException(e);
        }
    }

}