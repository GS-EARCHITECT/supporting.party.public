package enterprise.company_unit_functions.master.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import enterprise.company_unit_functions.master.model.dto.CompanyUnitFunctionDTO;
import enterprise.company_unit_functions.master.services.I_CompanyUnitFunctionsService;

@RestController
@RequestMapping("/companyUnitFunctionManagement")
public class CompanyUnit_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_CompanyUnit_Controller.class);

	@Autowired
	private I_CompanyUnitFunctionsService companyUnitFunctionServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitFunctionDTO> newCompanyUnitFunction(@RequestBody CompanyUnitFunctionDTO companyUnitFunctionDTO)
	{
		CompanyUnitFunctionDTO companyDTO2 = companyUnitFunctionServ.newCompanyUnitFunction(companyUnitFunctionDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitFunctions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionDTO>> getAllCompanyUnitFunctions() {
		ArrayList<CompanyUnitFunctionDTO> companyDTOs = companyUnitFunctionServ.getAllCompanyUnitFunctions();		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitFunctions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionDTO>> getSelectCompanyUnits(@RequestBody ArrayList<Long> companyUnitFunctionSeqNos) {
		ArrayList<CompanyUnitFunctionDTO> companyDTOs = companyUnitFunctionServ.getSelectCompanyUnitFunctions(companyUnitFunctionSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitsForCompanyUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionDTO>> getSelectCompanyUnitsForCompanyUnits(@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitFunctionDTO> companyDTOs = companyUnitFunctionServ.getSelectCompanyUnitFunctionsForUnits(companyUnitSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitFunction")
	public void updateCompanyUnit(@RequestBody CompanyUnitFunctionDTO companyUnitFunctionDTO) {
		companyUnitFunctionServ.updCompanyUnitFunction(companyUnitFunctionDTO);
	}

	@DeleteMapping("/delSelectCoUnitFunctions")
	public void deleteSelectCoUnitFunctions(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitFunctionServ.delSelectCompanyUnitFunctions(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsForCompanyUnits")
	public void delSelectCompanyUnitsForCompanyUnits(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitFunctionServ.delSelectCompanyUnitFunctionsForUnits(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitFunctions")
	public void deleteAllCompanyUnits() {
		companyUnitFunctionServ.delAllCompanyUnitFunctions();
	}
	}