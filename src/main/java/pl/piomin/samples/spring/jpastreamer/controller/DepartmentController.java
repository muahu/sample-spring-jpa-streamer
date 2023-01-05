package pl.piomin.samples.spring.jpastreamer.controller;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piomin.samples.spring.jpastreamer.dto.DepartmentDTO;
import pl.piomin.samples.spring.jpastreamer.dto.EmployeeDTO;
import pl.piomin.samples.spring.jpastreamer.model.Department;
import pl.piomin.samples.spring.jpastreamer.model.Department$;
import pl.piomin.samples.spring.jpastreamer.model.Employee;
import pl.piomin.samples.spring.jpastreamer.model.Organization;
import pl.piomin.samples.spring.jpastreamer.repository.DepartmentRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DepartmentDTO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}/count-employees")
    public long getNumberOfEmployees(@PathVariable("id") Integer id) {
        return repository.getNumberOfEmployees(id);
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeDTO> getEmployees(@PathVariable("id") Integer id) {
        return repository.getEmployees(id);
    }
}
