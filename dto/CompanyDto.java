package net.java.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.java.emsbackend.entity.Company;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDto extends Company {

    private Long id;
    private String name;
    private String address;
    private String owner;
    private String email;

}
