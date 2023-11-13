package com.project.enhance.location.service;

import java.util.List;

import com.project.enhance.location.dto.AreaDto;

public interface LocationService {

	List<AreaDto> findAll();

	AreaDto findById(String id);

}
