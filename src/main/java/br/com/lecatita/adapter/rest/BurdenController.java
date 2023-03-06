package br.com.lecatita.adapter.rest;

import br.com.lecatita.domain.model.Burden;
import br.com.lecatita.domain.model.User;
import br.com.lecatita.port.repository.BurdenRepository;
import br.com.lecatita.port.service.BurdenService;
import br.com.lecatita.port.service.UserService;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/burdens")
@RolesAllowed("admin")
public class BurdenController {

    @Inject
    BurdenService burdenService;

    @GET
    public List<Burden> getAll(@QueryParam("ano") Long ano, @QueryParam("razaoSocial") String razaoSocial) {
        return burdenService.getAll(ano, razaoSocial);
    }
}
