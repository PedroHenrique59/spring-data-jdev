package org.dao;

import org.model.UsuarioSpringData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {

    @Query(value = "SELECT p FROM UsuarioSpringData p WHERE p.nome LIKE %?1%")
    public List<UsuarioSpringData> obterPorNome(String nome);

    @Query(value = "SELECT p FROM UsuarioSpringData p WHERE p.nome = :paramNome")
    public List<UsuarioSpringData> obterPorNomeParam(@Param("paramNome") String paramNome);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UsuarioSpringData u WHERE u.nome = ?1 ")
    public void excluirPorNome(String nome);
}