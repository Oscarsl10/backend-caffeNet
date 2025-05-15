package com.corhuila.Backend_CaffeNet.modules.pago_reserva.Controller;

import com.corhuila.Backend_CaffeNet.common.base.ABaseController;
import com.corhuila.Backend_CaffeNet.modules.pago_reserva.Entity.PagoReserva;
import com.corhuila.Backend_CaffeNet.modules.pago_reserva.IService.IPagoReservaService;
import com.corhuila.Backend_CaffeNet.modules.pago_reserva.Service.PagoReservaService;
import com.corhuila.Backend_CaffeNet.modules.producto.Entity.Producto;
import com.corhuila.Backend_CaffeNet.modules.producto.IService.IProductoService;
import com.corhuila.Backend_CaffeNet.modules.reserva.Entity.Reserva;
import com.corhuila.Backend_CaffeNet.modules.reserva.IRepository.IReservaRepository;
import com.corhuila.Backend_CaffeNet.modules.reserva.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/pago/reserva")
public class PagoReservaController extends ABaseController<PagoReserva, IPagoReservaService> {
    public PagoReservaController(IPagoReservaService service) {
        super(service, "Continent");
    }
    @Autowired
    PagoReservaService pagoReservaService;
    @Autowired
    IReservaRepository reservaRepository;
    @PostMapping("/add")
    public ResponseEntity<PagoReserva> create(@RequestBody PagoReserva pagoReserva) {
        // Obtener la reserva completa desde el repositorio usando el ID
        Reserva reserva = reservaRepository.findById(pagoReserva.getReserva().getId())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        // Asignar la reserva y el monto al objeto de pago
        pagoReserva.setReserva(reserva);
        // Guardar el pago en la base de datos
        PagoReserva nuevoPago = pagoReservaService.save(pagoReserva);

        // Devolver el pago creado
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPago);
    }




}
