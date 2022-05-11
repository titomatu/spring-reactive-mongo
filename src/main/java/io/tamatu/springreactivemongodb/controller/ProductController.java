package io.tamatu.springreactivemongodb.controller;

import io.tamatu.springreactivemongodb.dto.ProductDto;
import io.tamatu.springreactivemongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<ProductDto> products(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id){
        return service.getProduct(id);
    }

    @GetMapping("/range")
    public Flux<ProductDto> getProductsBetweenRange(@RequestParam double min, @RequestParam double max){
        return service.getProductInRange(min, max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> dto){
        return service.saveProduct(dto);
    }

    @PutMapping("/{id}")
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> dto, String id){
        return service.updateProduct(dto, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@RequestParam String id){
        return service.deleteProduct(id);
    }
}
