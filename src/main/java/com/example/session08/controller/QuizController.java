package com.example.session08.controller;

import com.example.session08.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@SessionAttributes({"question", "attempts"})
public class QuizController {

    private List<Question> questions;

    public QuizController() {
        questions = new ArrayList<>();
        questions.add(new Question(1, "https://hips.hearstapps.com/hmg-prod/images/ripe-apple-royalty-free-image-1659454396.jpg?crop=0.924xw:0.679xh;0.0197xw,0.212xh&resize=980:*", "apple"));
        questions.add(new Question(2, "https://i.abcnewsfe.com/a/f43853f3-9eaf-4048-9ae7-757332c5787e/mclaren-1-ht-gmh-240412_1712928561648_hpMain_16x9.jpg?w=1600", "car"));
        questions.add(new Question(3, "https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg", "cat"));
    }

    @ModelAttribute("attempts")
    public Integer setAttempts() {
        return 0;
    }

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        Question random = questions.get(new Random().nextInt(questions.size()));
        model.addAttribute("question", random);
        model.addAttribute("message", "");
        model.addAttribute("gameOver", false);
        model.addAttribute("correct", false);
        model.addAttribute("attempts", 0);
        return "quiz";
    }

    @PostMapping("/guess")
    public String processGuess(@RequestParam("userAnswer") String userAnswer,
                               @ModelAttribute("question") Question question,
                               @ModelAttribute("attempts") Integer attempts,
                               Model model) {
        if (question.getAnswer().equalsIgnoreCase(userAnswer.trim())) {
            model.addAttribute("message", "Đã đoán đúng!");
            model.addAttribute("correct", true);
            return "quiz";
        }

        attempts++;
        model.addAttribute("attempts", attempts);

        if (attempts >= 3) {
            model.addAttribute("message", "Bạn hết lượt đoán!");
            model.addAttribute("gameOver", true);
        } else {
            model.addAttribute("message", "Sai rồi! Còn " + (3 - attempts) + " lượt.");
        }

        return "quiz";
    }
}
