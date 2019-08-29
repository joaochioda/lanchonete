package lanchonete.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=50)
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    private Long id;
    private String name;
    private Number price;
    @ManyToMany
    private List<Lanche> lanches;

    public Pedido(long id, String name, Double price, List <Lanche> lanches) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.lanches = lanches;
    }

    public Pedido() {

    }
}
