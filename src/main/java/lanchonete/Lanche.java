package lanchonete;

public class Lanche {

    private String id;
    private String name;
    private Number price;

    public Lanche(String id, String name, Number price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Lanche() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }


}
