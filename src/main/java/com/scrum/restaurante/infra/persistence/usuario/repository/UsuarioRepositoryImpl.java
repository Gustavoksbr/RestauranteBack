package com.scrum.restaurante.infra.persistence.usuario.repository;


import com.scrum.restaurante.domain.model.usuario.Usuario;
import com.scrum.restaurante.domain.ports.repositories.UsuarioRepository;
import com.scrum.restaurante.infra.persistence.usuario.entity.UserEntity;
import com.scrum.restaurante.config.exception.exceptions.JaExisteException;
import com.scrum.restaurante.config.exception.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Autowired
    private JpaUsuarioRepository jpaUsuarioRepository;

    //metodos privados
    private UserEntity entityFindByUsername(String username) {
        return this.jpaUsuarioRepository.findByUsernameAndAtivoTrue(username).orElseThrow(() -> new ResourceNotFoundException("Usuario "+username+" não encontrado"));
    }


    @Override
    public Boolean existePorUsername(String username) {
        return this.jpaUsuarioRepository.existsByUsername(username);
    }
    @Override
    public Boolean existePorEmail(String email) {
        return this.jpaUsuarioRepository.existsByEmail(email);
    }

    @Override
    public Usuario editarNome(Usuario usuario) {
        UserEntity userEntity = this.entityFindByUsername(usuario.getUsername());
        userEntity.setNome(usuario.getNome());
        return this.jpaUsuarioRepository.save(userEntity).toUsuario();
    }

    @Override
    public Usuario encontrarPorUsername(String username) {
        return this.entityFindByUsername(username).toUsuario();
    }


//    @Override
//    public List<Usuario> listar() {
//        return this.jpaUsuarioRepository.findAllByAtivoTrue().stream().map(UserEntity::toUsuario).toList();
//    }

    @Override
    public Usuario criar(Usuario usuario) {
        return this.jpaUsuarioRepository.save(new UserEntity(usuario)).toUsuario();
    }

    @Override
    public void  validarNovoUsuario(Usuario usuario) {
        String username = usuario.getUsername();
        String email = usuario.getEmail();
        if (this.existePorUsername(usuario.getUsername())) {
            throw new JaExisteException("Usuario com username " + username + " já existe");
        }
        if (this.existePorEmail(usuario.getEmail())) {
            throw new JaExisteException("Usuario com email " + email + " já existe");
        }
    }
    @Override
    public void alterarDoisFatores(Usuario usuario) {
        UserEntity userEntity = this.entityFindByUsername(usuario.getUsername());
        userEntity.setDoisFatores(usuario.getDoisFatores());
        this.jpaUsuarioRepository.save(userEntity);
    }
}
