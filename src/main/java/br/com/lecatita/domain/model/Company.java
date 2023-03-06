package br.com.lecatita.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    private String Name;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<CompanyRequest> requests;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Burden> burdens;
}
