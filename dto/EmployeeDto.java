package net.java.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.java.emsbackend.entity.Employee;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto extends Employee {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;


}
