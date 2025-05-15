package com.corhuila.Backend_CaffeNet.modules.reserva.Controller;

import com.corhuila.Backend_CaffeNet.modules.reserva.IService.IReservaService;
import com.corhuila.Backend_CaffeNet.common.base.ABaseController;
import com.corhuila.Backend_CaffeNet.modules.reserva.Entity.Reserva;
import com.corhuila.Backend_CaffeNet.modules.reserva.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController extends ABaseController<Reserva, IReservaService> {

    @Autowired
    private IReservaService reservaService;

    public ReservaController(IReservaService service) {
        super(service, "Continent");
         this.reservaService=service;
    }

    @PostMapping("/liberar")
    public ResponseEntity<String> liberarMesasFinalizadas() {
        reservaService.liberarMesasReservasFinalizadas();
        return ResponseEntity.ok("Mesas liberadas correctamente.");
    }

    @PostMapping("/addReservation")
    public String crearReserva(@RequestBody Reserva reserva) {
        reservaService.crearReserva(reserva);
        return "Reserva creada y mesa ocupada.";
    }

    @PutMapping("/{id}/finalizar")
    public String finalizarReserva(@PathVariable Long id) {
        reservaService.finalizarReserva(id);
        return "Reserva finalizada y mesa liberada.";
    }
}
