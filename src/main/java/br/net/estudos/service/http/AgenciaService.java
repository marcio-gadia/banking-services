package br.net.estudos.service.http;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.net.estudos.domain.Agencia;
import br.net.estudos.domain.http.AgenciaHttp;
import br.net.estudos.domain.http.SituacaoCadastral;
import br.net.estudos.exceptions.AgenciaNaoAtivaOuNaoEncontradaException;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenciaService {

    @RestClient
    private SituacaoCadastralHttpService situacaocadastralhttpservice;

    private List<Agencia> agencias = new ArrayList<>();

    public void Cadastrar(Agencia agencia) {

        AgenciaHttp agenciahttp = 
                    situacaocadastralhttpservice.buscarPorCnpj(agencia.getCnpj());

        if(agenciahttp != null &&
           agenciahttp.getSituacaocadastral().equals(SituacaoCadastral.ATIVO)) {
            agencias.add(agencia);
        } else {
            throw new AgenciaNaoAtivaOuNaoEncontradaException(); 
        }
    }

    public Agencia BuscarPorId (Integer id) {
        return agencias.stream()
               .filter(agencia -> agencia.getId().equals(id))
               .findFirst().get();
    }

    public void DeletarPorId (Integer id) {
        agencias.removeIf(agencia -> agencia.getId().equals(id));
    }

    public void Alterar (Agencia agencia) {
        DeletarPorId(agencia.getId());
        Cadastrar(agencia);
    }
}
