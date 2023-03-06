package br.com.lecatita.adapter.rest;

import br.com.lecatita.domain.model.Burden;
import br.com.lecatita.domain.model.Company;
import br.com.lecatita.domain.model.CompanyRequest;
import br.com.lecatita.port.service.CompanyRequestService;
import br.com.lecatita.port.service.CompanyService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/companies")
public class CompanyController {

    @Inject
    CompanyService companyService;
    @Inject
    CompanyRequestService companyRequestService;
    @GET
    @RolesAllowed("admin")
    public List<Company> list() {
        return companyService.getAll();
    }
    @POST
    @RolesAllowed("admin")
    public Company add(Company company) {
        return companyService.add(company);
    }
    @PUT
    @Path("/{id}/{company}")
    @RolesAllowed("admin")
    public Integer edit(Long id,String company) {
        return companyService.edit(id,company);
    }
    @GET
    @Path("/{id}")
    @RolesAllowed("admin")
    public Company getById(Long id) {
        return companyService.getbyId(id);
    }
    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    public Boolean delete(Long id) {
        return companyService.delete(id);
    }

    @POST
    @Path("/{id}/request")
    @RolesAllowed("admin")
    public CompanyRequest newJobRequest(Long id, CompanyRequest request) {
        companyRequestService.add(request, id);
        return null;
    }

    @GET
    @Path("/requests")
    @RolesAllowed("admin")
    public List<CompanyRequest> getRequests(@QueryParam("year") Long year, @QueryParam("companyId") Long companyId) {
        return companyRequestService.filter(year, companyId);
    }

    @POST
    @Path("/{id}/response")
    public List<Burden> requestResponse(Long id, List<Burden> burdens) {
        return companyRequestService.populateResponses(id, burdens);
    }

//    @GET
//    @Path("/{id}/dashboard")
//    public List<>
}
