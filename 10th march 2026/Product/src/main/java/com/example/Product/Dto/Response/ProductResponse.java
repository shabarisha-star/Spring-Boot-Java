package com.example.Product.Dto.Response;

public class ProductResponse {
    private String name;
    private double total;
    private double tax;
    private double netTotal;
    private String result;

    public ProductResponse(String name, double netTotal, double tax, double total,String result) {
        this.name = name;
        this.netTotal = netTotal;
        this.tax = tax;
        this.total = total;
        this.result= result;

    }
   
    public  String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result=result;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

     
}
