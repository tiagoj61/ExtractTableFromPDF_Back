package br.com.lecatita.port.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/invokejob")
@RegisterRestClient(baseUri = "http://localhost:8181/")
public interface JobService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String invokeJob(@QueryParam("downloadUrl") String downloadUrl,
                            @QueryParam("pagina") long pagina,
                            @QueryParam("empresaId") long empresaId,
                            @QueryParam("ano") long ano
                            );
}
