package learnprogramming.controller;

import learnprogramming.service.DemoService;
import learnprogramming.service.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // ==fields ==
    DemoService serwisDEmo;

    @Autowired
    public DemoController(DemoService serwisDEmo) {
        this.serwisDEmo = serwisDEmo;
    }

    // ==methods ==

    //http://localhost:8080/doto-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return serwisDEmo.getHelloMsg("Ola"); //nie zwykły string tylko view name
    }


    //http://localhost:8080/doto-list/welcome
    //http://localhost:8080/doto-list/welcome?user=Juki
    @GetMapping("welcome")
    public String welcomeCome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("zUrlHello", serwisDEmo.getHelloMsg(user)); //nazwa (key) której uzywam potem w .jsp
        model.addAttribute("age", age);
        log.info("model = {}", model);
        return "welcome"; //nazwa pliku widoku (JSP), a w viewResolver ustaliłam prefix i sufix tego pliku
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMsg calles");
        return "zwrotka z Demo app Welcome Msg";
    }

    @ModelAttribute("zSerwisuWelcome")
    public String serwisWelcome(){
        return serwisDEmo.getWelcomeMsg();
    }

    @ModelAttribute("zSerwisu")
    public String serwisHello(){
        return serwisDEmo.getHelloMsg("Ola");
    }
}
