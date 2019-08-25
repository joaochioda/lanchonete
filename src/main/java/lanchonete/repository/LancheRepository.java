package lanchonete.repository;

import lanchonete.model.Lanche;
import org.springframework.data.repository.CrudRepository;

public interface LancheRepository extends CrudRepository <Lanche, Long> {


}
