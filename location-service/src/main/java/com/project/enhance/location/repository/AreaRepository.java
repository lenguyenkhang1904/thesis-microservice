package com.project.enhance.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.enhance.location.domain.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, String> {

}
