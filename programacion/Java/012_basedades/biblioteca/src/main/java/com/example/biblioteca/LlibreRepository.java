package com.example.biblioteca;

import org.springframework.data.repository.CrudRepository;


public interface LlibreRepository extends CrudRepository<Llibre, Integer> {
    Iterable<Llibre> findByNom(String name);
}
