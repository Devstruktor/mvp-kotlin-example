package devstruktor.wordpress.com.mvpexample.model

class NameProvider : INameProvider {

    companion object {
        private var holdenName: String = ""
    }

    override fun saveName(name: String) {
        holdenName = name
    }

    override fun loadName(): String {
        return holdenName
    }
}