package com.project.enhance.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.enhance.person.domain.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
	@Query("SELECT t FROM Tutor t WHERE  t.createdAt=(SELECT MAX(tu.createdAt) FROM Tutor tu)") // AND length(p.id)=8
	Tutor getLastTutor();

	@Query(value = "SELECT t.id, t.birth_date, t.birth_year, t.emails, t.english_full_name, t.fbs, "
			+ " t.full_name, t.gender, t.id_card_issued_on, t.id_card_number, t.phones, t.registered_status, t.zaloes, t.place_of_birth, t.tutor_address, "
			+ " t.x_rel_coo, t.y_rel_coo, t.tutor_address_area_id, t.created_at, t.update_at, t.exp_notices, t.avatar, t.created_by, t.updated_by "
			+ ", STRING_AGG(art.area_id, ', ') AS rel_area " + ", STRING_AGG(tpr.private_imgs, ', ') AS private_imgs "
			+ ", STRING_AGG(tp.public_imgs, ', ') AS public_imgs "
			+ ", t.average_start_numbers, t.exp, t.success_jobs_numbers, " + "FROM tutor t "
			+ "LEFT JOIN area_tutor art ON t.id = art.tutor_id "
			+ "LEFT JOIN tutor_private_imgs tpr ON tpr.tutor_id = t.id "
			+ "LEFT JOIN tutor_public_imgs tp ON tp.tutor_id = t.id "
			+ "GROUP BY t.id ORDER BY t.id; ", nativeQuery = true)
	List<Object> findAllTutor();
}
