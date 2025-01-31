package br.net.estudos.service.http;

import br.net.estudos.domain.Agencia;
import br.net.estudos.exceptions.AgenciaNaoAtivaOuNaoEncontradaException;
import br.net.estudos.repository.AgenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenciaService {

    private AgenciaRepository agenciaRepository;

    public AgenciaService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public void Cadastrar(Agencia agencia) {

        if(agencia != null) {
            agenciaRepository.persist(agencia);
        } else {
            throw new AgenciaNaoAtivaOuNaoEncontradaException(); 
        }
    }

    public Agencia BuscarPorId (Long id) {
        return agenciaRepository.findById(id);
    }

    public void DeletarPorId (Long id) {
        agenciaRepository.deleteById(id);
    }

    public void Alterar (Agencia agencia) {
        agenciaRepository.update("nome = ?1, razaoSocial = ?2, cnpj = ?3 where id = ?4", 
                  agencia.getNome(), 
                  agencia.getRazaoSocial(), 
                  agencia.getCnpj(), 
                  agencia.getId()
                  );
    }
}
