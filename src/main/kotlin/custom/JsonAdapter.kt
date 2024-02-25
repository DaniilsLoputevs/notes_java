package custom

data class JsonAdapter(
    var id : String = ""
) {
    var email : String = ""
}

fun main() {
    val k = JsonAdapter::class.members
    k.forEach { println(it) }
}