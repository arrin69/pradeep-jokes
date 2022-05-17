package guru.springframdwork.chucknorris.contorller

import guru.springframework.norris.chuck.ChuckNorrisQuotes
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping

@Controller
class ChuckNorrisController(
    private val jokeClient: JokeClient
) {
    private val log: Logger = LoggerFactory.getLogger(ChuckNorrisController::class.java)

    @GetMapping("/joke")
    fun getNewJoke(model: Model): String {
        val newJoke = this.jokeClient.getNewJoke()
        log.info("joke found: $newJoke")
        model.addAttribute("joker", newJoke)
        return "joker/norris"
    }
}

@Service
class JokeClient {
    fun getNewJoke(): String = ChuckNorrisQuotes()
        .randomQuote
        .replace("Chuck", "Pradeep", true)
        .replace("Norris", "Bhardwaj", true)
}