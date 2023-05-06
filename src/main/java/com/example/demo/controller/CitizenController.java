package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.test.TestServiceImpl;
import com.example.demoSearchBean.SearchBean;

@Controller
public class CitizenController {
	@Autowired
	private TestServiceImpl ts;

	@GetMapping("/")
	public String getTestPage(Model model) {
		model.addAttribute("searchBean", new SearchBean());
		return "Test";
	}

	@PostMapping("/save")
	public String getTestPage(@ModelAttribute SearchBean sb, Model model, @RequestParam(required = false) String export,
			HttpServletResponse response) {

		if ((export == null)) {
			model.addAttribute("plans", ts.search(sb));
		} else if (export.equals("Export Excel file")) {
			try {
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition", "filename=plans.xls;attachment");
				
				if (ts.generateExcelFile(sb, response)) {
					System.out.println("File has been generated");
                      return "File generated";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (export.equals("Export Pdf file")) {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "filename=plans.pdf;attachment");
			
			try {
				if (ts.generatepdfFile(sb, response)) {
					System.out.println("File has been generated");
				      return "File generated";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}

		return "Test";
	}

}
