package com.tecpro.tiendaapi.tiendaapi.repository;

import com.tecpro.tiendaapi.tiendaapi.model.ProductoCesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoCestaRepository extends JpaRepository<ProductoCesta, Long> {

    List<ProductoCesta> findByIdUsuario(long idUsuario);
}
