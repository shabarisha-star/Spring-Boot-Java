package com.example.Product.Service;

import org.springframework.stereotype.Service;

import com.example.Product.Dto.Request.ProductRequest;
import com.example.Product.Dto.Response.ProductResponse;

@Service
public class ProductService {

    public ProductResponse calProductResponse(ProductRequest req){
    double total=req.getProduct1()+req.getProduct2()+req.getProduct3()+req.getProduct4()+req.getProduct5();
    double tax=total*18/100;
    double netTotal=total+tax;

    String result=(netTotal>=1000)?"Revenue":"Loss";

    return new ProductResponse(req.getName(), netTotal, tax, total, result);
    }
}
