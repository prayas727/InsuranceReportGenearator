package com.example.demo.CitizenServices;

import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.CitizenPlan;
import com.example.demo.Repo.CitizenPlanRepository;
import com.example.demoSearchBean.SearchBean;

@Service
public class CitizenServiceImpl implements CitizenSevice{
	
@Autowired
private CitizenPlanRepository cpr;
	@Override
	public List<String> getCitizenPlan() {
		// TODO Auto-generated method stub
		return cpr.getCitizenPlan();
	}

	@Override
	public List<String> getCitizenStatus() {
		// TODO Auto-generated method stub
		return cpr.getCitizenStatus();
	}

	@Override
	public List<CitizenPlan> getCitizenBySearch(SearchBean searchBean) {
		CitizenPlan entity=new CitizenPlan();
	   if(searchBean.getSplanName()!=null&&!"".equals(searchBean.getSplanName()))
	   {
		 entity.setCitizenName(searchBean.getSplanName());  
	   }
//	   if(searchBean.getSplanStatus()!=null&&!"".equals(searchBean.getSplanStatus()))
//	   {
//		 entity.setPlanStatus(searchBean.getSplanStatus());
//	   }
//	   if(searchBean.getSplanStartDate()!=null&&!"".equals(searchBean.getSplanStartDate()))
//	   {
//		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		   LocalDate date = LocalDate.parse(searchBean.getSplanStartDate(), formatter);
//		 entity.setPlanStartDate(date);  
//	   }
//	   if(searchBean.getSplanEndDate()!=null&&!"".equals(searchBean.getSplanEndDate()))
//	   {
//		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		   LocalDate date = LocalDate.parse(searchBean.getSplanEndDate(), formatter);
//		 entity.setPlanEndDate(date);  
//	   }
//
//
//        System.out.println("This entity data"+entity);
		return cpr.findAll(Example.of(entity));
	}
	

}
