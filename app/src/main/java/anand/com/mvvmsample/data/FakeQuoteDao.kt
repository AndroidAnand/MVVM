package anand.com.mvvmsample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
/**
 *  support Dao.
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
class FakeQuoteDao {
    private val quoteList = mutableListOf<Book>()
    private val quotes = MutableLiveData<List<Book>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(book: Book) {
        quoteList.add(book)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Book>>
}