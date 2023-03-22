package com.amigodobolso.amigodobolso.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigodobolso.amigodobolso.domain.model.CentroDeCusto;
import com.amigodobolso.amigodobolso.domain.model.Usuario;

public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto, Long> {
    List<CentroDeCusto> findByUsuario(Usuario usuario);
}
