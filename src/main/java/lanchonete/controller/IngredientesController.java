package lanchonete.controller;

import lanchonete.model.Ingredientes;
import lanchonete.service.IngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientesController {

    @Autowired
    private IngredientesService ingredientesService;

    @RequestMapping(method = RequestMethod.POST, value="/ingredientes")
    public void AddIngrediente(@RequestBody Ingredientes ingredientes) {
        ingredientesService.AddIngrediente(ingredientes);
    }

    @RequestMapping("/ingredientes")
    public List<Ingredientes> GetAllIngredientes() {
        return ingredientesService.GetAllIngredientes();
    }

    @RequestMapping(method = RequestMethod.PATCH, value="/ingredientes/{id}")
    public void updateIngredientes(@RequestBody Ingredientes ingredientes, @PathVariable Long id) {
        ingredientesService.updateIngredintes(ingredientes,id);
    }

    @RequestMapping("/ingredientes/{id}")
    public Ingredientes getPedido(@PathVariable Long id){
        return ingredientesService.getIngredientesId(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/ingredientes/{id}")
    public void deleteIngredientes(@PathVariable Long id) {
        ingredientesService.deleteIngredientes(id);
    }
}
