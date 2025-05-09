package com.corhuila.Backend_CaffeNet.modules.car_buys.Service;

import com.corhuila.Backend_CaffeNet.common.base.ABaseService;
import com.corhuila.Backend_CaffeNet.common.base.IBaseRepository;
import com.corhuila.Backend_CaffeNet.modules.car_buys.Entity.CarBuy;
import com.corhuila.Backend_CaffeNet.modules.car_buys.IRepository.ICarBuyRepository;
import com.corhuila.Backend_CaffeNet.modules.car_buys.IService.ICarBuyService;
import com.corhuila.Backend_CaffeNet.modules.comprobante.Entity.Comprobante;
import com.corhuila.Backend_CaffeNet.modules.comprobante.IRepository.IComprobanteRepository;
import com.corhuila.Backend_CaffeNet.modules.comprobante.IService.IComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CarBuyService extends ABaseService<CarBuy> implements ICarBuyService {
    @Override
    protected IBaseRepository<CarBuy, Long> getRepository() {
        return carBuyRepository;
    }

    @Autowired
    private ICarBuyRepository carBuyRepository;
}

