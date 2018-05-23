package devstruktor.wordpress.com.mvpexample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import devstruktor.wordpress.com.mvpexample.R
import devstruktor.wordpress.com.mvpexample.model.NameProvider
import devstruktor.wordpress.com.mvpexample.presenter.HelloPresenter
import devstruktor.wordpress.com.mvpexample.presenter.IHelloPresenter
import kotlinx.android.synthetic.main.activity_main.*

class HelloActivity : AppCompatActivity(), IHelloView {


    val presenter: IHelloPresenter = HelloPresenter(this, NameProvider())

    override fun showHelloMessage(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareViews()
    }

    private fun prepareViews() {
        name_field.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()) {
                    submit_button.isEnabled = false
                    submit_button.alpha = 0.5F
                } else {
                    submit_button.isEnabled = true
                    submit_button.alpha = 1F
                }
            }

        })

        submit_button.setOnClickListener {
            presenter.onNameWritten(name_field.text.toString())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

}
