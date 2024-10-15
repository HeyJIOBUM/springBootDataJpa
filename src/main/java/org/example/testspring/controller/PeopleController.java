package org.example.testspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.testspring.repository.PeopleRepository;
import org.example.testspring.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleRepository peopleRepository;

    @PostMapping("")
    public Person savePerson(@RequestBody Person person) {
        return peopleRepository.save(person);
    }

    @GetMapping("")
    public List<Person> getPeople() {
        return peopleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return peopleRepository.findById(id).orElse(null);
    }
}
