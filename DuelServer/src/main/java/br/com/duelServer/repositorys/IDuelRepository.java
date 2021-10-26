package br.com.duelServer.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.duelServer.entitys.Duel;

@Repository
public interface IDuelRepository extends JpaRepository<Duel, Long> {

}