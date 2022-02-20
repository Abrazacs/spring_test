



public class Main {
    public static void main(String[] args) {
       ProductDao productDao = new ProductDao();
       Category category = new Category();
       category.setId(1);

        productDao.addNewProduct(new Product("Opel",15250,category));

        System.out.println(productDao.getProductById(5));
//        productDao.deleteById(2);
        System.out.println(productDao.getAllProducts());



    }
}
