package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entities.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan,Integer> {
	
	CitizenPlan getByCitizenId(Integer citizenId);
	@Query(value="select distinct (planName) from CitizenPlan c")
	List<String> getCitizenPlan();
	@Query(value="select distinct (planStatus) from CitizenPlan c")
	List<String> getCitizenStatus();
	

}

//@Query("SELECT t FROM Tutorial t WHERE t.level >= ?1")
//List<Tutorial> findByLevelGreaterThanEqual(int level);
//
//@Query("SELECT t FROM Tutorial t WHERE t.createdAt >= ?1")
//List<Tutorial> findByDateGreaterThanEqual(Date date);
//@Query("SELECT t FROM Tutorial t WHERE t.level BETWEEN ?1 AND ?2")
//List<Tutorial> findByLevelBetween(int start, int end);
//
//@Query("SELECT t FROM Tutorial t WHERE t.createdAt BETWEEN ?1 AND ?2")
//List<Tutorial> findByDateBetween(Date start, Date end);
//@Query("SELECT t FROM Tutorial t WHERE t.published=:isPublished AND t.level BETWEEN :start AND :end")
//List<Tutorial> findByLevelBetween(@Param("start") int start, @Param("end") int end, @Param("isPublished") boolean isPublished);
