package br.com.lecatita.domain.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
@UserDefinition
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    public String name;

    @Username
    @Setter
    public String username;
    @Password
    public String password;

    @Roles
    @Setter
    public String role;

    public void setPassword(String password) {
        this.password = BcryptUtil.bcryptHash(password);
    }
}
