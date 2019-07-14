package lanchonete.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


   private List<Pedido> lanches = new ArrayList<>(Arrays.asList(
           new Pedido("1","X-tudo",10),
           new Pedido("2","X-calabresa",8),
           new Pedido("3","X-salada",5)
   ));

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
    pedidoRepository.save(pedido);
   }

    public void updatePedido(Pedido pedido, String id) {
      pedidoRepository.save(pedido);
    }

    public void deletePedido(String id) {
       pedidoRepository.deleteById(id);
    }
}
