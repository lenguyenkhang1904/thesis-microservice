package com.project.enhance.location.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.enhance.location.domain.Area;
import com.project.enhance.location.dto.AreaDto;
import com.project.enhance.location.repository.AreaRepository;
import com.project.enhance.location.service.LocationService;
import com.project.enhance.location.utils.ObjectMapperUtils;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired(required = true)
	private AreaRepository areaRepository;

	@Override
	public List<AreaDto> findAll() {

		List<Area> areas = areaRepository.findAll();

		List<AreaDto> areaDtos = ObjectMapperUtils.mapAll(areas, AreaDto.class);

		return areaDtos;
	}

	@Override
	public AreaDto findById(final String id) {
		Optional<Area> areaOpt = areaRepository.findById(id);
		if (areaOpt.isPresent()) {
			Area area = areaOpt.get();
			AreaDto areaDto = new AreaDto();
			areaDto = ObjectMapperUtils.map(area, AreaDto.class);
			return areaDto;
		}
		return null;
	}
}
