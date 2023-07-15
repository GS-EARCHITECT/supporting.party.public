package enterprise.company_unit_class_details.controller;

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

import enterprise.company_unit_class_details.model.dto.CompanyUnitClassDetail_DTO;
import enterprise.company_unit_class_details.services.I_CompanyUnitClassDetails_Service;

@RestController
@RequestMapping("/companyUnitClassDetailsManagement")
public class CompanyUnitClassDetail_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.class);

	@Autowired
	private I_CompanyUnitClassDetails_Service companyUnitClassDetailServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitClassDetail_DTO> newCompanyUnitClassDetail(@RequestBody CompanyUnitClassDetail_DTO companyDTO) {
		CompanyUnitClassDetail_DTO companyDTO2 = companyUnitClassDetailServ.newCompanyUnitClassDetail(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitClassDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassDetail_DTO>> getAllCompanyUnitClassDetails() {
		ArrayList<CompanyUnitClassDetail_DTO> companyDTOs = companyUnitClassDetailServ.getAllCompanyUnitClassDetails();
		//logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitClassDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassDetail_DTO>> getSelectCompanyUnitClassDetails(@RequestBody ArrayList<Long> coSeqNoList) 
	{
		ArrayList<CompanyUnitClassDetail_DTO> companyDTOs = companyUnitClassDetailServ.getSelectCompanyUnitClassDetails(coSeqNoList);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitsForChildren", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassDetail_DTO>> getSelectCompanyUnitsForChildren(@RequestBody ArrayList<Long> coSeqNos, @RequestBody ArrayList<Long> chSeqNos) 
	{
		ArrayList<CompanyUnitClassDetail_DTO> companyDTOs = companyUnitClassDetailServ.getSelectCompanyUnitClassDetailsForChildClasses(coSeqNos, chSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitClassDetail")
	public void updateCompanyUnitClassDetail(@RequestBody CompanyUnitClassDetail_DTO companyDTO) {
		companyUnitClassDetailServ.updCompanyUnitClassDetail(companyDTO);
	}

	@DeleteMapping("/delSelectCoUnitClassDetails")
	public void deleteSelectCoUnitClassDetails(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		companyUnitClassDetailServ.delSelectCompanyUnitClassDetails(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsForChildren")
	public void delSelectCompanyUnitsForChildren(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> chSeqNoList) 
	{
		companyUnitClassDetailServ.delSelectCompanyUnitClassDetailsForChildClasses(coSeqNoList, chSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitClassDetails")
	public void deleteAllCompanyUnitClassDetails() {
		companyUnitClassDetailServ.delAllCompanyUnitClassDetails();
	}
	}