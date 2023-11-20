package net.java.emsbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "employess",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name  = "employee_id")
    )
     private Set<Employee> company_employees = new HashSet<>();

    @Column(name = "company_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "owner")
    private String owner;
    @Column(name = "email")
    private String email;

    public Company(Long id, String name, String address, String owner, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.email = email;
    }
}
