package ru.geekbrains.hibernate2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.hibernate2.dao.ProductDao;
import ru.geekbrains.hibernate2.model.Product;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ProductDao productDao;

}
