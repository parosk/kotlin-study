package language_features_related

fun main() {

    // the T.() syntax is known as Function  literals with receiver
    val sum = fun Int.(other: Int): Int = this + other

    print(1.sum(2))
}

// Extension function