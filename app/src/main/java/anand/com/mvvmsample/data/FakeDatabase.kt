package anand.com.mvvmsample.data

/**
 * Making fake date for offline support.
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}