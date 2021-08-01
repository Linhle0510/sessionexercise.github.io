package vn.techmaster.shopingcart.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import vn.techmaster.shopingcart.model.Product;

@Repository
public class ProductRepository {
  private ArrayList<Product> products;
  private long nextId = 1;
  public ProductRepository() {
    products = new ArrayList<>();
    nextId = 1;

    initData();
  }

  public List<Product> getAll() {
    return products;
  }

  public Optional<Product> findById(long id) {
    return products.stream().filter(p -> p.getId() == id).findFirst();
  }
  
  public long createProduct(Product product) {
    product.setId(nextId);
    nextId += 1;
    products.add(product);
    return nextId;
  }
  
  public void initData() {
    createProduct(new Product("Suit", "Victoria Secret", 9000000, "/photo/suit.jpeg"));
    createProduct(new Product("Sony WXMH-1000", "Sony", 4500000, "/photo/headphone.jpeg"));
    createProduct(new Product("AirPod Pro", "Apple", 4000000, "/photo/Airpod.jpeg"));
    createProduct(new Product("Logitech MX Master 2S", "Logitech", 3000000, "/photo/mouse.jpg"));  
  }
    
}
