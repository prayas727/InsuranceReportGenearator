package com.example.demo.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.CitizenPlan;
import com.example.demo.Repo.CitizenPlanRepository;
import com.example.demo.utility.ExportPdfFile;
import com.example.demoSearchBean.SearchBean;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private CitizenPlanRepository cr;

	@Autowired
	private ExportPdfFile epf;

	@Override
	public List<CitizenPlan> search(SearchBean searchBean) {
		CitizenPlan cp = new CitizenPlan();
		if (searchBean.getSplanName() != null && !"".equals(searchBean.getSplanName())) {
			cp.setPlanName(searchBean.getSplanName());
		}

		if (searchBean.getSplanStatus() != null && !"".equals(searchBean.getSplanStatus())) {
			cp.setPlanStatus(searchBean.getSplanStatus());
		}
		if (searchBean.getSplanStartDate() != null && !"".equals(searchBean.getSplanStartDate())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(searchBean.getSplanStartDate(), formatter);
			System.out.println("+++++++++++++" + date);
			cp.setPlanStartDate(date);
		}
		if (searchBean.getSplanEndDate() != null && !"".equals(searchBean.getSplanEndDate())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(searchBean.getSplanEndDate(), formatter);
			System.out.println("+++++++++++++" + date);
			cp.setPlanEndDate(date);
		}
		System.out.println("+++++++++++++" + cp);
		System.out.println("repo" + cr.findAll(Example.of(cp)));
		return cr.findAll(Example.of(cp));
	}

	@Override
	public boolean generateExcelFile(SearchBean searchBean, HttpServletResponse response) throws Exception {

		List<CitizenPlan> data = this.search(searchBean);
		Workbook workbook = new HSSFWorkbook();
		Sheet createSheet = workbook.createSheet("Insurance_Plans");
		Row createRow = createSheet.createRow(0);
		createRow.createCell(0).setCellValue("Id");
		createRow.createCell(1).setCellValue("Holder Name");
		createRow.createCell(2).setCellValue("Gender");
		createRow.createCell(3).setCellValue("Plan Name");
		createRow.createCell(4).setCellValue("Plan Status");
		createRow.createCell(5).setCellValue("Plan Start Date");
		createRow.createCell(6).setCellValue("Plan End Date");
		createRow.createCell(7).setCellValue("BenefitAmt");
		createRow.createCell(8).setCellValue("Denial Reason");
		int var = 1;
		for (CitizenPlan record : data) {

			Row createRow1 = createSheet.createRow(var);
			System.out.println(var);
			createRow1.createCell(0).setCellValue(record.getCitizenId());
			createRow1.createCell(1).setCellValue(record.getCitizenName());
			createRow1.createCell(2).setCellValue(record.getGender());
			createRow1.createCell(3).setCellValue(record.getPlanName());
			createRow1.createCell(4).setCellValue(record.getPlanStatus());
			createRow1.createCell(5).setCellValue(record.getPlanStartDate() + "");
			createRow1.createCell(6).setCellValue(record.getPlanStartDate() + "");
			if (!(record.getBenefitAmt() == null)) {
				createRow1.createCell(7).setCellValue(record.getBenefitAmt());
			} else {
				createRow1.createCell(7).setCellValue("N/A");
			}

			createRow1.createCell(8).setCellValue(record.getDenialReason());
			var++;

		}
//	File output Stream	
//		FileOutputStream fos=new FileOutputStream(new File("plans.xls"));
//		workbook.write(fos);
//		workbook.close();
///
		ServletOutputStream serveletOutputStream = response.getOutputStream();
		workbook.write(serveletOutputStream);
		workbook.close();
		serveletOutputStream.close();
		serveletOutputStream.flush();
		return true;

	}

	@Override
	public boolean generatepdfFile(SearchBean searchBean, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

///	@Override
//	public boolean generatepdfFile(SearchBean searchBean, HttpServleatResponse response) throws Exception {
//		// TODO Auto-generated method stub
//
//		return epf.generatePdf(this.search(searchBean), response);
//	}
}
