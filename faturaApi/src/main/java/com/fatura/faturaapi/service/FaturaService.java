package com.fatura.faturaapi.service;

import com.fatura.faturaapi.model.Fatura;
import com.fatura.faturaapi.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listarFaturas() {
        return faturaRepository.findAll();
    }

    public Fatura cadastrarFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }
}
