package devstruktor.wordpress.com.mvpexample.presenter

import devstruktor.wordpress.com.mvpexample.view.IHelloView

interface IHelloPresenter {

    fun detach()
    fun onNameWritten(name: String)

}