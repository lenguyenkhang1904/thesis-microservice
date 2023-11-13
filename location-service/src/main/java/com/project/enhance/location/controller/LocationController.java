package com.project.enhance.location.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enhance.location.dto.AreaDto;
import com.project.enhance.location.service.LocationService;
import com.project.enhance.location.utils.ResponseHandler;

@RestController
@RequestMapping(value = "/area")
public class LocationController {
	
	private LocationService locationService;
	
	@GetMapping("/find-all-location")
	public ResponseEntity<Object> findAll() {
		List<AreaDto> areaDtos = locationService.findAll();
		return ResponseHandler.getResponse(areaDtos, HttpStatus.OK);
	}

	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") final String id) {
		AreaDto areaDto = locationService.findById(id);
		if (areaDto == null || StringUtils.isEmpty(id))
			return ResponseHandler.getResponse("Do not have this area in DB", HttpStatus.BAD_REQUEST);
		return ResponseHandler.getResponse(areaDto, HttpStatus.OK);
	}

}
