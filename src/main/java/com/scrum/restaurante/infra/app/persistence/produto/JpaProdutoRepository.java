package com.scrum.restaurante.infra.app.persistence.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface JpaProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
