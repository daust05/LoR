package lor.project.controller;

import lombok.extern.slf4j.Slf4j;
import lor.project.domain.Metadata;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/lor")
public class MainController {
    Metadata metadata = new Metadata();
    static String baseUrl = "lor/";

    @GetMapping
    public String index(Model model){
        model.addAttribute("developerCode",metadata.getDeveloperCode());
        return baseUrl+"main";
    }
    @PostMapping
    public String searchUser(String userName, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("userName",userName);
        return "redirect:/lor/{userName}";
    }

    @GetMapping("/{userName}")
    public String user(){
        return baseUrl+"user";
    }
}
