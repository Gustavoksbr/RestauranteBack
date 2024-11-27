package com.scrum.restaurante.domain.managerimpl;

import com.scrum.restaurante.domain.model.Jwt;
import com.scrum.restaurante.domain.model.usuario.AuthResponse;
import com.scrum.restaurante.domain.model.usuario.Usuario;
import com.scrum.restaurante.domain.model.email.Email;
import com.scrum.restaurante.domain.model.email.Provider;
import com.scrum.restaurante.domain.ports.repositories.UsuarioRepository;
import com.scrum.restaurante.domain.ports.services.EmailService;
import com.scrum.restaurante.domain.ports.services.JwtService;
import com.scrum.restaurante.domain.ports.manager.UsuarioManager;
import com.scrum.restaurante.domain.model.usuario.UsuarioBasic;
import com.scrum.restaurante.config.exception.exceptions.SenhaIncorretaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UsuarioManagerImpl implements UsuarioManager {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;


    // metodos privados

    private Usuario matches(Usuario usuario) {
        Usuario usuarioEncontrado = this.userRepository.encontrarPorUsername(usuario.getUsername());
        if (!passwordEncoder.matches(usuario.getPassword(), usuarioEncontrado.getPassword())) {
            throw new SenhaIncorretaException();
        }
        return usuarioEncontrado;
    }
    private final Map<String, String> verificationCodes = new HashMap<>();

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
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
    public AuthResponse authenticate(Usuario usuario) {
        Usuario usuarioEncontrado = this.matches(usuario); //verifica se a senha esta correta
        if(usuarioEncontrado.getDoisFatores()) {
            String verificationCode = this.generateVerificationCode();
            Email email = new Email(usuarioEncontrado.getUsername(),"Código de verificacao","Código de verificacao:"+verificationCode, Provider.MAILTRAP);
            this.emailService.sendEmail(email);
            this.verificationCodes.put(usuario.getUsername(),verificationCode );
            return new UsuarioBasic(usuarioEncontrado.getUsername(), usuario.getPassword());
        }
        return new Jwt(jwtService.generateToken(usuario.getUsername())); //retorna o token
    }

    @Override
   public String mudarNome(String nome, String token) {
        String username = jwtService.getUsername(token);
        Usuario usuario = userRepository.encontrarPorUsername(username);
        usuario.setNome(nome);
        userRepository.editarNome(usuario);
        return usuario.getNome();
    }

    @Override
    public Boolean habilitarDesabilitarDoisFatores(String token) {
        String username = jwtService.getUsername(token);
        Usuario usuario = this.userRepository.encontrarPorUsername(username);
        usuario.setDoisFatores(!usuario.getDoisFatores());
        this.userRepository.alterarDoisFatores(usuario);
        return usuario.getDoisFatores();
    }
}
