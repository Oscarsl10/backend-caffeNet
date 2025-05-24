package com.corhuila.Backend_CaffeNet.modules.car_buys.Service;

import com.corhuila.Backend_CaffeNet.common.base.ABaseService;
import com.corhuila.Backend_CaffeNet.common.base.IBaseRepository;
import com.corhuila.Backend_CaffeNet.modules.car_buys.Entity.CarBuy;
import com.corhuila.Backend_CaffeNet.modules.car_buys.IRepository.ICarBuyRepository;
import com.corhuila.Backend_CaffeNet.modules.car_buys.IService.ICarBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBuyService extends ABaseService<CarBuy> implements ICarBuyService {

    @Autowired
    private ICarBuyRepository carBuyRepository;

    @Override
    protected IBaseRepository<CarBuy, Long> getRepository() {
        return carBuyRepository;
    }

    // Método para eliminar todos los productos
    public void deleteAll() {
        try {
            carBuyRepository.deleteAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar los productos del carrito: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        if (carBuyRepository.existsById(id)) {
            carBuyRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto con ID " + id + " no encontrado.");
        }
    }

}
