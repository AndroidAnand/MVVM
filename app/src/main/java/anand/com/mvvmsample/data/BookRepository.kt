package anand.com.mvvmsample.data

/**
 * Repo implementation.
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
class BookRepository private constructor(private val quoteDao: FakeQuoteDao) {

    fun addQuote(book: Book) {
        quoteDao.addQuote(book)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: BookRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: BookRepository(quoteDao).also { instance = it }
            }
    }
}