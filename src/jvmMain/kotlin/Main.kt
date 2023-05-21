import java.net.URL

fun main() {
    val url = "https://estudij.um.si/"
    val html = URL(url).readText()

    val pattern = """<div\s+title="([^"]+)".*?>""".toRegex(RegexOption.DOT_MATCHES_ALL)
    val matches = pattern.findAll(html)
        .map { it.groupValues[1].trim() }
        .toList()

    if (matches.isNotEmpty()) {
        println("Title attributes found in div elements:")
        matches.forEach { println(it) }
    } else {
        println("No div elements with a title attribute found.")
    }
}

