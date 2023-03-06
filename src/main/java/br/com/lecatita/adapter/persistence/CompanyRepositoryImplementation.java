package br.com.lecatita.adapter.persistence;

import br.com.lecatita.domain.model.Company;
import br.com.lecatita.port.repository.CompanyRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CompanyRepositoryImplementation implements PanacheRepository<Company>, CompanyRepository {

    @Override
    @Transactional
    public List<Company> getAll() {
        return listAll();
    }

    @Override
    @Transactional
    public Company getbyId(Long companyId) {
        return findById(companyId);
    }

    @Override
    @Transactional
    public Integer edit(Long id,    String company) {
        return update("name = ?1 where id = ?2", company, id);
    }

    @Override
    @Transactional
    public Company add(Company company) {
        persistAndFlush(company);
        return company;
    }

    @Override
    @Transactional
    public Boolean delete(Long companyId) {
        return deleteById(companyId);
    }
}
