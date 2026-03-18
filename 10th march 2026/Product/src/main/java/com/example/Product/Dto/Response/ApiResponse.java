package com.example.Product.Dto.Response;

public class ApiResponse {
    private String status;
    private ProductResponse data;

    public ApiResponse(ProductResponse data, String status) {
        this.data = data;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductResponse getData() {
        return data;
    }

    public void setData(ProductResponse data) {
        this.data = data;
    }


    
}
