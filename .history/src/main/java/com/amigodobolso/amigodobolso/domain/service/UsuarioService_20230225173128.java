package com.amigodobolso.amigodobolso.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Destination;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigodobolso.amigodobolso.domain.exception.ResourceBadRequestException;
import com.amigodobolso.amigodobolso.domain.exception.ResourceNotFoundException;
import com.amigodobolso.amigodobolso.domain.model.Usuario;
import com.amigodobolso.amigodobolso.domain.repository.UsuarioRepository;
import com.amigodobolso.amigodobolso.dto.usuario.UsuarioRequestDto;
import com.amigodobolso.amigodobolso.dto.usuario.UsuarioResponseDto;

@Service
public class UsuarioService implements ICRUDService<UsuarioRequestDto, UsuarioResponseDto> {

    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UsuarioResponseDto atualizar(Long id, UsuarioRequestDto dto) {
        UsuarioResponseDto usuarioBanco = obterPorId(id);
        validarUsuario(dto);

        Usuario usuario = mapper.map(dto, Usuario.class);

       // String senha = passwordEncoder.encode(dto.getSenha());
       // usuario.setSenha(senha);

        usuario.setId(id);
        usuario.setDataInativacao(usuarioBanco.getDataInativacao());
       // usuario.setDataCadastro(usuarioBanco.getDataCadastro());

        usuario = usuarioRepository.save(usuario);

        return mapper.map(usuario, UsuarioResponseDto.class);
    }

    @Override
    public UsuarioResponseDto cadastrar(UsuarioRequestDto dto) {
        validarUsuario(dto);

       // Optional<Usuario> optUsuario = usuarioRepository.findByEmail(dto.getEmail());

        //if(optUsuario.isPresent()){
        //    throw new ResourceBadRequestException("Já existe um usuário cadastro com o e-mail: " + dto.getEmail());
       // }

        Usuario usuario = mapper.map(dto, Usuario.class);

       // String senha = passwordEncoder.encode(usuario.getSenha());
       // usuario.setSenha(senha);

        usuario.setId(null);
        usuario.setDataCadastro(new Date());
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDto.class);
    }

    @Override
    public void deletar(Long id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);

        if (optUsuario.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }

        Usuario usuario = optUsuario.get();

        usuario.setDataInativacao(new Date());
        
        usuarioRepository.save(usuario);
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

    private void validarUsuario(UsuarioRequestDto dto) {

        if (dto.getEmail() == null || dto.getSenha() == null) {
            throw new ResourceBadRequestException("E-mail e senha são obrigatórios");
        }
    }

}
