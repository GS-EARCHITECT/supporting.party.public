package enterprise.company.company_master.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import enterprise.company.company_master.model.dto.CompanyMaster_DTO;
import enterprise.company.company_master.services.I_CompanyMasterPublicRead_Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/companyPublicReadManagement")
public class CompanyMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Customer_Company_Controller.class);

	@Autowired
	private I_CompanyMasterPublicRead_Service companyMasterPublicReadServ;

	@GetMapping(value = "/getAllCos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyMaster_DTO>> getAllCompanyMasters() {
		CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> completableFuture = companyMasterPublicReadServ
				.getAllCompanies();
		CopyOnWriteArrayList<CompanyMaster_DTO> companyDTOs = completableFuture.join();
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyMaster_DTO>> getSelectCompanyMasters(
			@RequestBody CopyOnWriteArrayList<Long> coCoSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> completableFuture = companyMasterPublicReadServ
				.getSelectCompanies(coCoSeqNos);
		CopyOnWriteArrayList<CompanyMaster_DTO> companyDTOs = completableFuture.join();
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompaniesForParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyMaster_DTO>> getSelectCompaniesForParties(
			@RequestBody CopyOnWriteArrayList<Long> pSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> completableFuture = companyMasterPublicReadServ
				.getSelectCompaniesForParties(pSeqNos);
		CopyOnWriteArrayList<CompanyMaster_DTO> companyDTOs = completableFuture.join();
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

}