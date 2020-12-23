package ru.geekbrains.hibernate2.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.geekbrains.hibernate2.model.User;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final SessionFactory sessionFactory;

    public void createUser(String fio) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            User user = new User(null, fio);
            session.save(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void readAndPrintUser(Long id) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            System.out.println(user.toString());
            session.close();
        }
    }

    public void updateUser(Long id, String fio) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            user.setFio(fio);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void deleteUser(Long id) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }
    }
}
