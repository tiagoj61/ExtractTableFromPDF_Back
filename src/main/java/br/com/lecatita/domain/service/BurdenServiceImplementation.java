package br.com.lecatita.domain.service;

import br.com.lecatita.domain.model.Burden;
import br.com.lecatita.port.repository.BurdenRepository;
import br.com.lecatita.port.service.BurdenService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BurdenServiceImplementation implements BurdenService {

    @Inject
    BurdenRepository burdenRepository;

    @Override
    @Transactional
    public List<Burden> getAll(Long ano, String razaoSocial) {
        return burdenRepository.getAll(ano, razaoSocial);
    }
}
