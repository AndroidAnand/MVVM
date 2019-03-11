package anand.com.mvvmsample.utilities

import anand.com.mvvmsample.data.BookRepository
import anand.com.mvvmsample.data.FakeDatabase
import anand.com.mvvmsample.ui.book.BookViewModelFactory

/**
 * Injector utility.
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
object InjectorUtils {

    fun provideQuotesViewModelFactory(): BookViewModelFactory {
        val quoteRepository = BookRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return BookViewModelFactory(quoteRepository)
    }
}