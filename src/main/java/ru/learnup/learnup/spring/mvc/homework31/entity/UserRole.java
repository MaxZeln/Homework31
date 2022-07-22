package ru.learnup.learnup.spring.mvc.homework31.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema = "public")
@Getter
@Setter
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
