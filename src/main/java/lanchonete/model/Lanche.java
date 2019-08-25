package lanchonete.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Builder
@TableGenerator(name="tab", initialValue=0, allocationSize=50)

public class Lanche {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    private Long id;
    private String name;
    private Number price;
    @ManyToMany
    private List<Ingredientes> ingredientes;

    public Lanche(Long id, String name, Number price, List<Ingredientes> ingredientes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredientes = ingredientes;
    }

    public Lanche() {

    }


}
