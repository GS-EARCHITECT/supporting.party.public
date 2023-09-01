package enterprise.company.company_class_details.controller;

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
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import enterprise.company.company_class_details.model.dto.CompanyClassDetail_DTO;
import enterprise.company.company_class_details.services.I_CompanyClassDetailsPublicRead_Service;

@RestController
@RequestMapping("/companyClassDetailsPublicReadManagement")
public class CompanyClassDetailsPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Customer_Company_Controller.clas);

	@Autowired
	private I_CompanyClassDetailsPublicRead_Service companyClassDetailsPublicReadServ;

	@GetMapping(value = "/getAllCoClassDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getAllCompanyClassDetails() {
		CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> completableFuture = companyClassDetailsPublicReadServ
				.getAllCompanyClassDetails();
		CopyOnWriteArrayList<CompanyClassDetail_DTO> classDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(classDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyClassDetailsByClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByClasses(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> completableFuture = companyClassDetailsPublicReadServ
				.getSelectCompanyClassDetailsByClasses(ids);
		CopyOnWriteArrayList<CompanyClassDetail_DTO> classDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(classDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyClassDetailsByCompanies", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByCompanies(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> completableFuture = companyClassDetailsPublicReadServ
				.getSelectCompanyClassDetailsByCompanies(ids);
		CopyOnWriteArrayList<CompanyClassDetail_DTO> classDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(classDetail_DTOs, HttpStatus.OK);
	}

}