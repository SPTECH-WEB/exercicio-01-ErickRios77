package com.fatura.faturaapi.controller;

import com.fatura.faturaapi.model.Fatura;
import com.fatura.faturaapi.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public ResponseEntity<List<Fatura>> listarFaturas() {
        List<Fatura> faturas = faturaService.listarFaturas();
        return faturas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(faturas);
    }

    @PostMapping
    public ResponseEntity<Fatura> cadastrarFatura(@Valid @RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.cadastrarFatura(fatura);
        return ResponseEntity.status(201).body(novaFatura);
    }
}
