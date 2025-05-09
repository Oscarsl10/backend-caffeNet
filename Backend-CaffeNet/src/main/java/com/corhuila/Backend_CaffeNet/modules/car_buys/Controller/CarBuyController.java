package com.corhuila.Backend_CaffeNet.modules.car_buys.Controller;

import com.corhuila.Backend_CaffeNet.common.base.ABaseController;
import com.corhuila.Backend_CaffeNet.modules.car_buys.Entity.CarBuy;
import com.corhuila.Backend_CaffeNet.modules.car_buys.IService.ICarBuyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carbuys")
@CrossOrigin(origins = "*")
public class CarBuyController extends ABaseController<CarBuy, ICarBuyService> {
    public  CarBuyController(ICarBuyService service) {
        super(service, "Continent");
    }

}