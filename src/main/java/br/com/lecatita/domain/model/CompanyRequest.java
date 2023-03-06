package br.com.lecatita.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "companies_request")
@Getter
@Setter
public class CompanyRequest {
    @Id
    @GeneratedValue
    private Long id;

    private String url;

    private long page;

    private long year;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
