package enterprise.company_unit_locations.controller;

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

import enterprise.company_unit_locations.model.dto.CompanyUnitLocationDTO;
import enterprise.company_unit_locations.services.I_CompanyUnitLocationsService;

@RestController
@RequestMapping("/companyUnitLocationManagement")
public class CompanyUnitLocation_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_CompanyUnit_Controller.class);

	@Autowired
	private I_CompanyUnitLocationsService companyUnitLocationServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitLocationDTO> newCompanyUnitLocation(@RequestBody CompanyUnitLocationDTO companyUnitLocationDTO)
	{
		CompanyUnitLocationDTO companyDTO2 = companyUnitLocationServ.newCompanyUnitLocation(companyUnitLocationDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitLocationDTO>> getAllCompanyUnitLocations() {
		ArrayList<CompanyUnitLocationDTO> companyDTOs = companyUnitLocationServ.getAllCompanyUnitLocations();		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitLocationDTO>> getSelectCompanyUnits(@RequestBody ArrayList<Long> companyUnitLocationSeqNos) {
		ArrayList<CompanyUnitLocationDTO> companyDTOs = companyUnitLocationServ.getSelectCompanyUnitLocations(companyUnitLocationSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitsForCompanyUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitLocationDTO>> getSelectCompanyUnitsForCompanyUnits(@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitLocationDTO> companyDTOs = companyUnitLocationServ.getSelectCompanyUnitLocationsForUnits(companyUnitSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitLocation")
	public void updateCompanyUnit(@RequestBody CompanyUnitLocationDTO companyUnitLocationDTO) {
		companyUnitLocationServ.updCompanyUnitLocation(companyUnitLocationDTO);
	}

	@DeleteMapping("/delSelectCoUnitLocations")
	public void deleteSelectCoUnitLocations(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitLocationServ.delSelectCompanyUnitLocations(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsForCompanyUnits")
	public void delSelectCompanyUnitsForCompanyUnits(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitLocationServ.delSelectCompanyUnitLocationsForUnits(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitLocations")
	public void deleteAllCompanyUnits() {
		companyUnitLocationServ.delAllCompanyUnitLocations();
	}
	}