package net.java.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.java.emsbackend.dto.EmployeeDto;
import net.java.emsbackend.entity.Employee;
import net.java.emsbackend.exeption.ResourceNotFound;
import net.java.emsbackend.mapper.EmployeeMapper;
import net.java.emsbackend.repository.EmployeeRepository;
import net.java.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFound("Employee doesn't exist witht the given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeed) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFound("Employee does not exist: " + employeeId)
        );

        employee.setFirstName(updatedEmployeed.getFirstName());
        employee.setLastName(updatedEmployeed.getLastName());
        employee.setEmail(updatedEmployeed.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFound("Employee does not exist: " + employeeId)
        );
        employeeRepository.deleteById(employeeId);

    }
}
