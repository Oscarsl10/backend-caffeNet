package com.corhuila.Backend_CaffeNet.modules.car_buys.Entity;

import com.corhuila.Backend_CaffeNet.common.base.ABaseEntity;
import com.corhuila.Backend_CaffeNet.modules.car_buys.Enum.EstadoCarrito;
import com.corhuila.Backend_CaffeNet.modules.producto.Entity.Producto;
import com.corhuila.Backend_CaffeNet.modules.user.Entity.Users;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "carBuy")
public class CarBuy extends ABaseEntity {
    public CarBuy(){

    }

    @Column(name = "fecha_creacion")
    private LocalDateTime fecha_creacion;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoCarrito estado;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;



    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public EstadoCarrito getEstado() {
        return estado;
    }

    public void setEstado(EstadoCarrito estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}


