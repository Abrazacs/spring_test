import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    public Product(long id, String title, int price, Category category_id){
        this.id = id;
        this.title = title;
        this.price = price;
        this.category_id = category_id;
    }
    public Product(String title, int price, Category category_id){
        this.title = title;
        this.price = price;
        this.category_id = category_id;
    }


    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Category category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category_id=" + category_id +
                '}';
    }
}
