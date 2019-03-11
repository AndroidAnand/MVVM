package anand.com.mvvmsample.ui.book

import anand.com.mvvmsample.R
import anand.com.mvvmsample.data.Book
import anand.com.mvvmsample.ui.quotes.BookViewModel
import anand.com.mvvmsample.utilities.InjectorUtils
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_book.button_add_quote
import kotlinx.android.synthetic.main.activity_book.editText_author
import kotlinx.android.synthetic.main.activity_book.editText_quote
import kotlinx.android.synthetic.main.activity_book.textView_quotes

/**
 * App Main Screen.
 *
 * @author Anand M Joseph (anandmampuzhakal@gmail.com)
 */
class BookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(BookViewModel::class.java)

        viewModel.getQuotes()
            .observe(this, Observer { quotes ->
                val stringBuilder = StringBuilder()
                quotes.forEach { quote ->
                    stringBuilder.append("$quote\n\n")
                }
                textView_quotes.text = stringBuilder.toString()
            })

        button_add_quote.setOnClickListener {
            val quote = Book(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
