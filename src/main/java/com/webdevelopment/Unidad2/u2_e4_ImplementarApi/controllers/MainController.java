package com.webdevelopment.Unidad2.u2_e4_ImplementarApi.controllers;

import java.util.List;

import com.webdevelopment.Unidad2.u2_e4_ImplementarApi.models.Orders;
import com.webdevelopment.Unidad2.u2_e4_ImplementarApi.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/orders")
public class MainController {
    // Requiero INYECTAR una dependencia del servicio
    OrderService ordersService;

    public MainController(OrderService ordersService){
        this.ordersService = ordersService;
    }

    // GET - Todas las categorias
    @GetMapping
    public ResponseEntity<List<Orders>> getOrders(){
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    // GET- Solo una categoria
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderid(@PathVariable Long id){
        return ResponseEntity.ok(ordersService.getOrderById(id));
    }

    // POST - Creamos una categoria
    @PostMapping
    public ResponseEntity<Orders> addOrder(@RequestBody Orders orders){
        return ResponseEntity.ok(ordersService.createOrders(orders));
    }

    // PUT - Actualizar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders orders, @PathVariable Long id){
        //Que se requiere antes de actualizarla
        orders.setId(id);
        return ResponseEntity.ok(ordersService.updateOrders(orders));
    }

    // DELETE - Eliminar una categoria por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        ordersService.deleteOrders(id);
        return ResponseEntity.noContent().build();
    }
}