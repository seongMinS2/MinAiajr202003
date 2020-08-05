package com.aia.mvc.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aia.mvc.file.model.Report;

@Controller
public class ReportController {
	
	@RequestMapping("/report/reportForm")
	public String getReportForm() {
		return "report/reportForm";
	}
	
	//리퀘스트 파람을 이용한 파라미터 수집
	@RequestMapping(value = "/report/upload1", method= RequestMethod.POST)
	public String upload1(
			@RequestParam("sno") String sno,
			@RequestParam("report") MultipartFile report,
			Model model
			) {
		String fileName = report.getOriginalFilename();
		long fileSize = report.getSize();
		
		
		model.addAttribute("sno", sno);
		model.addAttribute("report", fileName+"("+fileSize+")");
		
		return "report/report";
	}
	
	//MultipartHttpServletRequest를 이용한 데이터 수집
	@RequestMapping(value = "/report/upload2", method= RequestMethod.POST)
	public String upload2(
			MultipartHttpServletRequest request,
			Model model
			) {
		
		String sno = request.getParameter("sno");
		MultipartFile report = request.getFile("report");
		
		String fileName = report.getOriginalFilename();
		long fileSize = report.getSize();
		
		
		model.addAttribute("sno", sno);
		model.addAttribute("report", fileName+"("+fileSize+")");
		
		return "report/report";
	}
	
	//커맨드 객체 Report를 이용한 자동 주입 방식
	@RequestMapping(value = "/report/upload3", method= RequestMethod.POST)
	public String upload2(Report report,Model model
			) {
		
		String sno = report.getSno();
		MultipartFile file = report.getReport();
		
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		
		
		model.addAttribute("sno", sno);
		model.addAttribute("report", fileName+"("+fileSize+")");
		
		return "report/report";
	}

}
