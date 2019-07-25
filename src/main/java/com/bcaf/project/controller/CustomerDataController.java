package com.bcaf.project.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.sql.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bcaf.project.model.CabangBca;
import com.bcaf.project.model.CabangKkbBca;
import com.bcaf.project.model.CustomerData;
import com.bcaf.project.model.Employee;
import com.bcaf.project.repository.CabangBcaRepo;
import com.bcaf.project.repository.CustomerDataRepo;

@Controller
@RequestMapping(value = "/customerData/")
public class CustomerDataController {
	
	@Autowired
	private CustomerDataRepo repo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("customerData/index");
		List<CustomerData> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}

//	public static final String SAMPLE_XLS_FILE_PATH = "./*.xls";
//	public static final String SAMPLE_XLSX_FILE_PATH = "./*.xlsx";
	
	//save the uploaded file to folder
	public static String UPLOADED_FOLDER = "./temp/";
	
	@GetMapping(value ="create")
    public ModelAndView create() {
		ModelAndView view = new ModelAndView("customerData/_form");
        return view;
    }
	
	@GetMapping(value ="uploadKategori")
    public ModelAndView uploadKategori() {
		ModelAndView view = new ModelAndView("customerData/uploadKategori");
        return view;
    }
	
	@PostMapping(value = "upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
		
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadstatus";
		}
		try {
			  // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
		try {
//			importxls(file.getOriginalFilename());
			importxls(path.toString());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch  (IOException e) {
            e.printStackTrace();
		}
		return "redirect:uploadstatus";
	}
	
    @GetMapping("uploadstatus")
    public ModelAndView uploadStatus() {
        ModelAndView view = new ModelAndView("customerData/uploadStatus");
        return view;
    }
    
    @GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("customerData/_list");
		List<CustomerData> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
    

    public void importxls(String Filename)  throws IOException, InvalidFormatException {
		
		//ini loh script nya
		try {
			String url = "jdbc:sqlserver://localhost;databaseName=project_db";
			Connection conn = DriverManager.getConnection(url, "sa", "M4rf3l");
			Statement st = conn.createStatement();

			Workbook workbook = WorkbookFactory.create(new File(Filename));

			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			Sheet sheet = workbook.getSheetAt(0);

			DataFormatter dataFormatter = new DataFormatter();

			System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

			Iterator<Row> rowIterator = sheet.rowIterator();
			int i = 0;
			int c;

			String str = "INSERT INTO tbl_customer_data (no_rek" + ",no_pin" + ",customer_id"
					+ ",customer_name" + ",gender" + ",id_card_number" + ",birth_date" + ",home_phone_number"
					+ ",hp_number" + ",email_konsumen" + ",company_name" + ",job_title" + ",spouse_name"
					+ ",home_kabupaten" + ",branch_name" + ",sub_produk" + ",merk_name" + ",tipe" + ",tahun"
					+ ",harga_barang" + ",tenor" + ",bpkb_no" + ",body_no" + ",realisasi_date" + ",close_date"
					+ ",end_date" + ",period_berjalan" + ",angsuran_konsumen" + ",os_pokok_konsumen"
					+ ",status_close_type" + ",od_days_max" + ",ovd_by_cust_id" + ",od_loan" + ",bpkb_status"
					+ ",bca_branch_status" + ",bca_branch_name" + ",bca_kcu_name" + ",bca_kcu_name_baru"
					+ ",sales_agent" + ",sales_agent_name" + ",sisa_periode" + ",cabang_ds" + ",source" + ",product) VALUES ";
			String strx = "";
			String all = "";
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (i > 0) {
					Iterator<Cell> cellIterator = row.cellIterator();
					strx = "";
					c = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						String strval="";
		                strval=cellValue.replace("'", "");
		                strval=strval.replace("#", "");
		                strx+="'"+strval+"',";
		                
			            strx=strx.substring(0,strx.length()-1)+",";
			            c++;
					}
					strx = "(" + strx.substring(0, strx.length() - 1) + "),";
				}
				all += strx;
				i++;
			}
			str += all.substring(0, all.length() - 1) + ";";
			st.executeUpdate(str);
			System.out.println(str);

			workbook.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
