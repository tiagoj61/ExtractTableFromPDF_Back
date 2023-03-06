package br.com.lecatita.port.service;

import br.com.lecatita.domain.model.Burden;

import java.util.List;

public interface BurdenService {
    List<Burden> getAll(Long ano, String razaoSocial);
}
