package br.com.lecatita.adapter.persistence;

import br.com.lecatita.domain.model.Burden;
import br.com.lecatita.port.repository.BurdenRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BurdenRepositoryImplementation implements PanacheRepository<Burden>, BurdenRepository {

    @Override
    @Transactional
    public List<Burden> addBatch(List<Burden> burdens) {
        persist(burdens);
        flush();
        return burdens;
    }

    @Override
    @Transactional
    public List<Burden> getAll(Long ano, String razaoSocial) {
        String query = "";
        if(ano != null && ano > 0) {
            query += "year = " + ano;
        }
        if(razaoSocial != null && razaoSocial.length() > 0) {
            if(ano != null && ano > 0) {
                query += " and ";
            }
            query += "UPPER(company.Name) like '%" + razaoSocial.toUpperCase() + "%'";
        }
        query += "order by company_id, year";
        return list(query);
    }
}
