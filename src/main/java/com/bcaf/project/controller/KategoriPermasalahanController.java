//package com.bcaf.project.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
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
//
//import com.bcaf.project.repository.KategoriPermasalahanRepo;
//
//@Controller
//@RequestMapping(value = "/kategori1/")
//public class KategoriPermasalahanController {
//
//	@Autowired
//	private KategoriPermasalahanRepo repo; 
//	
//	@GetMapping(value="index")
//	public ModelAndView index() {
//		ModelAndView view = new ModelAndView("kategori1/index");
//		
//		List<KategoriPermasalahan> kategori = this.repo.findAll();
//
//		view.addObject("kategori", kategori);
//		return view;
//	}
//	
////	public static final String SAMPLE_XLS_FILE_PATH = "./sample-xls-file.xls";
////	public static final String SAMPLE_XLSX_FILE_PATH = "./*.xlsx";
//	
//	//save the uploaded file to folder
//	public static String UPLOADED_FOLDER = "./temp/";
//	
//
//    @GetMapping("uploadkategori")
//    public ModelAndView uploadkategori() {
//		ModelAndView view = new ModelAndView("kategori/uploadKategori");
//        return view;
//    }
//	
//	@PostMapping(value = "upload")
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//            RedirectAttributes redirectAttributes) {
//
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		if(file.isEmpty()) {
//			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadstatus";
//		}
//		try {
//			  // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//		try {
////			importxls(file.getOriginalFilename());
//			importxls(path.toString());
//		} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		} catch  (IOException e) {
//            e.printStackTrace();
//		}
//		return "redirect:uploadstatus";
//	}
//	
//    @GetMapping("uploadstatus")
//    public ModelAndView uploadStatus() {
//        ModelAndView view = new ModelAndView("kategori/uploadStatus");
//        return view;
//    }
//	
//    public void importxls(String Filename)  throws IOException, InvalidFormatException {
//
//		try { 
//            String url = "jdbc:sqlserver://localhost;databaseName=project_db"; 
//            Connection conn = DriverManager.getConnection(url,"sa","M4rf3l"); 
//            Statement st = conn.createStatement(); 
//
////	        Workbook workbook = WorkbookFactory.create(new File(Filename));
////	        HSSFWorkbook workbook = (HSSFWorkbook) WorkbookFactory.create(new File(Filename));
//            XSSFWorkbook workbook = new XSSFWorkbook(Filename);
//            
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//            rowIterator.next();
//
////	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
////	        Sheet sheet = workbook.getSheetAt(0);
//	
//	        DataFormatter dataFormatter = new DataFormatter();
//	
//	        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
//	        
////	        Iterator<Row> rowIterator = sheet.rowIterator();
//	        int i=0;
//	        int c = 0;
//	        
////	        Statement st = conn.createStatement();
////	        Statement stmt=db.con.createStatement();
//	        
//	               
//	    
////	        String str="INSERT INTO tbl_kategori_permasalahan (jenis_permasalahan) VALUES ";
//			String strx = "";
//	        String all="";
//	        while (rowIterator.hasNext()) {
//	            Row row = rowIterator.next();
//	            
//	            if(i>0) {
//		            Iterator<Cell> cellIterator = row.cellIterator();
//		            strx="";
//		            c=0;
//		            while (cellIterator.hasNext()) {
//		                Cell cell = cellIterator.next();
//		                String cellValue = dataFormatter.formatCellValue(cell);
//		                
//		                String strval="";
//		                strval=cellValue.replace("'", "");
//		                strval=strval.replace("#", "");
//		                strx+="'"+strval+"',";
//		                
//			            strx=strx.substring(0,strx.length()-1)+",";
//			            c++;
//		            }
//		            strx="("+strx.substring(0,strx.length()-1)+"),";
//	        	}
//	            all+=strx;
//	            i++;
//	        }
////	        sql+=all.substring(0,all.length()-1)+";";
////	        st.executeUpdate(sql);
////	        System.out.println(sql);
//	        
//	        Object jenisPermasalahan = row.getCell(1).getStringCellValue();
//	        PreparedStatement ps=null;
//	        String sql="Insert into tbl_kategori_permasalahan(jenis_permasalahan) values(" + strx + ") VALUES ";
//	        ps=conn.prepareStatement(sql);
//	        ps.setString(c, strx);
//			ps.executeUpdate();
//	
//        	workbook.close();
//        	conn.close(); 
//	    } catch (Exception e) { 
//	        System.err.println("Got an exception! "); 
//	        System.err.println(e.getMessage()); 
//	    } 
//    }
//	
//}
