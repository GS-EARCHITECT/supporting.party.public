package enterprise.company_units.details.controller;

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
import enterprise.company_units.details.model.dto.CompanyUnitDetailDTO;
import enterprise.company_units.details.services.I_CompanyUnitDetailsService;

@RestController
@RequestMapping("/companyUnitDetailsManagement")
public class CompanyUnitDetail_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.class);

	@Autowired
	private I_CompanyUnitDetailsService companyUnitDetailServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitDetailDTO> newCompanyUnitDetail(@RequestBody CompanyUnitDetailDTO companyDTO) {
		CompanyUnitDetailDTO companyDTO2 = companyUnitDetailServ.newCompanyUnitDetail(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitDetailDTO>> getAllCompanyUnitDetails() {
		ArrayList<CompanyUnitDetailDTO> companyDTOs = companyUnitDetailServ.getAllCompanyUnitDetails();
		//logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitDetailDTO>> getSelectCompanyUnitDetails(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		ArrayList<CompanyUnitDetailDTO> companyDTOs = companyUnitDetailServ.getSelectCompanyUnits(coSeqNoList, parCoSeqNoList);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitsByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitDetailDTO>> getSelectCompanyUnitsByParties(@RequestBody ArrayList<Long> customerCoSeqNos) {
		ArrayList<CompanyUnitDetailDTO> companyDTOs = companyUnitDetailServ.getSelectCompanyUnitsByParents(customerCoSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitDetail")
	public void updateCompanyUnitDetail(@RequestBody CompanyUnitDetailDTO companyDTO) {
		companyUnitDetailServ.updCompanyUnitDetail(companyDTO);
	}

	@DeleteMapping("/delSelectCoUnitDetails")
	public void deleteSelectCoUnitDetails(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		companyUnitDetailServ.delSelectCompanyUnits(coSeqNoList, parCoSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsByParents")
	public void delSelectCompanyUnitsByParties(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitDetailServ.delSelectCompanyUnitsByParents(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitDetails")
	public void deleteAllCompanyUnitDetails() {
		companyUnitDetailServ.delAllCompanyUnitDetails();
	}
	}