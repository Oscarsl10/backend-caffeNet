package com.corhuila.Backend_CaffeNet.modules.comprobante_reserva.Controller;

import com.corhuila.Backend_CaffeNet.common.base.ABaseController;
import com.corhuila.Backend_CaffeNet.modules.comprobante_reserva.Entity.Comprobante_reserva;
import com.corhuila.Backend_CaffeNet.modules.comprobante_reserva.IService.IComprobante_reservaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/comprobante_reserva")
public class Comprobante_reservaController extends ABaseController<Comprobante_reserva, IComprobante_reservaService> {

    public Comprobante_reservaController(IComprobante_reservaService service) {
        super(service, "Continent");
    }
}
