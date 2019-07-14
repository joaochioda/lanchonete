package lanchonete.lanche;

import lanchonete.pedido.Pedido;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@Entity
public class Lanche {

    @Id
    private String id;
    private String name;
    private Number price;
    @ManyToOne
    private Pedido pedido;

    public Lanche(String id, String name, Number price, String pedidoId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pedido = new Pedido(pedidoId,"",0);
    }

    public Lanche() {

    }


}
