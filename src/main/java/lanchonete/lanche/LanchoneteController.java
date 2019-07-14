package lanchonete.lanche;

import lanchonete.pedido.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanchoneteController {
    @Autowired
    private LanchoneteService lanchoneteService;

    @RequestMapping("/pedidos/{id}/lanches")
    public List<Lanche> getAllLanches(@PathVariable String id) {
        return lanchoneteService.getAllLanches(id);
    }

    @RequestMapping("/pedidos/{pedidoId}/lanches/{id}")
    public Lanche getLanche(@PathVariable String id){
        return lanchoneteService.getLanche(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/pedidos/{pedidoId}/lanches")
    public void addLanche(@RequestBody Lanche lanche, @PathVariable String pedidoId) {
        lanche.setPedido(new Pedido(pedidoId,"",0));
        lanchoneteService.addLanche(lanche);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/pedidos/{pedidoId}/lanches/{id}")
    public void updateLanche(@RequestBody Lanche lanche, @PathVariable String id, @PathVariable String pedidoId) {
        lanche.setPedido(new Pedido(pedidoId,"",0));
        lanchoneteService.updateLanche(lanche);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/pedidos/{pedidoId}/lanches/{id}")
        public void deleteLanche(@PathVariable String id) {
             lanchoneteService.deleteLanche(id);
        }

}
