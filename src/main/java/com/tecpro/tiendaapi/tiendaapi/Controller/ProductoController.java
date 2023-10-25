package com.tecpro.tiendaapi.tiendaapi.Controller;

import com.tecpro.tiendaapi.tiendaapi.model.Producto;
import com.tecpro.tiendaapi.tiendaapi.repository.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api_tienda")
public class ProductoController {

    //Cuando se utiliza @Autowired en un campo, método o constructor de una clase, Spring automáticamente busca y
    // proporciona la instancia de la clase necesaria en tiempo de ejecución. Es decir, Spring detecta la dependencia
    // necesaria para que el objeto funcione correctamente y la instancia e inyecta en la clase.
    @Autowired
    private ProductoServices productoServices;

    @PostMapping("/productos/")

    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        try {
            Producto _product = productoServices.save(new Producto(producto.getNombre(), producto.getDescripcion()
                    , producto.getEspecificacion(), producto.getPrecio(), producto.getDisponible(), producto.getMarca()
                    , producto.getUrlImagen(), producto.getImagenEspecificacionUrl() ,producto.getDestacado(), producto.getOferta(), producto.getCategoria()));
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/nombre/{nombre}")
    public ResponseEntity<List<Producto>> getProductoByName(@PathVariable("nombre") String nombre) {
        try {
            List<Producto> productos = new ArrayList<>();
            productoServices.findByNombre(nombre).forEach(productos::add);

            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(productos, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/productos/{id}")
    public   ResponseEntity<Producto> updateProducto(@PathVariable("id") long id, @RequestBody Producto producto) {
        Optional<Producto> productoData = productoServices.findById(id);
        if (productoData.isPresent()) {
            Producto _producto = productoData.get();
            _producto.setNombre(producto.getNombre());
            _producto.setDescripcion(producto.getDescripcion());
            _producto.setEspecificacion(producto.getEspecificacion());
            _producto.setPrecio(producto.getPrecio());
            _producto.setDisponible(producto.getDisponible());
            _producto.setMarca(producto.getMarca());
            _producto.setUrlImagen(producto.getUrlImagen());
            _producto.setImagenEspecificacionUrl(producto.getImagenEspecificacionUrl());
            _producto.setDestacado(producto.getDestacado());
            _producto.setOferta(producto.getOferta());
            _producto.setCategoria(producto.getCategoria());
            return new ResponseEntity<>(productoServices.save(_producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") long id) {
        try {
            productoServices.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long id) {
        Optional<Producto> producto = productoServices.findById(id);
        if (producto != null) {
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        try {
            List<Producto> productos = new ArrayList<Producto>();
            productoServices.findAll().forEach(productos::add);

            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/productos/oferta")
    public ResponseEntity<List<Producto>> getProductoByOferta(@RequestParam int oferta) {
        try {
            List<Producto> productos = new ArrayList<>();
            productoServices.findByOferta(oferta).forEach(productos::add);
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/precio")
    public ResponseEntity<List<Producto>> getProductoByPrecio(@RequestParam BigDecimal precio) {
        try {
            List<Producto> productos = new ArrayList<>();
            productoServices.findByPrecio(precio).forEach(productos::add);
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/destacado")
    public ResponseEntity<List<Producto>> getProductoByDestacado(@RequestParam boolean destacado) {
        try {
            List<Producto> productos = new ArrayList<>();
            productoServices.findByDestacado(destacado).forEach(productos::add);
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/categoria")
    public ResponseEntity<List<Producto>> getProductoByCategoria(@RequestParam String categoria) {
        try {
            List<Producto> productos = new ArrayList<>();
            productoServices.findByCategoria(categoria).forEach(productos::add);
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}
