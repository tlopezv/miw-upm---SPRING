package com.miw.upm.persistance.daos;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.miw.upm.persistance.entitites.UnRelatedEntity;

public interface UnRelatedDao extends JpaRepository<UnRelatedEntity, Integer> {

    // Consulta: por Nombre de Método
    UnRelatedEntity findByNickIgnoreCase(String nickList);

    List<UnRelatedEntity> findFirst3ByNickStartingWith(String prefix);

    List<UnRelatedEntity> fingByNickOrLargeOrderByIdDesc(String nick, String large);

    List<UnRelatedEntity> findByIdGreaterThan(int id, Pageable pageable);

    List<UnRelatedEntity> findByIdIn(Collection<Integer> values);
}
