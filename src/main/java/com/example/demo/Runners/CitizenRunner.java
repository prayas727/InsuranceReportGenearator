package com.example.demo.Runners;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.CitizenServices.CitizenServiceImpl;
import com.example.demo.Entities.CitizenPlan;
import com.example.demo.Repo.CitizenPlanRepository;
import com.example.demo.utility.EmailSenderService;

@Component
public class CitizenRunner implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository cp;
	@Autowired
	private EmailSenderService ss;
	@Autowired
	private CitizenServiceImpl sc;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		CitizenPlan cp1=new CitizenPlan();
		cp1.setCitizenName("Prayas");
		cp1.setGender("Male");
		cp1.setPlanName("Cash");
		cp1.setPlanStatus("Approved");
		cp1.setPlanStartDate(LocalDate.now());
		cp1.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp1.setBenefitAmt(120000.00);
//		============
		CitizenPlan cp2=new CitizenPlan();
		cp2.setCitizenName("Keshav");
		cp2.setGender("Male");
		cp2.setPlanName("Food");
		cp2.setPlanStatus("Denied");
		cp2.setPlanStartDate(LocalDate.now());
		cp2.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp2.setDenialReason("Rental Income");
		///////////////////
		CitizenPlan cp3=new CitizenPlan();
		cp3.setCitizenName("Cathy");
		cp3.setGender("Female");
		cp3.setPlanName("Cash");
		cp3.setPlanStatus("Terminated");
//		cp3.setPlanStartDate(LocalDate.now().minusMonths(4));
//		cp3.setPlanEndDate(LocalDate.now().plusMonths(6));
//		cp3.setBenefitAmt(50000.00);
		cp3.setTerminationDate(LocalDate.now());
//		cp3.setTerminationRsn("Employed");
//		===============
		CitizenPlan cp4=new CitizenPlan();
		cp4.setCitizenName("Ravan");
		cp4.setGender("Male");
		cp4.setPlanName("Cash");
		cp4.setPlanStatus("Denied");
		cp4.setPlanStartDate(LocalDate.now());
		cp4.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp4.setDenialReason("High Income");
//		===============
		CitizenPlan cp5=new CitizenPlan();
		cp5.setCitizenName("Nancy");
		cp5.setGender("Female");
		cp5.setPlanName("Food");
		cp5.setPlanStatus("Approved");
		cp5.setBenefitAmt(80000.00);
		cp5.setPlanStartDate(LocalDate.now());
		cp5.setPlanEndDate(LocalDate.now().plusMonths(6));
		
		CitizenPlan cp6=new CitizenPlan();
		cp6.setCitizenName("Peter");
		cp6.setGender("Male");
		cp6.setPlanName("Cash");
		cp6.setPlanStatus("Terminated");
		cp6.setPlanStartDate(LocalDate.now());
		cp6.setPlanEndDate(LocalDate.now().plusMonths(6));
//		cp6.setBenefitAmt(320000.00);
//		============
		CitizenPlan cp7=new CitizenPlan();
		cp7.setCitizenName("Kiron");
		cp7.setGender("Male");
		cp7.setPlanName("Food");
		cp7.setPlanStatus("Terminated");
		cp7.setPlanStartDate(LocalDate.now());
		cp7.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp7.setDenialReason("Rejected");
		///////////////////
		CitizenPlan cp8=new CitizenPlan();
		cp8.setCitizenName("Kelly");
		cp8.setGender("Female");
		cp8.setPlanName("Food");
		cp8.setPlanStatus("Approved");
//		cp8.setPlanStartDate(LocalDate.9now().minusMonths(4));
//		cp8.setPlanEndDate(LocalDate.9now().plusMonths(6));
		cp8.setBenefitAmt(32000.00);
		cp8.setTerminationDate(LocalDate.now());
		cp8.setTerminationRsn("Employed");
//		===============
		CitizenPlan cp9=new CitizenPlan();
		cp9.setCitizenName("John");
		cp9.setGender("Male");
		cp9.setPlanName("Food");
		cp9.setPlanStatus("Denied");
		cp9.setPlanStartDate(LocalDate.now());
		cp9.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp9.setDenialReason("Discontinued");
//		===============
		CitizenPlan cp10=new CitizenPlan();
		cp10.setCitizenName("Aman");
		cp10.setGender("Male");
		cp10.setPlanName("Cash");
		cp10.setPlanStatus("Approved");
		cp10.setBenefitAmt(280000.00);
		cp10.setPlanStartDate(LocalDate.now());
		cp10.setPlanEndDate(LocalDate.now().plusMonths(6));
		List<CitizenPlan> li=Arrays.asList(cp1,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9,cp10);
//		li.forEach(System.out::println);
		cp.saveAll(li);
		System.out.println(cp.findAll());
//		SearchBean sb=new SearchBean();
//		sb.setSplanEndDate("2023-10-09");
//		CitizenPlan cp6=new CitizenPlan();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse(sb.getSplanEndDate(), formatter);
//		System.out.println("+++++++++++++" + date);
//		cp6.setPlanEndDate(date);
//		System.out.println("Outpu"+(cp.findAll(Example.of(cp6))));
	}

}
