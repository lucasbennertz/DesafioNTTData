package com.lucas.ms2.Controller;

import com.lucas.ms2.Service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping()
    public String getPedidos() {
        return pedidosService.getAvaliableProducts().orElse("Nenhum produto disponível");
    }
}
