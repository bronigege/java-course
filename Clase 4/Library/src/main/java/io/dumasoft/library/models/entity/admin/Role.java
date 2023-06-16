package io.dumasoft.library.models.entity.admin;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(
        name = "authorities",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})}
)
public class Role implements Serializable {
    public static final long serialVersionUID = 75L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String authority;


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
