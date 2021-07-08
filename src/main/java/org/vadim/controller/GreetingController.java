package org.vadim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.vadim.domain.UserResults;
import org.vadim.repos.UserResultsRepo;
import org.vadim.domain.User;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class GreetingController {

    Authentication authentication;

    @Autowired
    private UserResultsRepo userResultsRepo;

    @GetMapping("/")
    public String greeting(@RequestParam(defaultValue = "") String res, Model model) {

        model.addAttribute("res", res);
        return "greeting";
    }


    @PostMapping("/")
    public String retResult(@AuthenticationPrincipal User user,
                            @RequestParam(defaultValue = "0") int ans1, @RequestParam(defaultValue = "0") int ans2,
                            @RequestParam(defaultValue = "0") int ans3, @RequestParam(defaultValue = "") String res,
                             Model model) {

        int count = 0;
        if (ans1 == 0)
            count++;
        if (ans2 == 11)
            count++;
        if (ans3 == 8)
            count++;
        int result = count * 100 / 3;
        LocalDateTime dateTime = LocalDateTime.now();
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String username = user.getUsername();
        UserResults userResults = new UserResults(result, username, date);
        userResultsRepo.save(userResults);
        res = "Your result: " + result + "%";
        model.addAttribute("res", res);
        return "greeting";
    }

    @GetMapping("/list")
    public String resList(Principal user, Model model){
        Iterable<UserResults> results = userResultsRepo.findByAuthorName(user.getName());
        model.addAttribute("uRes", results);
        return "list";
    }
}
