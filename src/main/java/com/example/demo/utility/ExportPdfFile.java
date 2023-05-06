package com.example.demo.utility;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.example.demo.Entities.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class ExportPdfFile {
	
	public boolean generatePdf(List<CitizenPlan> data,HttpServletResponse response) throws DocumentException, IOException
	{
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Paragraph p=new Paragraph("Plans Data");
		document.add(p);
		PdfPTable table=new PdfPTable(8);
		table.addCell("Id");
		table.addCell("Holder Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("BenefitAmt");
		table.addCell("Denial Reason");

		for(CitizenPlan citizen:data)
		{
			table.addCell(citizen.getCitizenId()+"");
			table.addCell(citizen.getCitizenName());
			table.addCell(citizen.getPlanName());
			table.addCell(citizen.getPlanStatus());
			table.addCell(citizen.getPlanStartDate()+"");
			table.addCell(citizen.getPlanEndDate()+"");
			if(!(citizen.getBenefitAmt()==null)) {
			table.addCell(citizen.getBenefitAmt()+"");
			}
			else
			{
				table.addCell("N/A");
			}
			table.addCell(citizen.getDenialReason());
		}
		document.add(table);
		document.close();
		return true;
	}

}
