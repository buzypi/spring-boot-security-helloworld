package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

  @GetMapping
  public String hello() {
    return "Hello";
  }

  @GetMapping("/admin/hello")
  public String admin() {
    return "This is the admin hello page";
  }

}