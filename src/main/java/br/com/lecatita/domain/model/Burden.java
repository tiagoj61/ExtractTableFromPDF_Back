package br.com.lecatita.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "burdens")
@Getter
@Setter
public class Burden {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long quantity_male;

    private Long quantity_female;

    private Long year;

    @ManyToOne
    private Company company;
}
