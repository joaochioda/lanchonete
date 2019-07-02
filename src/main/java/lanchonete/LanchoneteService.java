package lanchonete;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LanchoneteService {

   private List<Lanche> lanches = new ArrayList<>(Arrays.asList(
           new Lanche("1","X-tudo",10),
           new Lanche("2","X-calabresa",8),
           new Lanche("3","X-salada",5)
   ));

   public List<Lanche> getAllLanches() {
       return lanches;
   }

   public Lanche getLanche(String id) {
      return lanches.stream().filter(t->t.getId().equals(id)).findFirst().get();
   }

   public void addLanche(Lanche lanche) {
       lanches.add(lanche);
   }

    public void updateLanche(Lanche lanche, String id) {
       for (int i=0;i<lanches.size();i++){
           Lanche t = lanches.get(i);
           if(t.getId().equals(id)){
               lanches.set(i,lanche);
               return;
           }
       }
    }

    public void deleteTopic(String id) {
       lanches.removeIf(t-> t.getId().equals(id));
    }
}
