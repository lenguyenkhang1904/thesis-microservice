package com.project.enhance.person.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String createdBy;

	private String registeredStatus;

	private String fullName;

	private String englishFullName;

	private String gender;

	private String birthYear;

	private String phones;

	private String emails;

	private String zaloes;

	private String fbs;

	private String idCardNumber;

	private String idCardIssuedOn;

	private String avatar;

	private List<String> publicImgs = new LinkedList<>();

	private List<String> privateImgs = new LinkedList<>();

	private Long id;

	private String tutorAddress;

	private String tutorAddressAreaId;

	private String xRelCoo;

	private String yRelCoo;

	private String placeOfBirth;

	private List<String> areaTutorIds = new LinkedList<>();

	private String expNotices;

	private Double averageStarNumbers;

	private String hienDangLa;

	private String nowLevel;

	private String studyingInsitution;

	private String teachingInstitution;

	private String major;

	private String voices;

	private String tutorTag;

	private String tutorNotices;

	private String advantageNote;

	private String subject;

	private String subjectClass;
	
	private Double exp;
	
	private Integer successJobsNumbers;
	
	private LocalDateTime createdAt;
}
