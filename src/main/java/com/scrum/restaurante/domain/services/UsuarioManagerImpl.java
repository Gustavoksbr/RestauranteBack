package com.scrum.restaurante.domain.services;


import com.scrum.restaurante.domain.model.Response;
import com.scrum.restaurante.domain.model.Usuario;
import com.scrum.restaurante.domain.ports.repositories.UsuarioRepository;
import com.scrum.restaurante.domain.ports.services.JwtService;
import com.scrum.restaurante.domain.ports.services.UsuarioManager;
import com.scrum.restaurante.infra.app.persistence.usuario.entity.UserEntity;
import com.scrum.restaurante.infra.app.persistence.usuario.repository.JpaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioManagerImpl implements UsuarioManager {

    @Autowired
    private JpaUsuarioRepository jpaUsuarioRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Override
//    public List<Usuario> listarUsuarios(String substring) {
//        return List.of();
//    }

    @Override
    public String createUser(Usuario usuario) {
        // Criar uma nova instância de Usuario com a senha criptografada
        String senhaCriptografada = this.passwordEncoder.encode(usuario.getPassword());
        Usuario usuarioParaSalvar = new Usuario(usuario.getUsername(), senhaCriptografada, usuario.getNome(),
                usuario.getEmail(), true, false);

        // Salvar o usuário
        this.userRepository.criar(usuarioParaSalvar);

        // Gerar e retornar o token após o sucesso da criação
        return jwtService.generateToken(usuario.getUsername());
    }

//    @Override
//    public Response authenticate(Usuario usuario) {
//        return null;
//    }
//
//    @Override
//    public String authenticate2fa(Usuario usuario, String codigo) {
//        return "";
//    }
//
//    @Override
//    public Boolean habilitarDesabilitarDoisFatores(String jwt) {
//        return null;
//    }
//
//    @Override
//    public Usuario alterarnome(Usuario usuario, String username) {
//        return null;
//    }
}
