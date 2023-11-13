package com.project.enhance.location.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "area")
public class Area {
	@Id
	private String id;

	@Column(name = "nation")
	private String nation;

	@Column(name = "state")
	private String state;

	@Column(name = "provincial_level")
	private String provincialLevel;

	@Column(name = "district")
	private String district;

	@Column(name = "commune")
	private String commune;

	@Column(name = "x_rel_coo")
	private String xRelCoo;

	@Column(name = "y_rel_coo")
	private String yRelCoo;
}
