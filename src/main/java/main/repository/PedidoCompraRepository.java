package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.PedidoCompra;


public interface PedidoCompraRepository extends JpaRepository<PedidoCompra,Long>{
    PedidoCompra findById(String id);

}
