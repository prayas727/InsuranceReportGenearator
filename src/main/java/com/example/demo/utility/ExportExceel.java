//package com.example.demo.utility;
//
//import java.util.List;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.Entities.CitizenPlan;
//import com.example.demo.test.TestServiceImpl;
//import com.example.demoSearchBean.SearchBean;
//
//@Component
//public class ExportExceel {
//	@Autowired
//	private TestServiceImpl ts;
//
////	List<CitizenPlan> cp=cpr.
//	public void generateExcelFile(SearchBean searchBean, HttpServletResponse response) throws Exception {
////		Gender	Plan Name	Plan Status	Plan Start Date	Plan End Date	BenefitAmt	Denial Reason		
//		List<CitizenPlan> data = ts.search(searchBean);
//		Workbook workbook = new HSSFWorkbook();
//		Sheet createSheet = workbook.createSheet("Insurance_Plans");
//		Row createRow = createSheet.createRow(0);
//		createRow.createCell(0).setCellValue("Id");
//		createRow.createCell(1).setCellValue("Holder Name");
//		createRow.createCell(2).setCellValue("Gender");
//		createRow.createCell(3).setCellValue("Plan Name");
//		createRow.createCell(4).setCellValue("Plan Status");
//		createRow.createCell(5).setCellValue("Plan Start Date");
//		createRow.createCell(6).setCellValue("Plan End Date");
//		createRow.createCell(7).setCellValue("BenefitAmt");
//		createRow.createCell(8).setCellValue("Denial Reason");
//		int var = 1;
//		for (CitizenPlan record : data) {
//
//			Row createRow1 = createSheet.createRow(var);
//			createRow.createCell(0).setCellValue(record.getCitizenId());
//			createRow.createCell(1).setCellValue(record.getCitizenName());
//			createRow.createCell(2).setCellValue(record.getGender());
//			createRow.createCell(3).setCellValue(record.getPlanName());
//			createRow.createCell(4).setCellValue(record.getPlanStatus());
//			createRow.createCell(5).setCellValue(record.getPlanStartDate());
//			createRow.createCell(6).setCellValue(record.getPlanStartDate());
//			createRow.createCell(7).setCellValue(record.getBenefitAmt());
//			createRow.createCell(8).setCellValue(record.getDenialReason());
//			var++;
//
//		}
////	File output Stream	
////		FileOutputStream fos=new FileOutputStream(new File("plans.xls"));
////		workbook.write(fos);
////		workbook.close();
//
//		ServletOutputStream serveletOutputStream = response.getOutputStream();
//		workbook.write(serveletOutputStream);
//		workbook.close();
//	}
//}
