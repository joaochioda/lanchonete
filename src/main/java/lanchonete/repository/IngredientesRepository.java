package lanchonete.repository;

import lanchonete.model.Ingredientes;
import org.springframework.data.repository.CrudRepository;

public interface IngredientesRepository extends CrudRepository <Ingredientes, Long> {
}
