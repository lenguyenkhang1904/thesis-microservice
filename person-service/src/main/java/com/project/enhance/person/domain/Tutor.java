package com.project.enhance.person.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tutor")
public class Tutor {
	
	@Id
	private Long id;
	
	@Column(name = "registered_status")
	private String registeredStatus;

	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "english_fullName")
	private String englishFullName;

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "birth_year")
	private String birthYear;
	
	@Column(name = "phones")
	private String phones;
	
	@Column(name = "emails")
	private String emails;
	
	@Column(name = "zaloes")
	private String zaloes;
	
	@Column(name = "fbs")
	private String fbs;
	
	@Column(name = "id_card_number")
	private String idCardNumber;
	
	@Column(name = "id_card_issued_on")
	private String idCardIssuedOn;

	@Column(name = "tutor_address")
	private String tutorAddress;

	@Column(name = "tutor_address_area_id")
	private String tutorAddressAreaId;

	@Column(name = "place_of_birth")
	private String placeOfBirth;

	@Column(name = "x_Rel_Coo")
	private String xRelCoo;

	@Column(name = "y_Rel_Coo")
	private String yRelCoo;

	@OneToMany(mappedBy = "tutor")
	private List<AreaTutor> areaTutor;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "public_imgs")
	@ElementCollection
	private List<String> publicImgs;

	@Column(name = "private_imgs")
	@ElementCollection
	private List<String> privateImgs;

	@Column(name = "exp_notices")
	private String expNotices;

	@Column(name = "average_start_numbers")
	private Double averageStarNumbers;

	@Column(name = "hien_dang_la")
	private String hienDangLa;

	@Column(name = "now_level")
	private String nowLevel;

	@Column(name = "studying_insitution")
	private String studyingInsitution;

	@Column(name = "teaching_institution")
	private String teachingInstitution;

	@Column(name = "major")
	private String major;

	@Column(name = "voices")
	private String voices;

	@Column(name = "tutor_tag")
	private String tutorTag;

	@Column(name = "tutor_notices")
	private String tutorNotices;

	@Column(name = "advantage_note")
	private String advantageNote;
	
	@Column(name = "exp")
	private Double exp;

	@Column(name = "subject")
	private String subject;
	
	@Column(name = "subject_class")
	private String subjectClass;
	
	private Integer successJobsNumbers;
	
	private String createdBy;
	
	private LocalDateTime createdAt;
}
