package com.bcaf.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.sql.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bcaf.project.model.CustomerData;
import com.bcaf.project.model.ViewCustomerData;
import com.bcaf.project.repository.CustomerDataRepo;
import com.bcaf.project.repository.ViewCustomerDataRepo;

@Controller
@RequestMapping(value = "/customerData/")
public class CustomerDataController {

	@Autowired
	private CustomerDataRepo repo;
	
	@Autowired
	private ViewCustomerDataRepo vRepo;

//	@Autowired
//	private DataDistributionRepo datRepo;

	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("customerData/index");
		List<ViewCustomerData> list = this.vRepo.findAll();
		view.addObject("list", list);
		return view;
	}

//	@GetMapping(value = "split")
//	public ModelAndView split() {
//		ModelAndView view = new ModelAndView("customerData/split");
//		List<CustomerData> splitlist = this.repo.find_by_cabang_ds_id();
//		view.addObject("splitlist", splitlist);
//		return view;
//	}
//	public static final String SAMPLE_XLS_FILE_PATH = "./*.xls";
//	public static final String SAMPLE_XLSX_FILE_PATH = "./*.xlsx";

	// save the uploaded file to folder
	public static String UPLOADED_FOLDER = "./temp/";

	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("customerData/_form");
		return view;
	}

	@GetMapping(value = "uploadKategori")
	public ModelAndView uploadKategori() {
		ModelAndView view = new ModelAndView("customerData/uploadKategori");
		return view;
	}

	@PostMapping(value = "upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		if (file.isEmpty()) {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:uploadstatus";
	}

	@GetMapping("uploadstatus")
	public ModelAndView uploadStatus() {
		ModelAndView view = new ModelAndView("customerData/uploadStatus");
		return view;
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("customerData/_form");
		ViewCustomerData item = this.vRepo.findById(id).orElse(null);
		view.addObject("objCustData", item);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute CustomerData objCustData, BindingResult result) {
		ModelAndView view = new ModelAndView("customerData/_form");
		if(result.hasErrors()) {
			view.addObject("objCustData", objCustData);
		}
		else {
			this.repo.save(objCustData);
			view.addObject("objCustData", new CustomerData());
		}
		
		return view;
		
	}

	@GetMapping(value = "list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("customerData/_list");
		List<CustomerData> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}

	public void importxls(String Filename) throws IOException, InvalidFormatException {
		try {
			String url = "jdbc:sqlserver://localhost;databaseName=project_db";
			Connection conn = DriverManager.getConnection(url, "sa", "M4rf3l");
			Statement st = conn.createStatement();

			XSSFWorkbook workbook = new XSSFWorkbook(Filename);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
				}
				String no_rek = row.getCell(0).getStringCellValue();
				String no_pin = row.getCell(1).getStringCellValue();
				String customer_id = row.getCell(2).getStringCellValue();
				String customer_name = row.getCell(3).getStringCellValue();
				String gender = row.getCell(4).getStringCellValue();
				String id_card_number = row.getCell(5).getStringCellValue();
				String birth_date = row.getCell(6).getStringCellValue();
				String home_phone_number = row.getCell(7).getStringCellValue();
				String hp_number = row.getCell(8).getStringCellValue();
				String email_konsumen = row.getCell(9).getStringCellValue();
				String company_name = row.getCell(10).getStringCellValue();
				String job_title = row.getCell(11).getStringCellValue();
				String spouse_name = row.getCell(12).getStringCellValue();
				String home_kabupaten = row.getCell(13).getStringCellValue();
				String branch_name = row.getCell(14).getStringCellValue();
				String sub_produk = row.getCell(15).getStringCellValue();
				String merk_name = row.getCell(16).getStringCellValue();
				String tipe = row.getCell(17).getStringCellValue();
				String tahun = row.getCell(18).getStringCellValue();
				String harga_barang = row.getCell(19).getStringCellValue();
				String tenor = row.getCell(20).getStringCellValue();
				String bpkb_no = row.getCell(21).getStringCellValue();
				String body_no = row.getCell(22).getStringCellValue();
				String realisasi_date = row.getCell(23).getStringCellValue();
				String close_date = row.getCell(24).getStringCellValue();
				String end_date = row.getCell(25).getStringCellValue();
				String period_berjalan = row.getCell(26).getStringCellValue();
				String angsuran_konsumen = row.getCell(27).getStringCellValue();
				String os_pokok_konsumen = row.getCell(28).getStringCellValue();
				String status_close_type = row.getCell(29).getStringCellValue();
				String od_days_max = row.getCell(30).getStringCellValue();
				String ovd_by_cust_id = row.getCell(31).getStringCellValue();
				String od_loan = row.getCell(32).getStringCellValue();
				String bpkb_status = row.getCell(33).getStringCellValue();
				String bca_branch_status = row.getCell(34).getStringCellValue();
				String bca_branch_name = row.getCell(35).getStringCellValue();
				String bca_kcu_name = row.getCell(36).getStringCellValue();
//				String bca_kcu_name_baru = row.getCell(36).getStringCellValue();
				String sales_agent = row.getCell(37).getStringCellValue();
				String sales_agent_name = row.getCell(38).getStringCellValue();
				String sisa_periode = row.getCell(39).getStringCellValue();
				String cabang_ds = row.getCell(40).getStringCellValue();
				String source = row.getCell(41).getStringCellValue();
				String product = row.getCell(42).getStringCellValue();
				InsertRowInDB(no_rek, no_pin, customer_id, customer_name, gender, id_card_number, birth_date,
						home_phone_number, hp_number, email_konsumen, company_name, job_title, spouse_name,
						home_kabupaten, branch_name, sub_produk, merk_name, tipe, tahun, harga_barang, tenor, bpkb_no,
						body_no, realisasi_date, close_date, end_date, period_berjalan, angsuran_konsumen,
						os_pokok_konsumen, status_close_type, od_days_max, ovd_by_cust_id, od_loan, bpkb_status,
						bca_branch_status, bca_branch_name, bca_kcu_name, sales_agent,
						sales_agent_name, sisa_periode, cabang_ds, source, product);
//	            System.out.println("");
			}
			workbook.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public void InsertRowInDB(String no_rek, String no_pin, String customer_id, String customer_name, String gender, String id_card_number, String birth_date,
			String home_phone_number, String hp_number, String email_konsumen, String company_name, String job_title, String spouse_name,
			String home_kabupaten, String branch_name, String sub_produk, String merk_name, String tipe, String tahun, String harga_barang, String tenor, String bpkb_no,
			String body_no, String realisasi_date, String close_date, String end_date, String period_berjalan, String angsuran_konsumen,
			String os_pokok_konsumen, String status_close_type, String od_days_max, String ovd_by_cust_id, String od_loan, String bpkb_status,
			String bca_branch_status, String bca_branch_name, String bca_kcu_name, String sales_agent,
			String sales_agent_name, String sisa_periode, String cabang_ds, String source, String product) throws SQLException {
		String url = "jdbc:sqlserver://localhost;databaseName=project_db";
		Connection conn = DriverManager.getConnection(url, "sa", "Marf3l");
		Statement stmt = conn.createStatement();
		PreparedStatement ps = null;
		String sql = "Insert into tbl_customer_data(no_rek,no_pin,customer_id,customer_name,gender,id_card_number,birth_date,home_phone_number"
				+ ",hp_number,email_konsumen,company_name,job_title,spouse_name,home_kabupaten,branch_name,sub_produk,merk_name"
				+ ",tipe,tahun,harga_barang,tenor,bpkb_no,body_no,realisasi_date,close_date,end_date,period_berjalan,angsuran_konsumen"
				+ ",os_pokok_konsumen,status_close_type,od_days_max,ovd_by_cust_id,od_loan,bpkb_status,bca_branch_status,bca_branch_name"
				+ ",bca_kcu_name,sales_agent,sales_agent_name,sisa_periode,cabang_ds,source,product)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, no_rek);
		ps.setString(2, no_pin);
		ps.setString(3, customer_id);
		ps.setString(4, customer_name);
		ps.setString(5, gender);
		ps.setString(6, id_card_number);
		ps.setString(7, birth_date);
		ps.setString(8, home_phone_number);
		ps.setString(9, hp_number);
		ps.setString(10, email_konsumen);
		ps.setString(11, company_name);
		ps.setString(12, job_title);
		ps.setString(13, spouse_name);
		ps.setString(14, home_kabupaten);
		ps.setString(15, branch_name);
		ps.setString(16, sub_produk);
		ps.setString(17, merk_name);
		ps.setString(18, tipe);
		ps.setString(19, tahun);
		ps.setString(20, harga_barang);
		ps.setString(21, tenor);
		ps.setString(22, bpkb_no);
		ps.setString(23, body_no);
		ps.setString(24, realisasi_date);
		ps.setString(25, close_date);
		ps.setString(26, end_date);
		ps.setString(27, period_berjalan);
		ps.setString(28, angsuran_konsumen);
		ps.setString(29, os_pokok_konsumen);
		ps.setString(30, status_close_type);
		ps.setString(31, od_days_max);
		ps.setString(32, ovd_by_cust_id);
		ps.setString(33, od_loan);
		ps.setString(34, bpkb_status);
		ps.setString(35, bca_branch_status);
		ps.setString(36, bca_branch_name);
		ps.setString(37, bca_kcu_name);
//		ps.setString(37, bca_kcu_name_baru);
		ps.setString(38, sales_agent);
		ps.setString(39, sales_agent_name);
		ps.setString(40, sisa_periode);
		ps.setString(41, cabang_ds);
		ps.setString(42, source);
		ps.setString(43, product);
		ps.executeUpdate();
//    System.out.println("Values Inserted Successfully");
	}

}
