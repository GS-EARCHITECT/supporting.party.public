package enterprise.company_unit_services.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import enterprise.company_unit_services.model.dto.CompanyUnitServiceMasterDTO;
import enterprise.company_unit_services.services.I_CompanyUnitService;

@RestController
@RequestMapping("/companyUnitServicesManagement")
public class CompanyUnitServices_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_CompanyUnitService_Controller.class);

	@Autowired
	private I_CompanyUnitService companyUnitServicesServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitServiceMasterDTO> newCompanyUnitService(@RequestBody CompanyUnitServiceMasterDTO companyUnitServiceDTO) {
		CompanyUnitServiceMasterDTO companyDTO2 = companyUnitServicesServ.newCompanyUnitService(companyUnitServiceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitServiceMasterDTO>> getAllCompanyUnitServices() {
		ArrayList<CompanyUnitServiceMasterDTO> companyDTOs = companyUnitServicesServ.getAllCompanyUnitServices();
		//logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitServiceMasterDTO>> getSelectCompanyUnitServices(@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitServiceMasterDTO> companyDTOs = companyUnitServicesServ.getSelectCompanyUnitServices(companyUnitSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitServicesForCompanyUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitServiceMasterDTO>> getSelectCompanyUnitServicesForCompanyUnits(@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitServiceMasterDTO> companyDTOs = companyUnitServicesServ.getSelectCompanyUnitServicesForUnits(companyUnitSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitService")
	public void updateCompanyUnitService(@RequestBody CompanyUnitServiceMasterDTO companyDTO) {
		companyUnitServicesServ.updCompanyUnitService(companyDTO);
	}

	@DeleteMapping("/delSelectCoUnitServices")
	public void deleteSelectCoUnitServices(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitServicesServ.delSelectCompanyUnitServices(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitServicesForCompanyUnits")
	public void delSelectCompanyUnitServicesForParties(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitServicesServ.delSelectCompanyUnitServicesForUnits(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitServices")
	public void deleteAllCompanyUnitServices() {
		companyUnitServicesServ.delAllCompanyUnitServices();
	}
	}