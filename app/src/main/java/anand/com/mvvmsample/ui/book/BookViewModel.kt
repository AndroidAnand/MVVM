package anand.com.mvvmsample.ui.quotes

import anand.com.mvvmsample.data.Book
import anand.com.mvvmsample.data.BookRepository
import androidx.lifecycle.ViewModel

/**
 * View model for UI(Its act as gel between UI & Data).
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

    fun getQuotes() = bookRepository.getQuotes()

    fun addQuote(book: Book) = bookRepository.addQuote(book)
}