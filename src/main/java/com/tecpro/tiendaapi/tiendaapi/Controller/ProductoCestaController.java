package com.tecpro.tiendaapi.tiendaapi.Controller;

import com.tecpro.tiendaapi.tiendaapi.model.Producto;
import com.tecpro.tiendaapi.tiendaapi.model.ProductoCesta;
import com.tecpro.tiendaapi.tiendaapi.repository.ProductoCestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cesta")
public class ProductoCestaController {


    @Autowired
    ProductoCestaRepository productoCestaRepository;
    @PostMapping("/productosCesta")
    public ResponseEntity<ProductoCesta> createTutorial(@RequestBody ProductoCesta productoCesta) {
        try {
            ProductoCesta _productoCesta = productoCestaRepository
                    .save(new ProductoCesta(productoCesta.getImagenEspecificacionUrl(), productoCesta.getNombre(),
                            productoCesta.getPrecio(), productoCesta.getIdUsuario()));
            return new ResponseEntity<>(_productoCesta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productosCesta/idUsuario")
    public ResponseEntity<List<ProductoCesta>> getProductByUserId(@RequestParam long idUsuario) {
        try {
            List<ProductoCesta> productos = new ArrayList<>();
            productoCestaRepository.findByIdUsuario(idUsuario).forEach(productos::add);
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/productosCesta/{id}")
    public ResponseEntity<HttpStatus> deleteProductoCesta(@PathVariable("id") long id) {
        try {
            productoCestaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
