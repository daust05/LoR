package lor.project.controller;

import lombok.extern.slf4j.Slf4j;
import lor.project.domain.Metadata;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/lor")
public class MainController {

    @GetMapping
    public String home(){
        return "/lor/main";
    }
    @PostMapping
    public String searchUser(@RequestParam String userName,
                             @RequestParam String apiCode,
                             Model model){
        log.info("userName = " + userName);
        model.addAttribute("userName",userName);
        Metadata.setDeveloperCode(apiCode);

        return "/lor/user";
    }

    @GetMapping("/user")
    public String user(){
        return "/lor/user";
    }
}
