package br.com.lecatita.port.repository;

import br.com.lecatita.domain.model.Company;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface CompanyRepository {
    List<Company> getAll();

    Company getbyId(Long companyId);

    Company add(Company company);

    Boolean delete(Long companyId);

    Integer edit(Long id, String company);
}
