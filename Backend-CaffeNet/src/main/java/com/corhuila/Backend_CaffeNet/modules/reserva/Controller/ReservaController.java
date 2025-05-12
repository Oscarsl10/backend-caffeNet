package com.corhuila.Backend_CaffeNet.modules.reserva.Controller;

import com.corhuila.Backend_CaffeNet.modules.reserva.IService.IReservaService;
import com.corhuila.Backend_CaffeNet.common.base.ABaseController;
import com.corhuila.Backend_CaffeNet.modules.reserva.Entity.Reserva;
import com.corhuila.Backend_CaffeNet.modules.reserva.Service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController extends ABaseController<Reserva, IReservaService> {
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
}
