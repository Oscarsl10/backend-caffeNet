package com.corhuila.Backend_CaffeNet.modules.reserva.Service;

import com.corhuila.Backend_CaffeNet.common.base.ABaseService;
import com.corhuila.Backend_CaffeNet.modules.mesa.Entity.Mesa;
import com.corhuila.Backend_CaffeNet.modules.mesa.IRepository.IMesaRepository;
import com.corhuila.Backend_CaffeNet.modules.reserva.Entity.Reserva;
import com.corhuila.Backend_CaffeNet.modules.reserva.IService.IReservaService;
import com.corhuila.Backend_CaffeNet.common.base.IBaseRepository;
import com.corhuila.Backend_CaffeNet.modules.reserva.IRepository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReservaService extends ABaseService<Reserva> implements IReservaService {
    @Autowired
    private IMesaRepository mesaRepository;
    @Override
    protected IBaseRepository<Reserva, Long> getRepository() {
        return reservaRepository;
    }

    @Autowired
    private IReservaRepository reservaRepository;
    public void liberarMesasReservasFinalizadas() {
        Date ahora = new Date();
        List<Reserva> reservasFinalizadas = reservaRepository.findByFechaFinBeforeAndEstadoNot(ahora, "FINALIZADA");

        for (Reserva reserva : reservasFinalizadas) {
            Mesa mesa = reserva.getMesa();
            mesa.setEstado("DISPONIBLE");
            mesaRepository.save(mesa);

            reserva.setEstado("FINALIZADA");
            reservaRepository.save(reserva);
        }
    }
}
