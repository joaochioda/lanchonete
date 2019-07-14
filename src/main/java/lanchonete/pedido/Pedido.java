package lanchonete.pedido;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Pedido {

    @Id
    private String id;
    private String name;
    private Number price;

    public Pedido(String id, String name, Number price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Pedido() {

    }
}
