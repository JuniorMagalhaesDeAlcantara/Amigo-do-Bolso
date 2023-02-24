package com.amigodobolso.amigodobolso.domain.service;

import java.util.List;

import com.amigodobolso.amigodobolso.dto.usuario.UsuarioRequestDto;
import com.amigodobolso.amigodobolso.dto.usuario.UsuarioResponseDto;

public class UsuarioService implements ICRUDService<UsuarioRequestDto, UsuarioResponseDto> {

    @Override
    public UsuarioResponseDto atualizar(Long id, UsuarioRequestDto dto) {
        return null;
    }

    @Override
    public UsuarioResponseDto cadastrar(UsuarioRequestDto dto) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public UsuarioResponseDto obterPotId(Long id) {
        return null;
    }

    @Override
    public List<UsuarioResponseDto> obterTodos() {
        return null;
    }

}
