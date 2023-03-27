package com.codeup.codeupspringblog.controllers;//package com.codeup.codeupspringblog.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@Controller
//public class DiceController {
//
//    @GetMapping("/roll-dice")
//    public String showRollDicePage() {
//        return "roll-dice";
//    }
//    private int getRandomInt(int min, int max) {
//        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
//    }
//
//    @GetMapping("/roll-dice/{guess}")
//    public String rollDice(@PathVariable int guess, Model model) {
//        int roll = getRandomInt(1, 6);
//
//        model.addAttribute("roll", roll);
//        model.addAttribute("guess", guess);
//        model.addAttribute("userGuessedCorrectly", roll == guess);
//        model.addAttribute("userGuessedIncorrectly", roll != guess);
//
//        return "roll-dice-result";
//    }
//}

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/n")
    public String rollDiceGuess(@RequestParam int guess, Model model) {
        int roll = new Random().nextInt(6) + 1;
        String message = guess == roll ? "Congratulations, you guessed it!" : "Sorry, wrong guess!";
        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);
        model.addAttribute("message", message);
        return "roll-dice-guess";
    }
}
