package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = { "/", "/index" })
    public String index() throws Exception {
        return "index"; 
    }
    
    @RequestMapping(value = {"/writeCopy"})
    public String writeCopy() throws Exception{
        return "writeCopy"; 
    }
    @RequestMapping("/writeAction")
    public String writeAction() throws Exception{
        return "writeAction"; 
    }
    
}
