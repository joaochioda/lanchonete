package lanchonete.service;

import lanchonete.model.Lanche;
import lanchonete.repository.LancheRepository;
import lanchonete.model.Pedido;
import lanchonete.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LancheRepository lancheRepository;

    @Autowired
    private LancheService lancheService;

   public List<Pedido> getAllPedido() {
        List<Pedido> pedido = new ArrayList<>();
       pedidoRepository.findAll()
       .forEach(pedido::add);
       return pedido;
   }

   public Pedido getPedido(Long id) {
       return pedidoRepository.findById(id).orElse(null);
   }

   public ResponseEntity<Object> addPedido(Pedido pedido) {
       Optional<List<Lanche>> lanches = Optional.ofNullable(pedido.getLanches());
       if(lanches.isPresent()){
           Double price = 0.0;
           Pedido pedido1 = new Pedido();
           for( Lanche lanche2 : lanches.get()) {
               price +=lancheService.getLancheId(lanche2.getId()).getPrice();
           }
           pedido1.setName(pedido.getName());
           pedido1.setPrice(price);
           pedido1.setLanches(pedido.getLanches());
           pedidoRepository.save(pedido1);
           return new ResponseEntity<Object>(pedido1, HttpStatus.CREATED);

       } else {
          pedidoRepository.save(pedido);
          return new ResponseEntity<Object>(pedido, HttpStatus.CREATED);
       }
   }


    public void updatePedido(Pedido pedido, Long id) {
        pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id) {
       pedidoRepository.deleteById(id);
    }
}
