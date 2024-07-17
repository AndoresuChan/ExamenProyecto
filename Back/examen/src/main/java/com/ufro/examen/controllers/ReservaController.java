package com.ufro.examen.controllers;


import com.ufro.examen.models.Reserva;
import com.ufro.examen.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> addProduct(@RequestBody Reserva reserva) {
        Reserva addedReserva = reservaService.addReserva(reserva);
        return ResponseEntity.ok(addedReserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getProduct(@PathVariable Long id) {
        Reserva reserva = reservaService.getReservaById(id);
        return ResponseEntity.ok(reserva);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas = reservaService.getAllReservas();
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva updatedReserva = reservaService.updateReserva(id, reserva);
        return ResponseEntity.ok(updatedReserva);
    }
}
