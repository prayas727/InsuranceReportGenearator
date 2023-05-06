package com.example.demo.test;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.Entities.CitizenPlan;
import com.example.demoSearchBean.SearchBean;

public interface TestService {
	
	List<CitizenPlan> search(SearchBean searchBean);
	boolean generatepdfFile(SearchBean searchBean,HttpServletResponse response) throws Exception;
	boolean generateExcelFile(SearchBean searchBean,HttpServletResponse response) throws Exception;
	
	

}
