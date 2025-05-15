package com.corhuila.Backend_CaffeNet.modules.pago_reserva.Entity;

import com.corhuila.Backend_CaffeNet.common.base.ABaseEntity;
import com.corhuila.Backend_CaffeNet.modules.reserva.Entity.Reserva;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "pago_reserva")
public class PagoReserva extends ABaseEntity {
    private String metodoPago;
    private BigDecimal monto;
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    public String getMetod_pago() {
        return metodoPago;
    }

    public void setMetod_pago(String metod_pago) {
        this.metodoPago = metod_pago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public void calcularMontoDesdeReserva() {
        if (reserva != null && reserva.getFecha_inicio() != null && reserva.getFechaFin() != null) {
            long diferenciaMilisegundos = reserva.getFechaFin().getTime() - reserva.getFecha_inicio().getTime();
            double horas = diferenciaMilisegundos / (1000.0 * 60 * 60); // convierte a horas

            double total = horas * reserva.getPrecio();
            this.monto = BigDecimal.valueOf(total);
        } else {
            this.monto = BigDecimal.ZERO; // Monto en cero si hay datos inválidos
        }
    }


}
