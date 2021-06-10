package org.vadim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String result, Model model) {
        model.addAttribute("result", result);
        return "greeting";
    }

    @PostMapping("/greeting")
    public String retResult(@RequestParam(defaultValue = "0") int ans1, @RequestParam(defaultValue = "0") int ans2,
                            @RequestParam(defaultValue = "0") int ans3, @RequestParam(defaultValue = "") String result, Model model) {

        int count = 0;
        if (ans1 == 10)
            count++;
        if (ans2 == 11)
            count++;
        if (ans3 == 8)
            count++;
        result = "Your result: " + count * 100 / 3 + "%";
        model.addAttribute("result", result);
        return "greeting";
    }
}
