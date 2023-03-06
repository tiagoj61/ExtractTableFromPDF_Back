package br.com.lecatita.domain.service;

import br.com.lecatita.domain.model.Company;
import br.com.lecatita.port.repository.CompanyRepository;
import br.com.lecatita.port.service.CompanyService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CompanyServiceImplementation implements CompanyService {

    @Inject
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    @Override
    public Company getbyId(Long companyId) {
        return companyRepository.getbyId(companyId);
    }

    @Override
    public Integer edit(Long id, String company) {
        return companyRepository.edit(id, company);
    }

    @Override
    public Company add(Company company) {
        return companyRepository.add(company);
    }

    @Override
    public Boolean delete(Long companyId) {
        return companyRepository.delete(companyId);
    }
}
