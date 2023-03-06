package br.com.lecatita;

import br.com.lecatita.domain.model.Company;
import br.com.lecatita.domain.model.User;
import br.com.lecatita.port.repository.CompanyRepository;
import br.com.lecatita.port.repository.UserRepository;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class Startup {

    @Inject
    UserRepository userRepository;

    @Inject
    CompanyRepository companyRepository;

    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        if(userRepository.getAll().size() == 0) {
            User user = new User();
            user.setUsername("admin@fin4she.co");
            user.setPassword("admin");
            user.setRole("admin");
            user.setName("admin");
            User add = userRepository.add(user);
        }

        if(companyRepository.getAll().size() == 0) {
            Company company = new Company();
            company.setName("Banco Pan");
            companyRepository.add(company);
        }
    }
}

