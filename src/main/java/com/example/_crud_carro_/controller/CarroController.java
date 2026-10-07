package com.example._crud_carro_.controller;


import com.example._crud_carro_.model.Carro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example._crud_carro_.service.CarroService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/carros")
public class CarroController {
    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> listarTodos() {
        return carroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id){
        Carro carro = carroService.buscarPorId(id);

        if (carro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public Carro salvar(@RequestBody Carro carro) {
        return carroService.salvar(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(
            @PathVariable Long id,
            @RequestBody Carro carro) {

        Carro carroAtualizado = carroService.atualizar(id, carro);

        if (carroAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        boolean deletado = carroService.deletar(id);

        if (!deletado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
