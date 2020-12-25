package ru.geekbrains.hibernate2.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.geekbrains.hibernate2.model.Product;

@Component
@RequiredArgsConstructor
public class ProductDao {
    private final SessionFactory sessionFactory;

    public void createNewProduct(String name, int price) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product product = new Product(null, name, price);
            session.save(product);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void readAndPrintProduct(Long id) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            System.out.println(product.toString());
            session.close();
        }
    }

    public void updateProduct(Long id, String name, int price) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setName(name);
            product.setPrice(price);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void deleteProductById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
            session.close();
        }
    }
}
