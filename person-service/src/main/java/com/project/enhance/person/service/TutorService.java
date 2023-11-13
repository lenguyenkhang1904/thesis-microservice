package com.project.enhance.person.service;

import java.util.List;

import com.project.enhance.person.dto.TutorDto;

public interface TutorService {

	Long saveTutor(TutorDto request);

	List<TutorDto> findAllTutor();

}
