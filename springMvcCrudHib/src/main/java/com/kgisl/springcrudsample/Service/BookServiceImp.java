package com.kgisl.springcrudsample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgisl.springcrudsample.Dao.BookDao;
import com.kgisl.springcrudsample.Model.Book;

// import jakarta.transaction.Transactional;

@Service
public class BookServiceImp implements BookService {
   @Autowired
   private BookDao bookDao;

   @Transactional
   public void saveBook(Book book) {
      bookDao.saveBook(book);
   }

   @Transactional(readOnly = true)
   public List<Book> listBooks() {
      return bookDao.listBooks();
   }

   @Transactional
   public void deleteBook(Long id) {
      this.bookDao.deleteBook(id);
   }
   @Transactional
	public void updateBook(Book book) {
		this.bookDao.updateBook(book);
	}
   @Transactional
	public Book getBookById(Long id) {
		return this.bookDao.getBookById(id);
	}
}
