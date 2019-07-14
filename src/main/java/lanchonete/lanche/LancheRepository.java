package lanchonete.lanche;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LancheRepository extends CrudRepository <Lanche, String> {

    public List<Lanche> findByPedidoId(String pedidoId);

}
