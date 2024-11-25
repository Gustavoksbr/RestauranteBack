package com.scrum.restaurante.domain.services;

import com.scrum.restaurante.domain.model.Jwt;
import com.scrum.restaurante.domain.model.Response;
import com.scrum.restaurante.domain.model.Usuario;
import com.scrum.restaurante.domain.ports.repositories.UsuarioRepository;
import com.scrum.restaurante.domain.ports.services.JwtService;
import com.scrum.restaurante.domain.ports.services.UsuarioManager;
import com.scrum.restaurante.infra.config.exception.exceptions.SenhaIncorretaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioManagerImpl implements UsuarioManager {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // metodos privados

    private void matches(Usuario usuario) {
        Usuario usuarioEncontrado = this.userRepository.encontrarPorUsername(usuario.getUsername());
        if (!passwordEncoder.matches(usuario.getPassword(), usuarioEncontrado.getPassword())) {
            throw new SenhaIncorretaException();
        }
    }


    // implementacoes
    @Override
    public String createUser(Usuario usuario) {
        // Criar uma nova instância de Usuario com a senha criptografada
        this.userRepository.validarNovoUsuario(usuario); //verifica se nao tem usuario com mesmo username ou email
        String senhaCriptografada = this.passwordEncoder.encode(usuario.getPassword()); //criptografa a senha
        Usuario usuarioParaSalvar = new Usuario(usuario.getUsername(), senhaCriptografada, usuario.getNome(), usuario.getEmail(), true, false); //cria o usuario com a senha criptografada
        this.userRepository.criar(usuarioParaSalvar);// Salvar o usuário
        return jwtService.generateToken(usuario.getUsername());// Gerar e retornar o token após o sucesso da criação
    }

    @Override
    public Response authenticate(Usuario usuario) {
        this.matches(usuario); //verifica se a senha esta correta
        return new Jwt(jwtService.generateToken(usuario.getUsername())); //retorna o token

    }
}
