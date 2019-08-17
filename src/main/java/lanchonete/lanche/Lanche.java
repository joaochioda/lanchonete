package lanchonete.lanche;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
@Builder
@AllArgsConstructor
public class Lanche {

    @Id
    private String id;
    private String name;
    private Number price;

    public Lanche(String id, String name) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Lanche() {

    }


}
