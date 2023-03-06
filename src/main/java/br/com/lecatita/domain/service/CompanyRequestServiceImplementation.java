package br.com.lecatita.domain.service;


import br.com.lecatita.domain.model.Burden;
import br.com.lecatita.domain.model.Company;
import br.com.lecatita.domain.model.CompanyRequest;
import br.com.lecatita.port.repository.BurdenRepository;
import br.com.lecatita.port.repository.CompanyRepository;
import br.com.lecatita.port.repository.CompanyRequestRepository;
import br.com.lecatita.port.service.CompanyRequestService;
import br.com.lecatita.port.service.JobService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CompanyRequestServiceImplementation implements CompanyRequestService {

    @Inject
    CompanyRequestRepository companyRequestRepository;

    @Inject
    BurdenRepository burdenRepository;

    @Inject
    CompanyRepository companyRepository;

    @Inject
    @RestClient
    JobService jobService;

    @Override
    public CompanyRequest add(CompanyRequest request, Long id) {
        Company company = companyRepository.getbyId(id);
        request.setCompany(company);
        CompanyRequest result = companyRequestRepository.add(request);
        jobService.invokeJob(result.getUrl(), result.getPage(), company.getId(),result.getYear());
        return request;
    }

    @Override
    public List<Burden> populateResponses(Long id, List<Burden> burdens) {
        Company company = companyRepository.getbyId(id);
        burdens.forEach(burden -> {
            burden.setCompany(company);
        });
        return burdenRepository.addBatch(burdens);
    }

    @Override
    public List<CompanyRequest> filter(Long year, Long companyId) {
        return companyRequestRepository.filter(year, companyId);
    }
}
