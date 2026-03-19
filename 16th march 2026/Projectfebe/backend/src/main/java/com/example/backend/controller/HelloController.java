package com.example.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/add")
    public AddResponse add(@RequestParam int a, @RequestParam int b){
        int result = a + b;
        return new AddResponse(a,b,result);
    }

    static class AddResponse{
        private int a;
        private int b;
        private int result;

        public AddResponse(int a, int b, int result) {
            this.a = a;
            this.b = b;
            this.result = result;
        }

        public int getA() {
             return a; 
            }
        public int getB() {
             return b; 
            }
        public int getResult() { 
            return result; 
        }
        
    }

    // @GetMapping("/hello")
    // public HelloResponse hello(){
    //     return new HelloResponse("Hello,World!","This is my simple Api");
    // }

    // static class HelloResponse{
    //     private String message;
    //     private String description;
    
    //     public HelloResponse(String message, String description) {
    //         this.message = message;
    //         this.description = description;
    //     }

    //     public String getMessage() {
    //     return message;
    // }

    // public String getDescription() {
    //     return description;
    // }
        

      
    
}
