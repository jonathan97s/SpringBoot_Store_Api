package com.tecpro.tiendaapi.tiendaapi.repository;

import com.tecpro.tiendaapi.tiendaapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoServices extends JpaRepository<Producto, Long> {

    List<Producto> findByNombre(String nombre);

    List<Producto> findByPrecio(BigDecimal precio);

    List<Producto> findByOferta(int oferta);

    List<Producto> findByDestacado(boolean destacat);

    List<Producto> findByCategoria(String categoria);



}
