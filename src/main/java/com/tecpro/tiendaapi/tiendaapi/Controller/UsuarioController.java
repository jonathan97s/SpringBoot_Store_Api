package com.tecpro.tiendaapi.tiendaapi.Controller;

import com.tecpro.tiendaapi.tiendaapi.DataBase.Administrador;
import com.tecpro.tiendaapi.tiendaapi.DataBase.Usuario;
import com.tecpro.tiendaapi.tiendaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping
    public List<Usuario> buscarTodosLosUsuarios() {
        return usuarioService.buscarTodosLosUsuarios();
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuarioPorId(@PathVariable Long id) {
        usuarioService.eliminarUsuariosPorId(id);
    }

    @GetMapping("/login/{nameId}")
    public String buscarContrasenaPorNameId(@PathVariable String nameId) {
        return usuarioService.buscarContrasenaPorNameId(nameId);
    }

    @GetMapping("/login/user/{nameId}")
    public Usuario buscarUsuarioPorNameId(@PathVariable String nameId) {
        return usuarioService.buscarUsuarioPorNameId(nameId);
    }


    @PostMapping("/login")
    public ResponseEntity<String> verificarCredenciales(@RequestParam String nameId, @RequestParam String contrasena) {
        boolean credencialesValidas = usuarioService.verificarCredenciales(nameId, contrasena);
        if (credencialesValidas) {
            return new ResponseEntity<>("Credenciales válidas", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }

}