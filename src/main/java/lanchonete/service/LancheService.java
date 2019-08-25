package lanchonete.service;

import lanchonete.model.Lanche;
import lanchonete.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LancheService {

    @Autowired
    private LancheRepository lancheRepository;

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
    lancheRepository.save(lanche);
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
