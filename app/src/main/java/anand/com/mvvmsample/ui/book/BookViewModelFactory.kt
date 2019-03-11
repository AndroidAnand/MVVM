package anand.com.mvvmsample.ui.book

import anand.com.mvvmsample.data.BookRepository
import anand.com.mvvmsample.ui.quotes.BookViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Use case entity decision module   .
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
class BookViewModelFactory(private val bookRepository: BookRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(bookRepository) as T
    }
}