package devstruktor.wordpress.com.mvpexample.presenter

import devstruktor.wordpress.com.mvpexample.model.INameProvider
import devstruktor.wordpress.com.mvpexample.view.IHelloView

class HelloPresenter(private var view: IHelloView?, private val model: INameProvider) : IHelloPresenter {

    override fun detach() {
        view = null
    }

    override fun onNameWritten(name: String) {
        model.saveName(name)
        view?.showHelloMessage("Hello ${model.loadName()}, welcome to Devstruktor!")
    }
}