package guru.springframdwork.chucknorris

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChuckNorrisApplication

fun main(args: Array<String>) {
    runApplication<ChuckNorrisApplication>(*args)
}
