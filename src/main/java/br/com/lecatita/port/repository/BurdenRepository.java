package br.com.lecatita.port.repository;

import br.com.lecatita.domain.model.Burden;

import java.util.List;

public interface BurdenRepository {
    List<Burden> addBatch(List<Burden> burdens);

    List<Burden> getAll(Long ano, String razaoSocial);
}
