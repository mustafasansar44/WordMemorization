package com.msansar.wordmemorization.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private List<Role> roles = List.of(Role.ROLE_USER, Role.ROLE_ADMIN);

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<WordGroup> wordGroupList = new ArrayList<>();

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public User(String username, String password, List<Role> roles){
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    public User(String id, Date createdAt, Date updatedAt, String username, String password, String email) {
        super(id, createdAt, updatedAt);
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }
}
