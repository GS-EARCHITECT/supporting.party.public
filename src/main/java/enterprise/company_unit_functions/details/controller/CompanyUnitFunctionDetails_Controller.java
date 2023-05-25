package enterprise.company_unit_functions.details.controller;

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

import enterprise.company_unit_functions.details.model.dto.CompanyUnitFunctionDetailDTO;
import enterprise.company_unit_functions.details.services.I_CompanyUnitFunctionDetailsService;

@RestController
@RequestMapping("/companyUnitFunctionDetailsManagement")
public class CompanyUnitFunctionDetails_Controller 
{

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.clas);

	@Autowired
	private I_CompanyUnitFunctionDetailsService companyUnitFunctionDetailsServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitFunctionDetailDTO> newCompanyUnitFunctionDetail(@RequestBody CompanyUnitFunctionDetailDTO companyUnitFunctionDTO) {
		CompanyUnitFunctionDetailDTO companyUnitFunctionDTO2 = companyUnitFunctionDetailsServ.newCompanyUnitFunctionDetail(companyUnitFunctionDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyUnitFunctionDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitFunctionDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionDetailDTO>> getAllCompanyUnitFunctionDetails() {
		ArrayList<CompanyUnitFunctionDetailDTO> companyUnitFunctionDTOs = companyUnitFunctionDetailsServ.getAllCompanyUnitFunctionDetails();
		//logger.info("size :"+companyUnitFunctionDTOs.size());
		return new ResponseEntity<>(companyUnitFunctionDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitFunctionDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionDetailDTO>> getSelectCompanyUnitFunctionDetails(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		ArrayList<CompanyUnitFunctionDetailDTO> companyUnitFunctionDTOs = companyUnitFunctionDetailsServ.getSelectCompanyUnitFunctionDetails(coSeqNoList, parCoSeqNoList);		
		return new ResponseEntity<>(companyUnitFunctionDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitFunctionDetailsByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionDetailDTO>> getSelectCoUnitFunctionDetailsByParents(@RequestBody ArrayList<Long> cSeqNos) {
		ArrayList<CompanyUnitFunctionDetailDTO> companyUnitFunctionDTOs = companyUnitFunctionDetailsServ.getSelectCompanyUnitFunctionDetailsByParents(cSeqNos);		
		return new ResponseEntity<>(companyUnitFunctionDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitFunctionDetail")
	public void updateCompanyUnitFunctionDetail(@RequestBody CompanyUnitFunctionDetailDTO companyUnitFunctionDetailDTO) {
		companyUnitFunctionDetailsServ.updCompanyUnitFunctionDetail(companyUnitFunctionDetailDTO);
	}

	@DeleteMapping("/delSelectCoUnitFunctionDetails")
	public void deleteSelectCoUnitFunctionDetails(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		companyUnitFunctionDetailsServ.delSelectCompanyUnitFunctionDetails(coSeqNoList, parCoSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitFunctionDetailsByParents")
	public void delSelectCompanyUnitFunctionDetailsByParents(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitFunctionDetailsServ.delSelectCompanyUnitFunctionDetailsByParents(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitFunctionDetails")
	public void deleteAllCompanyUnitFunctionDetails() {
		companyUnitFunctionDetailsServ.delAllCompanyUnitFunctionDetails();
	}
	}