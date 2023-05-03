package org.dao;

import org.model.Telefone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {

}