package com.corhuila.Backend_CaffeNet.modules.mesa.Service;

import com.corhuila.Backend_CaffeNet.common.base.ABaseService;
import com.corhuila.Backend_CaffeNet.common.base.IBaseRepository;
import com.corhuila.Backend_CaffeNet.modules.mesa.Entity.Mesa;
import com.corhuila.Backend_CaffeNet.modules.mesa.IRepository.IMesaRepository;
import com.corhuila.Backend_CaffeNet.modules.mesa.IService.IMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MesaService extends ABaseService<Mesa> implements IMesaService {
    @Override
    protected IBaseRepository<Mesa, Long> getRepository() {
        return mesaRepository;
    }

    @Autowired
    private IMesaRepository mesaRepository;
}
