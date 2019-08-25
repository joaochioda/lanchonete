package lanchonete.service;

import lanchonete.model.Ingredientes;
import lanchonete.model.Lanche;
import lanchonete.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LancheService {

    @Autowired
    private LancheRepository lancheRepository;
    @Autowired
    private IngredientesService ingredientesService;

   public List<Lanche> getAllLanches() {
        List<Lanche> lanche = new ArrayList<>();
       lancheRepository.findAll()
       .forEach(lanche::add);
       return lanche;
   }

   public Lanche getLancheId(Long id) {
       return lancheRepository.findById(id).orElse(null);
   }

   public void addLanche(Lanche lanche) {
       Optional<List<Ingredientes>> ingredientes = Optional.ofNullable(lanche.getIngredientes());

       if(ingredientes.isPresent()){
           Double price = 0.0;
           Lanche lanche1 = new Lanche();
           List<Ingredientes> ingredientes1 = lanche.getIngredientes();
           for( Ingredientes ingredientes2 : ingredientes1) {
               price +=ingredientesService.getIngredientesId(ingredientes2.getId()).getPrice();
           }
           lanche1.setName(lanche.getName());
           lanche1.setPrice(price);
           lanche1.setIngredientes(lanche.getIngredientes());
           lancheRepository.save(lanche1);
       } else {
           lancheRepository.save(lanche);

       }

   }

    public Object updateLanche(Lanche lanche, Long id) {
        return lancheRepository.findById(id)
                .map(ing ->{
                    ing.setName(lanche.getName());
                    ing.setPrice(lanche.getPrice());
                    Lanche updated = lancheRepository.save(ing);
                    return ResponseEntity.ok().body(updated);
                }).orElse(null);
    }

    public void deleteLanche(Long id) {
       lancheRepository.deleteById(id);
    }
}
