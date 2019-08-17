package lanchonete.pedido;

import lanchonete.lanche.Lanche;
import lanchonete.lanche.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LancheRepository lancheRepository;

   public List<Pedido> getAllPedido() {
        List<Pedido> pedido = new ArrayList<>();
       pedidoRepository.findAll()
       .forEach(pedido::add);
       return pedido;
   }

   public Pedido getPedido(String id) {
       return pedidoRepository.findById(id).orElse(null);
   }

   public void addPedido(Pedido pedido) {
       List<Lanche> allLanches = new ArrayList<>();
       lancheRepository.findAll().forEach(allLanches::add);

    List<Lanche> lanche = pedido.getLanches();
    List<Lanche> lancheAux = new ArrayList<>();

        for(Lanche lanche1 : lanche){
            for(Lanche lanche2: allLanches){
                if(lanche1.getId().equalsIgnoreCase(lanche2.getId())){
                    lancheAux.add(lanche2);
                }
            }
        }
        pedido.setLanches(lancheAux);
        double total = getAllPrice(lancheAux);
        pedido.setPrice(total);
        pedidoRepository.save(pedido);
   }

    private double getAllPrice(List<Lanche> lanches) {
       double total=0;
       for(Lanche lanche: lanches) {
           total = total + lanche.getPrice().doubleValue();
       }
       return total;
    }
    public void updatePedido(Pedido pedido, String id) {
      pedidoRepository.save(pedido);
    }

    public void deletePedido(String id) {
       pedidoRepository.deleteById(id);
    }
}
