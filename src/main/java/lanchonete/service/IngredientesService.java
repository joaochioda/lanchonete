package lanchonete.service;

import lanchonete.model.Ingredientes;
import lanchonete.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientesService {
    @Autowired
    private IngredientesRepository ingredientesRepository;

    public void AddIngrediente(Ingredientes ingredientes) {
        ingredientesRepository.save(ingredientes);
    }

    public List<Ingredientes> GetAllIngredientes() {
        List<Ingredientes> ingrediente = new ArrayList<>();
        ingredientesRepository.findAll()
                .forEach(ingrediente::add);
        return ingrediente;
    }

    public Object updateIngredintes(Ingredientes ingredientes, Long id) {

        return ingredientesRepository.findById(id)
                .map(ing ->{
                    ing.setName(ingredientes.getName());
                    ing.setPrice(ingredientes.getPrice());
                    Ingredientes updated = ingredientesRepository.save(ing);
                    return ResponseEntity.ok().body(updated);
                }).orElse(null);
    }

    public Ingredientes getIngredientesId(Long id) {
        return ingredientesRepository.findById(id).orElse(null);
    }

    public void deleteIngredientes(Long id) {
        ingredientesRepository.deleteById(id);
    }

}
