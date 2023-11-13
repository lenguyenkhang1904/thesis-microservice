package com.project.enhance.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.enhance.person.domain.AreaTutor;

@Repository
public interface AreaTutorRepository extends JpaRepository<AreaTutor, String> {

}
