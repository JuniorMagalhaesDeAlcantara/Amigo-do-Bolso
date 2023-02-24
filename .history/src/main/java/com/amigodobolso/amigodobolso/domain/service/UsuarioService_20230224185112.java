package com.amigodobolso.amigodobolso.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Destination;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.amigodobolso.amigodobolso.domain.model.Usuario;
import com.amigodobolso.amigodobolso.domain.repository.UsuarioRepository;
import com.amigodobolso.amigodobolso.dto.usuario.UsuarioRequestDto;
import com.amigodobolso.amigodobolso.dto.usuario.UsuarioResponseDto;

public class UsuarioService implements ICRUDService<UsuarioRequestDto, UsuarioResponseDto> {

    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

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
    public UsuarioResponseDto obterPorId(Long id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);

        if(optUsuario.isEmpty()){

        }
        return mapper.map(optUsuario.get(), UsuarioResponseDto.class);
    }

    @Override
    public List<UsuarioResponseDto> obterTodos() {

        List<Usuario> usuarios = usuarioRepository.findAll();

       return usuarios.stream()
            .map(usuario -> mapper.map(usuario, UsuarioResponseDto.class))
            .collect(Collectors.toList());
    }

}
