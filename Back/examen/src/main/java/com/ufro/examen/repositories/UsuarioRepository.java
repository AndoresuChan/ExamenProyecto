package com.ufro.examen.repositories;

import com.ufro.examen.models.Reserva;
import com.ufro.examen.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}