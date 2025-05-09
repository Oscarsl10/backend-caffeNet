package com.corhuila.Backend_CaffeNet.modules.mesa.Controller;

import com.corhuila.Backend_CaffeNet.common.base.ABaseController;
import com.corhuila.Backend_CaffeNet.modules.mesa.Entity.Mesa;
import com.corhuila.Backend_CaffeNet.modules.mesa.IService.IMesaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin(origins = "*")
public class MesaController extends ABaseController<Mesa, IMesaService> {
    public MesaController(IMesaService service) {
        super(service, "Continent");
    }

}
