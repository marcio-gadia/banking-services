package br.net.estudos.service.http;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.net.estudos.domain.Agencia;
import br.net.estudos.domain.http.AgenciaHttp;
import br.net.estudos.domain.http.SituacaoCadastral;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenciaService {

    @RestClient
    private SituacaoCadastralHttpService situacaocadastralhttpservice;

    private List<Agencia> list_Agencias = new ArrayList<>();

    public void cadastrar(Agencia agencia) {

        AgenciaHttp agenciahttp = 
                    situacaocadastralhttpservice.buscarPorCnpj(agencia.getCnpj());

        if(agenciahttp.getSituacaocadastral().equals(SituacaoCadastral.ATIVO)) {
            list_Agencias.add(agencia);
        } else {
            throw new AgenciaNaoAtivaOuNaoEncontradaException(); 
        }
    }

}
