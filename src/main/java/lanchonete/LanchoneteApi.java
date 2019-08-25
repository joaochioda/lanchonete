package lanchonete;

import lanchonete.model.Ingredientes;
import lanchonete.model.Lanche;
import lanchonete.repository.IngredientesRepository;
import lanchonete.repository.LancheRepository;
import lanchonete.service.IngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LanchoneteApi {
    @Autowired
    private IngredientesRepository ingredienteRepo;
    @Autowired
    private LancheRepository lancheRepo;
    @Autowired
    private IngredientesService ingredientesService;

    @Component
    class DataSetup implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments args) throws Exception{



            ingredienteRepo.save(Ingredientes.builder().id((long) 1.0).name("Alface").price(0.4).build());
            ingredienteRepo.save(Ingredientes.builder().id((long) 2.0).name("Bacon").price(2.0).build());
            ingredienteRepo.save(Ingredientes.builder().id((long) 3.0).name("Hámburguer de carne").price(3.0).build());
            ingredienteRepo.save(Ingredientes.builder().id((long) 4.0).name("Ovo").price(0.8).build());
            ingredienteRepo.save(Ingredientes.builder().id((long) 5.0).name("Queijo").price(1.5).build());



            lancheRepo.save(Lanche.builder().id((long) 1.0).name("xBacon").price(19.90).ingredientes(getListXbacon()).build());
            lancheRepo.save(Lanche.builder().id((long) 2.0).name("xBurguer").price(19.90).ingredientes(getListXburguer()).build());
            lancheRepo.save(Lanche.builder().id((long) 3.0).name("xEgg").price(19.90).ingredientes(getListXegg()).build());
            lancheRepo.save(Lanche.builder().id((long) 4.0).name("xEggBacon").price(19.90).ingredientes(getListXeggBacon()).build());

        }


    }

    public List<Ingredientes> getListXbacon () {
        List<Ingredientes> ingredientes = new ArrayList<>();
        ingredientes.add(ingredientesService.getIngredientesId((long) 2));
        ingredientes.add(ingredientesService.getIngredientesId((long) 3));
        ingredientes.add(ingredientesService.getIngredientesId((long) 5));
        return ingredientes;
    }

    public List<Ingredientes> getListXburguer () {
        List<Ingredientes> ingredientes = new ArrayList<>();
        ingredientes.add(ingredientesService.getIngredientesId((long) 3));
        ingredientes.add(ingredientesService.getIngredientesId((long) 5));
        return ingredientes;
    }

    public List<Ingredientes> getListXegg () {
        List<Ingredientes> ingredientes = new ArrayList<>();
        ingredientes.add(ingredientesService.getIngredientesId((long) 3));
        ingredientes.add(ingredientesService.getIngredientesId((long) 4));
        ingredientes.add(ingredientesService.getIngredientesId((long) 5));
        return ingredientes;
    }

    public List<Ingredientes> getListXeggBacon () {
        List<Ingredientes> ingredientes = new ArrayList<>();
        ingredientes.add(ingredientesService.getIngredientesId((long) 2));
        ingredientes.add(ingredientesService.getIngredientesId((long) 3));
        ingredientes.add(ingredientesService.getIngredientesId((long) 4));
        ingredientes.add(ingredientesService.getIngredientesId((long) 5));
        return ingredientes;
    }

    public static void main(String[] args) {
        SpringApplication.run(LanchoneteApi.class, args);
    }
}
