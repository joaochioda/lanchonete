package lanchonete.repository;

import lanchonete.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository <Pedido, String> {


}