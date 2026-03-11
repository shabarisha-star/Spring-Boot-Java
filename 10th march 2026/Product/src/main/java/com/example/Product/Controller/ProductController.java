package com.example.Product.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product.Dto.Request.ProductRequest;
import com.example.Product.Dto.Response.ApiResponse;
import com.example.Product.Dto.Response.ProductResponse;
import com.example.Product.Service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/cal")
    public ApiResponse getResults(@RequestBody ProductRequest request){
         ProductResponse result = productService.calProductResponse(request);
        return new ApiResponse(result, "success");
    }
}
