package com.lucas.ms1.Repositories;

import com.lucas.ms1.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositorie extends JpaRepository<Products, Long> {
}
