package lanchonete.lanche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanchoneteService {

    @Autowired
    private LancheRepository lancheRepository;


   public List<Lanche> getAllLanches(String pedidoId) {
        List<Lanche> lanche = new ArrayList<>();
       lancheRepository.findByPedidoId(pedidoId)
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
