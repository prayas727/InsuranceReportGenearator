package com.example.demo.CitizenServices;

import java.util.List;

import com.example.demo.Entities.CitizenPlan;
import com.example.demoSearchBean.SearchBean;

public interface CitizenSevice {

	List<String> getCitizenPlan();
	List<String> getCitizenStatus();
	List<CitizenPlan> getCitizenBySearch(SearchBean searchBean);
}
