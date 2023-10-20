package com.kgisl.springcrudsample.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.kgisl.springcrudsample.Model.Book;
import com.kgisl.springcrudsample.Service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String bookForm(Locale locale, Model model) {
        model.addAttribute("books", bookService.listBooks());
        return "book";
    }

    @ModelAttribute("book")
    public Book formBackingObject() {
        return new Book();
    }
// POST NEW BOOK
    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/addbook")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        bookService.saveBook(book);
        return "redirect:/";
    }
// DELETE
    @GetMapping("/delete/{id}") // Added GetMapping for deleting
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        return "deleteConfirmation";
    }

    @PostMapping("/delete/{id}") // Handling DeleteMapping for actual deletion
    public String deleteBook(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
        return "redirect:/";
    }
// EDIT 
    @GetMapping("/edit/{id}") // Added GetMapping for editing
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        return "editForm";
    }

    @PostMapping("/edit/{id}") // Added PutMapping for updating
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
          // Load the existing book from the database
    Book existingBook = this.bookService.getBookById(id);

    // Update the existing book's properties with the editedBook's properties
    existingBook.setName(book.getName());
    existingBook.setAuthor(book.getAuthor());
    // Update other properties as needed...

    // Save the updated book
    bookService.updateBook(existingBook);

    return "redirect:/";
    }

}
