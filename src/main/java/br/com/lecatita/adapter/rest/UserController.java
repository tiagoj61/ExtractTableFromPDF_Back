package br.com.lecatita.adapter.rest;

import br.com.lecatita.domain.model.User;
import br.com.lecatita.port.service.UserService;
import io.quarkus.security.credential.Credential;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@Path("/users")
@RolesAllowed("admin")
public class UserController {

    @Inject
    UserService userService;

    @Inject
    SecurityIdentity identity;

    @GET
    public List<User> list() {
        return userService.getAll();
    }
    @POST
    public User add(User user) {
        return userService.add(user);
    }
    @GET
    @Path("/{id}")
    public User getById(Long id) {
        return userService.getbyId(id);
    }
    @DELETE
    @Path("/{id}")
    public Boolean delete(Long id) {
        return userService.delete(id);
    }

    @GET
    @Path("/LoggedUser")
    public User getLoggedUser() {
        return userService.getByUserName(identity.getPrincipal().getName());
    }
}
