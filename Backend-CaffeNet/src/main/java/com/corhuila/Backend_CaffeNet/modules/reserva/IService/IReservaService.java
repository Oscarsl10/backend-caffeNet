package com.corhuila.Backend_CaffeNet.modules.reserva.IService;

import com.corhuila.Backend_CaffeNet.common.base.IBaseService;
import com.corhuila.Backend_CaffeNet.modules.reserva.Entity.Reserva;
import jakarta.transaction.Transactional;

public interface IReservaService extends IBaseService<Reserva> {

    @Transactional
    void liberarMesasReservasFinalizadas();

    public void crearReserva(Reserva reserva);

    public void finalizarReserva(Long idReserva);

}
