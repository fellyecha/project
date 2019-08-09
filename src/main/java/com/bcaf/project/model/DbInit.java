package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcaf.project.repository.CabangDsRepo;
//import com.bcaf.project.repository.KabupatenKotaRepo;
//import com.bcaf.project.repository.KecamatanRepo;
//import com.bcaf.project.repository.KelurahanRepo;
//import com.bcaf.project.repository.ProvinsiRepo;
import com.bcaf.project.repository.RoleRepo;
import com.bcaf.project.repository.UserRepo;
import com.bcaf.project.repository.UserRoleCabangRepo;
import com.bcaf.project.repository.UserRoleRepo;

@Service
public class DbInit implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	@Autowired
	private UserRoleCabangRepo userRoleCabangRepo;
	
	@Autowired
	private CabangDsRepo cabangDsRepo;

	@Override
	public void run(String... args) throws Exception {
		// insert user
		if (this.userRepo.findAll().size() == 0) {// ini size nya 0 itu buat liat apakah dia udah ada di DB ato belum
			// kalo dia 0 artinya belum ada di DB tapi kalo udah ada maka dia selain satu.
			// jadi lewat aja
			List<User> listUser = new ArrayList<User>();
			listUser.add(new User("user", passwordEncoder.encode("user123"), "user@bcaf.co.id"));
			listUser.add(new User("staff", passwordEncoder.encode("user123"), "user2@bcaf.co.id"));
			listUser.add(new User("admin", passwordEncoder.encode("admin123"), "admin@bcaf.co.id"));
			listUser.add(new User("manager", passwordEncoder.encode("manager123"), "manager@bcaf.co.id"));
			listUser.add(new User("20091517", passwordEncoder.encode("cmcdh123"), "20091517@bcaf.co.id"));
			listUser.add(new User("20122571", passwordEncoder.encode("cmc123"), "20122571@bcaf.co.id"));
			listUser.add(new User("20060991", passwordEncoder.encode("rm123"), "20060991@bcaf.co.id"));
			listUser.add(new User("20130443", passwordEncoder.encode("bm123"), "20130443@bcaf.co.id"));
			listUser.add(new User("20190077", passwordEncoder.encode("cmonew123"), "20190077@bcaf.co.id"));
			listUser.add(new User("20140515", passwordEncoder.encode("cmoref123"), "20140515@bcaf.co.id"));
			listUser.add(new User("20180995", passwordEncoder.encode("cmomul123"), "20180995@bcaf.co.id"));

			// simpan ke database
			this.userRepo.saveAll(listUser);
		}

		// insert role
		if (this.roleRepo.findAll().size() == 0) {
			List<Role> listRole = new ArrayList<Role>();
			//ini dari constructor
			listRole.add(new Role("ROLE_ADMIN", "Role Admin"));
			listRole.add(new Role("ROLE_USER", "Role User"));
			listRole.add(new Role("ROLE_STAFF", "Role Staff"));
			listRole.add(new Role("ROLE_MANAGER", "Role Manager"));
			listRole.add(new Role("ROLE_CMCDH", "Role CMC Dept. Head"));
			listRole.add(new Role("ROLE_CMC", "Role CMC Staff"));
			listRole.add(new Role("ROLE_RM", "Role RM"));
			listRole.add(new Role("ROLE_BM", "Role BM"));
			listRole.add(new Role("ROLE_CMONEW", "Role CMO New Car"));
			listRole.add(new Role("ROLE_CMOREF", "Role CMO Refinancing"));
			listRole.add(new Role("ROLE_CMOMUL", "Role CMO Multiguna"));

			// simpan role ke database
			this.roleRepo.saveAll(listRole);
		}
		
		if(this.userRoleRepo.findAll().size()==0) {
			List<UserRole> listUserRole = new ArrayList<UserRole>();
			// mencari user dulu
			User user1 = this.userRepo.findByUsername("user");
			Role role1 = this.roleRepo.findByCode("ROLE_USER");
			listUserRole.add(new UserRole(user1.getId(), role1.getId()));
			
			User user2 = this.userRepo.findByUsername("staff");
			Role role2 = this.roleRepo.findByCode("ROLE_STAFF");
			listUserRole.add(new UserRole(user2.getId(), role2.getId()));
			
			User user3 = this.userRepo.findByUsername("manager");
			Role role3 = this.roleRepo.findByCode("ROLE_MANAGER");
			listUserRole.add(new UserRole(user3.getId(), role3.getId()));
			
			User user4 = this.userRepo.findByUsername("admin");
			Role role4 = this.roleRepo.findByCode("ROLE_ADMIN");
			listUserRole.add(new UserRole(user4.getId(), role4.getId()));
			
			User user5 = this.userRepo.findByUsername("20091517");
			Role role5 = this.roleRepo.findByCode("ROLE_CMCDH");
			listUserRole.add(new UserRole(user5.getId(), role5.getId()));
			
			User user6 = this.userRepo.findByUsername("20122571");
			Role role6 = this.roleRepo.findByCode("ROLE_CMC");
			listUserRole.add(new UserRole(user6.getId(), role6.getId()));
			
			User user7 = this.userRepo.findByUsername("20060991");
			Role role7 = this.roleRepo.findByCode("ROLE_RM");
			listUserRole.add(new UserRole(user7.getId(), role7.getId()));
			
			User user8 = this.userRepo.findByUsername("20130443");
			Role role8 = this.roleRepo.findByCode("ROLE_BM");
			listUserRole.add(new UserRole(user8.getId(), role8.getId()));
			
			User user9 = this.userRepo.findByUsername("20190077");
			Role role9 = this.roleRepo.findByCode("ROLE_CMONEW");
			listUserRole.add(new UserRole(user9.getId(), role9.getId()));
			
			User user10 = this.userRepo.findByUsername("20140515");
			Role role10 = this.roleRepo.findByCode("ROLE_CMOREF");
			listUserRole.add(new UserRole(user10.getId(), role10.getId()));
			
			User user11 = this.userRepo.findByUsername("20180995");
			Role role11 = this.roleRepo.findByCode("ROLE_CMOMUL");
			listUserRole.add(new UserRole(user11.getId(), role11.getId()));
			
			this.userRoleRepo.saveAll(listUserRole);
			
		}
		
		if(this.userRoleCabangRepo.findAll().size()==0) {
			List<UserRoleCabang> listUserRoleCabang = new ArrayList<UserRoleCabang>();
			
			//BM - Bu DESSY
			User user1 = this.userRepo.findByUsername("20130443");
			CabangDs cabangDs1 = this.cabangDsRepo.findByCabangName("WPI V");
			listUserRoleCabang.add(new UserRoleCabang(user1.getId(), cabangDs1.getId()));
			
			User user2 = this.userRepo.findByUsername("20130443");
			CabangDs cabangDs2 = this.cabangDsRepo.findByCabangName("DEPOK");
			listUserRoleCabang.add(new UserRoleCabang(user2.getId(), cabangDs2.getId()));
			
			User user3 = this.userRepo.findByUsername("20130443");
			CabangDs cabangDs3 = this.cabangDsRepo.findByCabangName("BALIKPAPAN");
			listUserRoleCabang.add(new UserRoleCabang(user3.getId(), cabangDs3.getId()));
			
			User user4 = this.userRepo.findByUsername("20130443");
			CabangDs cabangDs4 = this.cabangDsRepo.findByCabangName("BANJARMASIN");
			listUserRoleCabang.add(new UserRoleCabang(user4.getId(), cabangDs4.getId()));
			
			User user5 = this.userRepo.findByUsername("20130443");
			CabangDs cabangDs5 = this.cabangDsRepo.findByCabangName("SAMARINDA");
			listUserRoleCabang.add(new UserRoleCabang(user5.getId(), cabangDs5.getId()));
			
			User user6 = this.userRepo.findByUsername("20130443");
			CabangDs cabangDs6 = this.cabangDsRepo.findByCabangName("PONTIANAK");
			listUserRoleCabang.add(new UserRoleCabang(user6.getId(), cabangDs6.getId()));
			
			//CMO NEW WPI V
			User user7 = this.userRepo.findByUsername("20190077");
			CabangDs cabangDs7 = this.cabangDsRepo.findByCabangName("WPI V");
			listUserRoleCabang.add(new UserRoleCabang(user7.getId(), cabangDs7.getId()));
			
			//CMO REF WPI V
			User user8 = this.userRepo.findByUsername("20140515");
			CabangDs cabangDs8 = this.cabangDsRepo.findByCabangName("WPI V");
			listUserRoleCabang.add(new UserRoleCabang(user8.getId(), cabangDs8.getId()));
			
			//CMO MUL WPI V
			User user9 = this.userRepo.findByUsername("20180995");
			CabangDs cabangDs9 = this.cabangDsRepo.findByCabangName("WPI V");
			listUserRoleCabang.add(new UserRoleCabang(user9.getId(), cabangDs9.getId()));
			
			this.userRoleCabangRepo.saveAll(listUserRoleCabang);
			
		}
//
//		// insert provinsi
//		if (this.provinsiRepo.findAll().size() == 0) {
//			List<Provinsi> listProvinsi = new ArrayList<Provinsi>();
//			listProvinsi.add(new Provinsi("Jawa Barat"));
//			// listProvinsi.add(new Provinsi("DKI Jakarta"));
//
//			this.provinsiRepo.saveAll(listProvinsi);
//		}
//
//		long provinsiId = this.provinsiRepo.findByNamaProvinsi("Jawa Barat").getId();
//		// insert kabupaten kota
//		if (this.kabupatenKotaRepo.findAll().size() == 0) {
//			List<KabupatenKota> listKabKota = new ArrayList<KabupatenKota>();
//			listKabKota.add(new KabupatenKota("Depok", provinsiId));
//			listKabKota.add(new KabupatenKota("Bogor", provinsiId));
//
//			this.kabupatenKotaRepo.saveAll(listKabKota);
//
//		}
//
//		// insert kecamatan
//		if (this.kecamatanRepo.findAll().size() == 0) {
//			List<Kecamatan> listKecamatan = new ArrayList<Kecamatan>();
//			listKecamatan.add(new Kecamatan("Cinere"));
//			// listKecamatan.add(new Kecamatan("Beji"));
//
//			this.kecamatanRepo.saveAll(listKecamatan);
//		}
//
//		// insert kelurahan
//		if (this.kelurahanRepo.findAll().size() == 0) {
//			List<Kelurahan> listKelurahan = new ArrayList<Kelurahan>();
//			listKelurahan.add(new Kelurahan("Cinere", 16514));
//			// listKecamatan.add(new Kecamatan("Gandul"));
//
//			this.kelurahanRepo.saveAll(listKelurahan);
//		}

	}

}
