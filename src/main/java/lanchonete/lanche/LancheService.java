package lanchonete.lanche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LancheService {

    @Autowired
    private LancheRepository lancheRepository;

    private static Map<String, Lanche> lancheRep = new HashMap<>();


   public List<Lanche> getAllLanches() {
        List<Lanche> lanche = new ArrayList<>();
       lancheRepository.findAll()
       .forEach(lanche::add);
       return lanche;
   }



   public Lanche getLanche(String id) {
       return lancheRepository.findById(id).orElse(null);
   }

   public void addLanche(Lanche lanche) {
    lancheRepository.save(lanche);
   }

    public void updateLanche(Lanche lanche) {
      lancheRepository.save(lanche);
    }

    public void deleteLanche(String id) {
       lancheRepository.deleteById(id);
    }
}
