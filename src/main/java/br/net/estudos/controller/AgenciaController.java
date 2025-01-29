package br.net.estudos.controller;

import org.jboss.resteasy.reactive.RestResponse;

import br.net.estudos.domain.Agencia;
import br.net.estudos.service.http.AgenciaService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

@Path("/agencias")
public class AgenciaController {

   private AgenciaService agenciaService;
   
   AgenciaController(AgenciaService agenciaService) {

        this.agenciaService = agenciaService;
   }

   @POST
   public RestResponse<Void> Cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
        this.agenciaService.Cadastrar(agencia);
        return RestResponse.created(uriInfo.getAbsolutePath());
   }
}
