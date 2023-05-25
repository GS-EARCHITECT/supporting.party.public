package enterprise.masters.unit.controller;

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

import enterprise.masters.unit.model.dto.CompanyUnitMasterDTO;
import enterprise.masters.unit.services.I_CompanyUnitMasterService;

@RestController
@RequestMapping("/unitManagement")
public class Company_Unit_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Unit_Unit_Cuntroller.class);

	@Autowired
	private I_CompanyUnitMasterService unitServ;

	@PostMapping("/new")
	public ResponseEntity<CompanyUnitMasterDTO> newUnit(@RequestBody CompanyUnitMasterDTO unitDTO) {
		CompanyUnitMasterDTO unitDTO2 = unitServ.newUnit(unitDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(unitDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitMasterDTO>> getAllUnits() {
		ArrayList<CompanyUnitMasterDTO> unitDTOs = unitServ.getAllUnits();
		// logger.info("size :"+unitDTOs.size());
		return new ResponseEntity<>(unitDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitMasterDTO>> getSelectUnits(@RequestBody ArrayList<Long> unitCuSeqNos) {
		ArrayList<CompanyUnitMasterDTO> unitDTOs = unitServ.getSelectUnits(unitCuSeqNos);
		return new ResponseEntity<>(unitDTOs, HttpStatus.OK);
	}

	@PutMapping("/updUnit")
	public void updateUnit(@RequestBody CompanyUnitMasterDTO unitDTO) {
		unitServ.updUnit(unitDTO);
	}

	@DeleteMapping("/delSelectUnits")
	public void deleteSelectUnits(@RequestBody ArrayList<Long> coSeqNoList) {
		unitServ.delSelectUnits(coSeqNoList);
	}

	@DeleteMapping("/delAllUnits")
	public void deleteAllUnits() {
		unitServ.delAllUnits();
	}
}