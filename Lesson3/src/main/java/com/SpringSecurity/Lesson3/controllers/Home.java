package com.SpringSecurity.Lesson3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home 
{
   @GetMapping("/home")
   public String Home()
   {
	   return "Hello Lesson 3 :: Custom Authentication";
   }
}
