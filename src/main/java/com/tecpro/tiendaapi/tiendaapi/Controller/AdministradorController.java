package com.tecpro.tiendaapi.tiendaapi.Controller;


import com.tecpro.tiendaapi.tiendaapi.DataBase.Administrador;
import com.tecpro.tiendaapi.tiendaapi.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public Administrador guardarAdministrador(@RequestBody Administrador administrador) {
        return administradorService.guardarAdministrador(administrador);
    }

    @GetMapping("/{id}")
    public Administrador buscarAdministradorPorId(@PathVariable Long id) {
        return administradorService.buscarAdministradorPorId(id);
    }

    @GetMapping
    public List<Administrador> buscarTodosLosAdministradores() {
        return administradorService.buscarTodosLosAdministradores();
    }

    @DeleteMapping("/{id}")
    public void eliminarAdministradorPorId(@PathVariable Long id) {
        administradorService.eliminarAdministradorPorId(id);
    }

    @GetMapping("/login/{nameId}")
    public String buscarContrasenaPorNameId(@PathVariable String nameId) {
        return administradorService.buscarContrasenaPorNameId(nameId);
    }

    @GetMapping("/login/admin/{nameId}")
    public Administrador buscarAdministradorPorNameId(@PathVariable String nameId) {
        return administradorService.buscarAdministradorPorNameId(nameId);
    }

    @PostMapping("/login")
    public ResponseEntity<String> verificarCredenciales(@RequestParam String nameId, @RequestParam String contrasena) {
        boolean credencialesValidas = administradorService.verificarCredenciales(nameId, contrasena);
        if (credencialesValidas) {
            return new ResponseEntity<>("Credenciales válidas", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }

}