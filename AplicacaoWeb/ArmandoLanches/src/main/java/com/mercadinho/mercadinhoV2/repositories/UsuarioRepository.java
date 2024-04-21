package com.mercadinho.mercadinhoV2.repositories;

import org.springframework.data.repository.CrudRepository;
import com.mercadinho.mercadinhoV2.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findById(long id);
}
