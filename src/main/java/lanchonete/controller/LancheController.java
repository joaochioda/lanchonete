package lanchonete.controller;

import lanchonete.model.Lanche;
import lanchonete.service.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LancheController {


    @Autowired
    private LancheService lancheService;

    @RequestMapping("/lanches")
    public List<Lanche> getAllLanches() {
        return lancheService.getAllLanches();
    }

    @RequestMapping(method = RequestMethod.POST, value="/lanches")
    public void addLanche(@RequestBody Lanche lanche) {
        lancheService.addLanche(lanche);
    }

    @RequestMapping(method = RequestMethod.PATCH, value="/lanches/{id}")
    public void updateLanche(@RequestBody Lanche lanche, @PathVariable Long id) {
        lancheService.updateLanche(lanche,id);
    }

    @RequestMapping("/lanches/{id}")
    public Lanche getLanche(@PathVariable Long id){
        return lancheService.getLancheId(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/lanches/{id}")
    public void deleteLanches(@PathVariable Long id) {
        lancheService.deleteLanche(id);
    }
}
