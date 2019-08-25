package lanchonete.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=50)

public class Ingredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ped")
    private Long id;
    private String name;
    private Double price;

    public Ingredientes(Long id,String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Ingredientes () {

    }

}
