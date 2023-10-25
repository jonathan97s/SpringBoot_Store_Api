package com.tecpro.tiendaapi.tiendaapi.repository;

import com.tecpro.tiendaapi.tiendaapi.DataBase.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    @Query("SELECT a.contrasena FROM Administrador a WHERE a.nameId = :nameId")
    String findContrasenaByNameId(@Param("nameId") String nameId);


    @Query("SELECT a FROM Administrador a WHERE a.nameId = :nameId")
    Administrador findAdministradorByNameId(@Param("nameId") String nameId);

}