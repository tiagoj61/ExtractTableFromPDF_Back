package br.com.lecatita.adapter.persistence;

import br.com.lecatita.domain.model.CompanyRequest;
import br.com.lecatita.port.repository.CompanyRequestRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CompanyRequestRepositoryImplementation implements PanacheRepository<CompanyRequest>, CompanyRequestRepository {

    @Override
    @Transactional
    public CompanyRequest add(CompanyRequest request) {
        persistAndFlush(request);
        return request;
    }

    @Override
    @Transactional
    public List<CompanyRequest> filter(Long year, Long companyId) {
        String query = "1=1";
        if(year != null && year > 0) {
            query += " and year = " + year;
        }
        if(companyId != null && companyId > 0) {
            query += " and company_id = " + companyId;
        }
        return list(query);
    }
}
