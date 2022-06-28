package com.example.files_and_folders.repository;

import com.example.files_and_folders.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
