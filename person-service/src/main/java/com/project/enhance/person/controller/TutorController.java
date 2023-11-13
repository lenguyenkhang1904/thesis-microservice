package com.project.enhance.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enhance.person.dto.TutorDto;
import com.project.enhance.person.service.TutorService;
import com.project.enhance.person.utils.ResponseHandler;

@RestController
@RequestMapping(value = "/tutor")
public class TutorController {

	@Autowired
	private TutorService tutorService;

	@PostMapping("/create")
	public ResponseEntity<Object> saveTutor(@RequestBody final TutorDto request) {
		Long id = tutorService.saveTutor(request);
		return ResponseHandler.getResponse(id, HttpStatus.OK);
	}

	@GetMapping("/find-all")
	public ResponseEntity<Object> findAllTutor() {
		List<TutorDto> tutorDtos = tutorService.findAllTutor();
		return ResponseHandler.getResponse(tutorDtos, HttpStatus.OK);
	}
}
