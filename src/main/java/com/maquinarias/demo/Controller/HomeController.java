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

    @GetMapping("/home")
    public String home( Model model){
         List<Maquinas> listaMaquinas = maquinasService.getAllMaquinas();
        model.addAttribute("maquinas", listaMaquinas);
        return "home"; 
    }
       

      @GetMapping("/")
    public String root(
        @RequestParam(name="name", required = false, defaultValue = "Contratacion y arriendo de maquinarias") 
        String name) {
        return "home";
    }
}
