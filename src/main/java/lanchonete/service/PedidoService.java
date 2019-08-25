package lanchonete.service;

import lanchonete.repository.LancheRepository;
import lanchonete.model.Pedido;
import lanchonete.repository.PedidoRepository;
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

        pedidoRepository.save(pedido);
   }


    public void updatePedido(Pedido pedido, String id) {
        pedidoRepository.save(pedido);
    }

    public void deletePedido(String id) {
       pedidoRepository.deleteById(id);
    }
}
