fun main(args: Array<String>) {
    println("Hello World!")

    var intput: String? = null
    val size = 4
    println("$intput -> ${mask(intput, size)}")

    intput = ""
    println("$intput -> ${mask(intput, size)}")

    intput = "4en"
    println("$intput -> ${mask(intput, size)}")

    intput = "4eng"
    println("$intput -> ${mask(intput, size)}")

    intput = "4engineer.net"
    println("$intput -> ${mask(intput, size)}")

    intput = "1234-5678-9012-3456"
    println("$intput -> ${mask(intput, size)}")

    println("$intput -> ${rightMask(intput, size)}")

}