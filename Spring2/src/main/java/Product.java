public class Product {
    private int id;
    private ProdEnum title;
    private int cost;

    public Product(int id, ProdEnum title, int cost){
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String toString(){
        return title + " цена: " + cost;
    }

}
