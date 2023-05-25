package enterprise.company_units.master.controller;

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

import enterprise.company_units.master.model.dto.CompanyUnitDTO;
import enterprise.company_units.master.services.I_CompanyUnitService;

@RestController
@RequestMapping("/companyUnitManagement")
public class CompanyUnit_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_CompanyUnit_Controller.class);

	@Autowired
	private I_CompanyUnitService companyUnitServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitDTO> newCompanyUnit(@RequestBody CompanyUnitDTO companyDTO) {
		CompanyUnitDTO companyDTO2 = companyUnitServ.newCompanyUnit(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitDTO>> getAllCompanyUnits() {
		ArrayList<CompanyUnitDTO> companyDTOs = companyUnitServ.getAllCompanyUnits();
		//logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitDTO>> getSelectCompanyUnits(@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitDTO> companyDTOs = companyUnitServ.getSelectCompanyUnits(companyUnitSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitsForParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitDTO>> getSelectCompanyUnitsForParties(@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitDTO> companyDTOs = companyUnitServ.getSelectCompanyUnitsForUnitTypes(companyUnitSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnit")
	public void updateCompanyUnit(@RequestBody CompanyUnitDTO companyDTO) {
		companyUnitServ.updCompanyUnit(companyDTO);
	}

	@DeleteMapping("/delCompanyUnit/{coSeqNo}")
	public void deleteCompanyUnit(@PathVariable String coSeqNo) {
		companyUnitServ.delCompanyUnit(Long.parseLong(coSeqNo));
	}

	@DeleteMapping("/delSelectCoUnits")
	public void deleteSelectCoUnits(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitServ.delSelectCompanyUnits(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsForParties")
	public void delSelectCompanyUnitsForParties(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitServ.delSelectCompanyUnitsForUnitTypes(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnits")
	public void deleteAllCompanyUnits() {
		companyUnitServ.delAllCompanyUnits();
	}
	}