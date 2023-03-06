package br.com.lecatita.port.service;

import br.com.lecatita.domain.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();

    Company getbyId(Long companyId);

    Company add(Company company);

    Boolean delete(Long companyId);

    Integer edit(Long id, String company);
}
