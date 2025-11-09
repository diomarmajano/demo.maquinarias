package com.maquinarias.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.maquinarias.demo.model.Maquinas;
import com.maquinarias.demo.service.MaquinasServiceImpl;

@Controller
public class HomeController {

    @Autowired
    private MaquinasServiceImpl maquinasService;

           
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }


    @GetMapping("/maquinarias")
    public String home(Model model){
        List<Maquinas> listaMaquinas = maquinasService.getAllMaquinas();
        model.addAttribute("maquinas", listaMaquinas);
        return "maquinarias"; 
    }

    @GetMapping("/registro")
    public String registro(Model model){
        List<Maquinas> listaMaquinas = maquinasService.getAllMaquinas();
        model.addAttribute("maquinas", listaMaquinas);
        return "registro"; 
    }

    @GetMapping("/login")
    public String login(){
        return "login"; 
    }
}
