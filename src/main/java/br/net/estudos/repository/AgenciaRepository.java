package br.net.estudos.repository;

import br.net.estudos.domain.Agencia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenciaRepository implements PanacheRepository <Agencia>{

}
