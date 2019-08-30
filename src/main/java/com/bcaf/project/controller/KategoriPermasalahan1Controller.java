//package com.bcaf.project.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.bcaf.project.model.KategoriPermasalahan;
//import com.bcaf.project.repository.KategoriPermasalahanRepo;
//
//@Controller
//@RequestMapping(value = "/kategori/")
//public class KategoriPermasalahan1Controller {
//	@Autowired
//	private KategoriPermasalahanRepo repo;
//
//	@GetMapping(value = "index")
//	public ModelAndView index() {
//		ModelAndView view = new ModelAndView("kategori/index");
//
//		List<KategoriPermasalahan> kategori = this.repo.findAll();
//
//		view.addObject("kategori", kategori);
//		return view;
//	}
//
//	public static String UPLOADED_FOLDER = "./temp/";
//
//	@GetMapping("uploadkategori")
//	public ModelAndView uploadkategori() {
//		ModelAndView view = new ModelAndView("kategori/uploadKategori");
//		return view;
//	}
//
//	@SuppressWarnings("deprecation")
//	@PostMapping(value = "upload")
//	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
//
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		if (file.isEmpty()) {
//			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//			return "redirect:uploadstatus";
//		}
//		try {
//			// Get the file and save it somewhere
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//			Files.write(path, bytes);
//
//			redirectAttributes.addFlashAttribute("message",
//					"You successfully uploaded '" + file.getOriginalFilename() + "'");
//			try {
//
//		        FileInputStream file1 = new FileInputStream(new File("E://Imp/Details.xlsx"));
//		        XSSFWorkbook workbook = new XSSFWorkbook(file1);
//		        XSSFSheet sheet = workbook.getSheetAt(0);
//		        Iterator<Row> rowIterator = sheet.iterator();
//		        rowIterator.next();
//		        while(rowIterator.hasNext())
//		        {
//		            Row row = rowIterator.next();
//		            //For each row, iterate through each columns
//		            Iterator<Cell> cellIterator = row.cellIterator();
//
//		            while(cellIterator.hasNext())
//		            {
//		                Cell cell = cellIterator.next();
//		                //This will change all Cell Types to String
//		                cell.setCellType(Cell.CELL_TYPE_STRING);
//		                switch(cell.getCellType()) 
//		                {
//		                    case Cell.CELL_TYPE_BOOLEAN:
//		                        System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
//		                        break;
//		                    case Cell.CELL_TYPE_NUMERIC:
//
//		                        break;
//		                    case Cell.CELL_TYPE_STRING:
//
//		                       list.add(cell.getStringCellValue());
//
//		                                                 break;
//		                }
//
//
//		            }
//		            name=row.getCell(0).getStringCellValue();
//		            empid=row.getCell(1).getStringCellValue();
//		            add=row.getCell(2).getStringCellValue();
//		            mobile=row.getCell(3).getStringCellValue();
//		            System.out.println(name+empid+add+mobile);
//		            ex.InsertRowInDB(name,empid,add,mobile);
//		            System.out.println("");
//
//
//		        }
//		        file.close();
//		    } catch (FileNotFoundException e) {
//		        e.printStackTrace();
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		    }
//		  }
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "redirect:uploadstatus";
//	}
//
//	@GetMapping("uploadstatus")
//	public ModelAndView uploadStatus() {
//		ModelAndView view = new ModelAndView("kategori/uploadStatus");
//		return view;
//	}
//	
//	public void InsertRowInDB(String name,String empid,String add,String mobile) throws SQLException{
//
//        Statement stmt=db.con.createStatement();
//        PreparedStatement ps=null;
//        String sql="Insert into Employee(Name,EmployeeId,Address,ContactInfo) values(?,?,?,?)";
//        ps=db.con.prepareStatement(sql);
//        ps.setString(1, name);
//        ps.setString(2, empid);
//        ps.setString(3, add);
//        ps.setString(4, mobile);
//    ps.executeUpdate();
//    System.out.println("Values Inserted Successfully");
//    }
//}
