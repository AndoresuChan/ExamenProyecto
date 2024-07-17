package com.ufro.examen.services;

import com.ufro.examen.models.Reserva;
import com.ufro.examen.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva addReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva updateReserva(Long id, Reserva reserva) {
        Reserva existingReserva = reservaRepository.findById(id).orElse(null);
        if (existingReserva != null) {
            existingReserva.setNombre(reserva.getNombre());
            existingReserva.setOrigen(reserva.getOrigen());
            existingReserva.setDestino(reserva.getDestino());
            existingReserva.setFecha(reserva.getFecha());
            existingReserva.setHora(reserva.getHora());
            existingReserva.setCapacidad(reserva.getCapacidad());
            existingReserva.setPrecio(reserva.getPrecio());
            return reservaRepository.save(existingReserva);
        } return null;
        }
    }
