package com.tecpro.tiendaapi.tiendaapi.repository;

import com.tecpro.tiendaapi.tiendaapi.DataBase.Administrador;
import com.tecpro.tiendaapi.tiendaapi.DataBase.Usuario;
import com.tecpro.tiendaapi.tiendaapi.service.UsuarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u.contrasena FROM Usuario u WHERE u.nameId = :nameId")
    String findContrasenaByNameId(@Param("nameId") String nameId);

    @Query("SELECT u FROM Usuario u WHERE u.nameId = :nameId")
    Usuario findUsuarioByNameId(@Param("nameId") String nameId);

}