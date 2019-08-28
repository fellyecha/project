package com.bcaf.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.DataDistribution;
import com.bcaf.project.model.StatusData;
import com.bcaf.project.model.User;
import com.bcaf.project.repository.DataDistributionRepo;
import com.bcaf.project.repository.StatusDataRepo;

@Controller
@RequestMapping(value = "/custDataCMO/")
public class CustDataCMOController extends BaseController{
	@Autowired
	private DataDistributionRepo repo;
	
	@Autowired
	private StatusDataRepo statRepo;
	
	@GetMapping(value="index")
	public ModelAndView index() throws SQLException{
		ModelAndView view = new ModelAndView("custDataCMO/index");
		
		User user = getUser();
		String us = user.getUsername();
		
		String sql = "Select * From tbl_data_distribution1 a "
				+ "JOIN tbl_cabang_ds c ON a.cabang_ds = c.cabang_ds "
				+ "JOIN tbl_user_role_cabang AS r ON c.id = r.cabang_id "
				+ "JOIN tbl_user AS f ON r.username = f.id "
				+ "WHERE f.username = ? "
				+ "ORDER BY a.id ASC";
		
		List<DataDistribution> list = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost;databaseName=project_db", "sa", "Marf3l");
				PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			
			preparedStatement.setString(1, us);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	long id = resultSet.getLong("id");
                String noRek = resultSet.getString("no_rek");
                String noPin = resultSet.getString("no_pin");
                String customerId = resultSet.getString("customer_id");
                String customerName = resultSet.getString("customer_name");
                String gender = resultSet.getString("gender");
                String idCardNumber = resultSet.getString("id_card_number");
                String birthdate = resultSet.getString("birth_date");
                String homePhoneNumber = resultSet.getString("home_phone_number");
                String hpNumber = resultSet.getString("hp_number");
                String emailKonsumen = resultSet.getString("email_konsumen");
                String companyName = resultSet.getString("company_name");
                String jobTitle = resultSet.getString("job_title");
                String spouseName = resultSet.getString("spouse_name");
                String homeKabupaten = resultSet.getString("home_kabupaten");
                String branchName = resultSet.getString("branch_name");
                String subProduk = resultSet.getString("sub_produk");
                String merkName = resultSet.getString("merk_name");
                String tipe = resultSet.getString("tipe");
                String tahun = resultSet.getString("tahun");
                String hargaBarang = resultSet.getString("harga_barang");
                String tenor = resultSet.getString("tenor");
                String bpkbNo = resultSet.getString("bpkb_no");
                String bodyNo = resultSet.getString("body_no");
                String realisasiDate = resultSet.getString("realisasi_date");
                String closeDate = resultSet.getString("close_date");
                String endDate = resultSet.getString("end_date");
                String periodBerjalan = resultSet.getString("period_berjalan");
                String angsuranKonsumen = resultSet.getString("angsuran_konsumen");
                String osPokokKonsumen = resultSet.getString("os_pokok_konsumen");
                String statusCloseType = resultSet.getString("status_close_type");
                String odDaysMax = resultSet.getString("od_days_max");
                String ovdByCustID = resultSet.getString("ovd_by_cust_id");
                String odLoan = resultSet.getString("od_loan");
                String bpkbStatus = resultSet.getString("bpkb_status");
                String bcaBranchStatus = resultSet.getString("bca_branch_status");
                String bcaBranchName = resultSet.getString("bca_branch_name");
                String bcaKcuName = resultSet.getString("bca_kcu_name");
                String salesAgent = resultSet.getString("sales_agent");
                String salesAgentName = resultSet.getString("sales_agent_name");
                String sisaPeriode = resultSet.getString("sisa_periode");
                String cabangName = resultSet.getString("cabang_ds");
                String source = resultSet.getString("source");
                String product = resultSet.getString("product");

                DataDistribution obj = new DataDistribution();
                obj.setId(id);
                obj.setNoRek(noRek);
                obj.setNoPin(noPin);
                obj.setCustomerId(customerId);
                obj.setCustomerName(customerName);
                obj.setGender(gender);
                obj.setIdCardNumber(idCardNumber);
                obj.setBirthdate(birthdate);
                obj.setHomePhoneNumber(homePhoneNumber);
                obj.setHpNumber(hpNumber);
                obj.setEmailKonsumen(emailKonsumen);
                obj.setCompanyName(companyName);
                obj.setJobTitle(jobTitle);
                obj.setSpouseName(spouseName);
                obj.setHomeKabupaten(homeKabupaten);
                obj.setBranchName(bcaBranchName);
                obj.setSubProduk(subProduk);
                obj.setMerkName(merkName);
                obj.setTipe(tipe);
                obj.setTahun(tahun);
                obj.setHargaBarang(hargaBarang);
                obj.setTenor(tenor);
                obj.setBpkbNo(bpkbNo);
                obj.setBodyNo(bodyNo);
                obj.setRealisasiDate(realisasiDate);
                obj.setCloseDate(closeDate);
                obj.setEndDate(endDate);
                obj.setPeriodBerjalan(periodBerjalan);
                obj.setAngsuranKonsumen(angsuranKonsumen);
                obj.setOsPokokKonsumen(osPokokKonsumen);
                obj.setStatusCloseType(statusCloseType);
                obj.setOdDaysMax(odDaysMax);
                obj.setOvdByCustID(ovdByCustID);
                obj.setOdLoan(odLoan);
                obj.setBpkbStatus(bpkbStatus);
                obj.setBcaBranchStatus(bcaBranchStatus);
                obj.setBcaBranchName(bcaBranchName);
                obj.setBcaKcuName(bcaKcuName);
                obj.setSalesAgent(salesAgentName);
                obj.setSalesAgentName(salesAgentName);
                obj.setSisaPeriode(sisaPeriode);
                obj.setCabangName(cabangName);
                obj.setSource(source);
                obj.setProduct(product);

//                System.out.println(obj);
                list.add(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
		view.addObject("list", list);
		return view;
	}
	
	//
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("custDataCMO/_form");
		DataDistribution item = this.repo.findById(id).orElse(null);
		view.addObject("objCustData", item);
		List<StatusData> listStatus = this.statRepo.findByStatusOrder1();
		view.addObject("listStatus", listStatus);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute DataDistribution objCustData, BindingResult result) {
		ModelAndView view = new ModelAndView("custDataCMO/_form");
		if(result.hasErrors()) {
			view.addObject("objCustData", objCustData);
		}
		else {
			this.repo.save(objCustData);
			view.addObject("objCustData", new DataDistribution());
		}
		
		return view;
		
	}

	@GetMapping(value = "list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("custDataCMO/_list");
		List<DataDistribution> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
