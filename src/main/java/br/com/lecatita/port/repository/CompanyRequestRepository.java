package br.com.lecatita.port.repository;

import br.com.lecatita.domain.model.CompanyRequest;

import java.util.List;

public interface CompanyRequestRepository {
    CompanyRequest add(CompanyRequest request);

    List<CompanyRequest> filter(Long year, Long companyId);
}
