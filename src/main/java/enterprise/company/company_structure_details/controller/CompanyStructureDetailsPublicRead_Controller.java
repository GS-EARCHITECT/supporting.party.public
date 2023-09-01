package enterprise.company.company_structure_details.controller;

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
import enterprise.company.company_structure_details.model.dto.CompanyStructureDetail_DTO;
import enterprise.company.company_structure_details.services.I_CompanyStructureDetailsPublicRead_Service;

@RestController
@RequestMapping("/companyStructureDetailsPublicReadManagement")
public class CompanyStructureDetailsPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Customer_Company_Controller.clas);

	@Autowired
	private I_CompanyStructureDetailsPublicRead_Service companyStructureDetailsPublicReadServ;

	@GetMapping(value = "/getAllCoDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> getAllCompanyStructureDetails() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> completableFuture = companyStructureDetailsPublicReadServ.getAllCompanyStructureDetails();
		CopyOnWriteArrayList<CompanyStructureDetail_DTO> companyDTOs = completableFuture.join();		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCoDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> getSelectCompanyStructureDetails(
			@RequestBody CopyOnWriteArrayList<Long> cList)
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> completableFuture = companyStructureDetailsPublicReadServ.getSelectCompanyStructureDetails(cList);
		CopyOnWriteArrayList<CompanyStructureDetail_DTO> companyDTOs = completableFuture.join();
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
}