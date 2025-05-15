package com.corhuila.Backend_CaffeNet.modules.mesa.Controller;

import com.corhuila.Backend_CaffeNet.common.base.ABaseController;
import com.corhuila.Backend_CaffeNet.modules.mesa.Entity.Mesa;
import com.corhuila.Backend_CaffeNet.modules.mesa.IService.IMesaService;
import com.corhuila.Backend_CaffeNet.modules.mesa.Service.MesaService;
import com.corhuila.Backend_CaffeNet.modules.user.Entity.Users;
import com.corhuila.Backend_CaffeNet.modules.user.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin(origins = "*")
public class MesaController extends ABaseController<Mesa, IMesaService> {
    public MesaController(IMesaService service) {
        super(service, "Continent");
    }
    @Autowired
    MesaService mesaService;
    @GetMapping("/all")
    public List<Mesa> index(){
        return mesaService.findAll();
    }
}
