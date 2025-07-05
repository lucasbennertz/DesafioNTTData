package com.lucas.ms2.Controller;

import com.lucas.ms2.Model.Products;
import com.lucas.ms2.Service.PedidosService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping()
    public Optional<List<Products>> getPedidos() {
        return pedidosService.getAvaliableProducts();
    }
    @PostMapping("/criar-pedido")
    public String postMethodName(@RequestBody List<Products> pedido) {
        return pedidosService.createOrder(pedido).toString();
    }
    
}
