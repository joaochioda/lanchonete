package lanchonete.controller;

import lanchonete.model.Pedido;
import lanchonete.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @RequestMapping("/pedidos")
    public List<Pedido> getAllPedido() {
        return pedidoService.getAllPedido();
    }

    @RequestMapping("/pedidos/{id}")
    public Pedido getPedido(@PathVariable Long id){
        return pedidoService.getPedido(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/pedidos")
    public void addPedido(@RequestBody Pedido pedidos) {
        pedidoService.addPedido(pedidos);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/pedidos/{id}")
    public void updatePedido(@RequestBody Pedido pedido, @PathVariable Long id) {
        pedidoService.updatePedido(pedido,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/pedidos/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
    }

}
