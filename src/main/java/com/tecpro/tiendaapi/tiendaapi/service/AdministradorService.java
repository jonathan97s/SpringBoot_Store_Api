package com.tecpro.tiendaapi.tiendaapi.service;

import com.tecpro.tiendaapi.tiendaapi.DataBase.Administrador;
import com.tecpro.tiendaapi.tiendaapi.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador guardarAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Administrador buscarAdministradorPorId(Long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    public List<Administrador> buscarTodosLosAdministradores() {
        return administradorRepository.findAll();
    }

    public void eliminarAdministradorPorId(Long id) {
        administradorRepository.deleteById(id);
    }

    public String buscarContrasenaPorNameId(String nameId) {
        return administradorRepository.findContrasenaByNameId(nameId);
    }
    public Administrador buscarAdministradorPorNameId(String nameId) {
        return administradorRepository.findAdministradorByNameId(nameId);

    }
    public boolean verificarCredenciales(String nameId, String contrasena) {
        String contrasenaAlmacenada = buscarContrasenaPorNameId(nameId);
        return contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contrasena);
    }

}
