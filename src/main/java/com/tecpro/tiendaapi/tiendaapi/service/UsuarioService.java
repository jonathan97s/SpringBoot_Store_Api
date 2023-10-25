package com.tecpro.tiendaapi.tiendaapi.service;

import com.tecpro.tiendaapi.tiendaapi.DataBase.Administrador;
import com.tecpro.tiendaapi.tiendaapi.DataBase.Usuario;
import com.tecpro.tiendaapi.tiendaapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> buscarTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuariosPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    public String buscarContrasenaPorNameId(String nameUsuario) {
        return usuarioRepository.findContrasenaByNameId(nameUsuario);
    }

    public Usuario buscarUsuarioPorNameId(String nameId) {
        return usuarioRepository.findUsuarioByNameId(nameId);

    }
    public boolean verificarCredenciales(String nameId, String contrasena) {
        String contrasenaAlmacenada = buscarContrasenaPorNameId(nameId);
        return contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contrasena);
    }

}
