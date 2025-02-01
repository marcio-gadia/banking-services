package br.net.estudos.controller;

import org.jboss.resteasy.reactive.RestResponse;

import br.net.estudos.domain.Agencia;
import br.net.estudos.service.AgenciaService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
   @Transactional
   public RestResponse<Void> Cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
        this.agenciaService.Cadastrar(agencia);
        return RestResponse.created(uriInfo.getAbsolutePath());
   }

   @GET
   @Path("{id}")
   @Transactional
   public RestResponse<Agencia> buscarPorId(Long id){
     Agencia agencia = this.agenciaService.BuscarPorId(id);
     return RestResponse.ok(agencia);
   }

   @DELETE
   @Path("{id}")
   @Transactional   
   public RestResponse<Void> deletarPorId(Long id){
     this.agenciaService.DeletarPorId(id);
     return RestResponse.ok();
   }

   @PUT
   @Transactional   
   public RestResponse<Void> alterar(Agencia agencia) {
     this.agenciaService.Alterar(agencia);
     return RestResponse.ok();
   }

}

