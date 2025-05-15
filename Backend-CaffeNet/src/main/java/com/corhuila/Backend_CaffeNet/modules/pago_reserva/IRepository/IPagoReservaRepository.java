package com.corhuila.Backend_CaffeNet.modules.pago_reserva.IRepository;

import com.corhuila.Backend_CaffeNet.common.base.IBaseRepository;
import com.corhuila.Backend_CaffeNet.modules.pago_reserva.Entity.PagoReserva;
import com.corhuila.Backend_CaffeNet.modules.pedido.Entity.Pedido;
import org.springframework.stereotype.Repository;

@Repository

public interface IPagoReservaRepository extends IBaseRepository<PagoReserva, Long> {
}
