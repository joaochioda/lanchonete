package lanchonete.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity

public class Pedido {

    @Id
    private String id;
    private String name;
    private Number price;
    @OneToMany
    private List<Lanche> lanches;

    public Pedido(String id, String name, Double price, List <Lanche> lanches) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.lanches = lanches;
    }

    public Pedido() {

    }
}
