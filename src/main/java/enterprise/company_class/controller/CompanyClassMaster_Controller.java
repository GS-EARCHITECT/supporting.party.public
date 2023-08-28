package enterprise.company_class.controller;

import java.util.ArrayList;
import javax.validation.Valid;
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
import enterprise.masters.company_class.exception_handler.CompanyClass_Exception;
import enterprise.masters.company_class.model.dto.CompanyClassMaster_DTO;
import enterprise.masters.company_class.services.I_CompanyClassMaster_Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/companyClassManagement")
public class CompanyClassMaster_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Unit_Unit_Classntroller.class);

	@Autowired
	private I_CompanyClassMaster_Service companyClassServ;

	@PostMapping("/new")
	public ResponseEntity<CompanyClassMaster_DTO> newUnit(@Valid @RequestBody CompanyClassMaster_DTO companyClassDTO) {
		CompanyClassMaster_DTO companyClassDTO2 = companyClassServ.newCompanyClass(companyClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyClassMaster_DTO>> getAllCompanyClasses() {
		ArrayList<CompanyClassMaster_DTO> companyClassDTOs = companyClassServ.getAllCompanyClasses();
		return new ResponseEntity<>(companyClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyClassMaster_DTO>> getSelectCompanyClasses(@RequestBody ArrayList<Long> companyClassSeqNos) {
		ArrayList<CompanyClassMaster_DTO> companyClassDTOs = companyClassServ.getSelectCompanyClasses(companyClassSeqNos);
		
		if(companyClassDTOs==null) 
		{
		throw new CompanyClass_Exception("Not found Tutorial with id = ");	
		}
		else
		{
		return new ResponseEntity<>(companyClassDTOs, HttpStatus.OK);
		}
	}

	@PutMapping("/updCompanyClass")
	public void updateCompanyClass(@Valid @RequestBody CompanyClassMaster_DTO companyClassDTO) 
	{
		companyClassServ.updCompanyClass(companyClassDTO);
	}

	@DeleteMapping("/delSelectCompanyClasses")
	public void deleteSelectCompanyClasses(@RequestBody ArrayList<Long> coSeqNoList) {
		companyClassServ.delSelectCompanyClasses(coSeqNoList);
	}

	@DeleteMapping("/delAllCompanyClasses")
	public void deleteAllCompanyClasses() {
		companyClassServ.delAllCompanyClasses();
	}
}