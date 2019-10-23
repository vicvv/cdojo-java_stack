package com.vicky.connecttodb.controllers;


import java.util.List;

import javax.validation.Valid;


import java.io.*; 
import java.util.ArrayList; 
import javax.servlet.*; 
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vicky.connecttodb.models.Book;
import com.vicky.connecttodb.services.BookService;


@Controller
public class BooksController {
 private final BookService bookService;
 
 public BooksController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @RequestMapping("/books")
 public String index(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "/books/index.jsp";
 }
 
 @RequestMapping("/books/new")
 public String newBook(@ModelAttribute("book") Book book) {
     return "/books/new.jsp";
 }
 
 @RequestMapping(value="/books", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }
 }
 
 // view one book
 @RequestMapping("/books/{id}")
 public String showBook(Model model, @PathVariable("id") Long id, Book book) {
     book = bookService.findBook(id);
     model.addAttribute("book", book);
	 return "/books/show.jsp";
 }
 
 // edit book route
 
 @RequestMapping("/books/{id}/edit")
 public String edit(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "/books/edit.jsp";
 }
 
 // edit book form
 @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/edit.jsp";
     } else {
         bookService.saveBook(book);
         return "redirect:/books";
     }
 }
 // delete book
 @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
 public String destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
     return "redirect:/books";
 }
 
}
