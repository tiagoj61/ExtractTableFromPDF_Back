package br.com.lecatita.port.service;

import br.com.lecatita.domain.model.Burden;
import br.com.lecatita.domain.model.CompanyRequest;

import java.util.List;

public interface CompanyRequestService {

    CompanyRequest add(CompanyRequest request, Long id);

    List<Burden> populateResponses(Long id, List<Burden> burdens);

    List<CompanyRequest> filter(Long year, Long companyId);
}
