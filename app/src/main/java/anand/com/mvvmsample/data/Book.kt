package anand.com.mvvmsample.data

/**
 * Model class for repo.
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
data class Book(
    val quoteText: String,
    val author: String
) {
    override fun toString(): String {
        return "$quoteText - $author"
    }
}