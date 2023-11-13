package com.project.enhance.person.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.enhance.person.domain.AreaTutor;
import com.project.enhance.person.domain.Tutor;
import com.project.enhance.person.dto.TutorDto;
import com.project.enhance.person.repository.AreaTutorRepository;
import com.project.enhance.person.repository.TutorRepository;
import com.project.enhance.person.service.TutorService;
import com.project.enhance.person.utils.DateConverter;
import com.project.enhance.person.utils.GenerateTutorId;
import com.project.enhance.person.utils.HandleCharacter;
import com.project.enhance.person.utils.ObjectMapperUtils;

@Service
public class TutorServiceImpl implements TutorService {

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private AreaTutorRepository areaTutorRepository;

	@Override
	public Long saveTutor(TutorDto request) {
		// tutor
		Tutor tutor = new Tutor();
		tutor = ObjectMapperUtils.map(request, Tutor.class);
		Long id = Long.parseLong(generateTutorCode());
		tutor.setId(id);
		tutor.setFullName(request.getFullName().toUpperCase());
		tutor.setEnglishFullName(HandleCharacter.removeAccent(request.getFullName()).toUpperCase());
		tutor.setCreatedBy(request.getCreatedBy());
		tutor.setCreatedAt(DateConverter.convertDateToLocalDateTime(new java.util.Date()));
		tutor = tutorRepository.save(tutor);
		// Area Tutor
		List<String> areaTutorIds = request.getAreaTutorIds();
		if (!areaTutorIds.isEmpty()) {
			saveAllAreaTutor(areaTutorIds, tutor);
		}
		return tutor.getId();
	}

	private void saveAllAreaTutor(List<String> areaTutorIds, Tutor tutor) {
		List<AreaTutor> areaTutors = new LinkedList<>();
		for (String areaId : areaTutorIds) {
			AreaTutor areaTutor = new AreaTutor();
			areaTutor.setTutor(tutor);
			areaTutor.setAreaId(areaId);
			areaTutors.add(areaTutor);
		}
		areaTutorRepository.saveAll(areaTutors);
	}

	private String generateTutorCode() {
		String ResponseTutorCode = null;
		Tutor personHasTutorCode = tutorRepository.getLastTutor();
		if (personHasTutorCode != null) {
			if (personHasTutorCode != null) {
				String tutorCodeWithIdMaxorPreviousId = String.valueOf(personHasTutorCode.getId());
				int count = GenerateTutorId.generateResponsiveReserve(tutorCodeWithIdMaxorPreviousId.substring(6, 8));
				if (tutorCodeWithIdMaxorPreviousId == null
						|| GenerateTutorId.AutoGennerate(tutorCodeWithIdMaxorPreviousId) == -1
						|| GenerateTutorId.AutoGennerate(tutorCodeWithIdMaxorPreviousId) == 2) {
					count = 1;
				} else if (GenerateTutorId.AutoGennerate(tutorCodeWithIdMaxorPreviousId) == 3) {
					count += 1;
				}
				ResponseTutorCode = GenerateTutorId.generateResponsive((int) count);
			}
		} else {
			ResponseTutorCode = GenerateTutorId.generateResponsive((int) 1);
		}
		return GenerateTutorId.generatorCode().concat(ResponseTutorCode);
	}

	@Override
	public List<TutorDto> findAllTutor() {
		List<TutorDto> tutorDtos = new LinkedList<>();
		tutorRepository.findAllTutor().stream().forEach(item -> {
			Object[] objectList = (Object[]) item;
			TutorDto dto = new TutorDto();
			dto = convertObjectToTutorDto(objectList, dto);
			tutorDtos.add(dto);
		});

		return tutorDtos;
	}

	private TutorDto convertObjectToTutorDto(Object[] objectList, TutorDto dto) {
		String convertToStringId = (String) objectList[0].toString();
		Long id = Long.parseLong(convertToStringId);
		dto.setId(id);
		dto.setBirthYear((String) objectList[2]);
		dto.setEmails((String) objectList[3]);
		dto.setEnglishFullName((String) objectList[4]);
		dto.setFbs((String) objectList[5]);
		dto.setFullName((String) objectList[6]);
		dto.setGender((String) objectList[7]);
		dto.setIdCardIssuedOn((String) objectList[8]);
		dto.setIdCardNumber((String) objectList[9]);
		dto.setPhones((String) objectList[10]);
		dto.setRegisteredStatus((String) objectList[11]);
		dto.setZaloes((String) objectList[12]);
		dto.setPlaceOfBirth((String) objectList[13]);
		dto.setTutorAddress((String) objectList[14]);
		dto.setXRelCoo((String) objectList[15]);
		dto.setYRelCoo((String) objectList[16]);
		dto.setTutorAddressAreaId((String) objectList[17]);
		dto.setCreatedAt(DateConverter.convertDateToLocalDateTime((Timestamp) objectList[18]));

		dto.setAvatar(!StringUtils.isEmpty((String) objectList[21]) ? (String) objectList[21] : "");

		dto.setCreatedBy(!StringUtils.isEmpty((String) objectList[22]) ? (String) objectList[22] : "");

		String privateImgs = !StringUtils.isEmpty((String) objectList[25]) ? (String) objectList[25] : "";
		dto.setPrivateImgs(new LinkedList<>(new HashSet<>(Arrays.asList(privateImgs.split(", ")))));

		String publicImgs = !StringUtils.isEmpty((String) objectList[26]) ? (String) objectList[26] : "";
		dto.setPublicImgs(new LinkedList<>(new HashSet<>(Arrays.asList(publicImgs.split(", ")))));

		dto.setAverageStarNumbers((Double) objectList[30] == null ? 0.0 : (Double) objectList[30]);
		dto.setExp((Double) objectList[31] == null ? 0.0 : (Double) objectList[31]);
		dto.setSuccessJobsNumbers((Integer) objectList[32] == null ? 0 : (Integer) objectList[32]);

		return dto;
	}

}
