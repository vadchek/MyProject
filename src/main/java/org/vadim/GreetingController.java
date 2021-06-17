package org.vadim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.vadim.domain.UserResults;
import org.vadim.repos.UserResultsRepo;

@Controller
public class GreetingController {

    @Autowired
    private UserResultsRepo userResultsRepo;

    @GetMapping("/")
    public String greeting(@RequestParam(defaultValue = "") String res, Model model) {

        model.addAttribute("res", res);
        return "greeting";
    }

    @GetMapping("/list")
    public String list(Model model){
        Iterable<UserResults> results = userResultsRepo.findAll();
        model.addAttribute("uRes", results);
        return "list";
    }

    @PostMapping("/")
    public String retResult(@RequestParam(defaultValue = "0") int ans1, @RequestParam(defaultValue = "0") int ans2,
                            @RequestParam(defaultValue = "0") int ans3, @RequestParam(defaultValue = "") String res, Model model) {

        int count = 0;
        if (ans1 == 0)
            count++;
        if (ans2 == 11)
            count++;
        if (ans3 == 8)
            count++;
        int result = count * 100 / 3;
        UserResults userResults = new UserResults(result);
        userResultsRepo.save(userResults);
        res = "Your result: " + result + "%";
        model.addAttribute("res", res);
        return "greeting";
    }

    @PostMapping("/list")
    public String resList(Model model){
        Iterable<UserResults> results = userResultsRepo.findAll();
        model.addAttribute("uRes", results);
        return "list";
    }
}
