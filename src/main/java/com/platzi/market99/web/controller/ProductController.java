package com.platzi.market99.web.controller;

import com.platzi.market99.domain.Product;
import com.platzi.market99.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Este es una descripcion para la API")
    @ApiResponse(code = 200,message = "Ok")
   // public List<Product> getAll() {
     public ResponseEntity<List<Product>> getAll() {
        //return productService.getAll();
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    @ApiOperation("Este busca un producto con id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok"),
            @ApiResponse(code = 404, message = "producto no encontrado")
    })
    //public Optional<Product> getProduct(@PathVariable("productId") int productId) {
    public ResponseEntity<Product> getProduct (@ApiParam(value = "el id del producto", required = true,example = "7") @PathVariable("productId") int productId) {
        //return productService.getProduct(productId);
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{CategoryId}")
    //public Optional<List<Product>> getByCategory(@PathVariable("CategoryId") int categoryId) {
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("CategoryId") int categoryId) {
        //return productService.getByCategory(categoryId);
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity< >(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    //public Product save(@RequestBody Product product) {
    public ResponseEntity<Product> save(@RequestBody Product product) {
        //return productService.save(product);
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    //public boolean delete(@PathVariable("id") int productId) {
    public ResponseEntity delete(@PathVariable("id") int productId) {
       // return productService.delete(productId);
        if (productService.delete(productId)){

        return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
