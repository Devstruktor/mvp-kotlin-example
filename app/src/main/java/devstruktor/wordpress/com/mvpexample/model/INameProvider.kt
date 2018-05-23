package devstruktor.wordpress.com.mvpexample.model

interface INameProvider {
    fun saveName(name: String)
    fun loadName(): String
}