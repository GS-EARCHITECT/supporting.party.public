package enterprise.company_unit_roles.master.controller;

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

import enterprise.company_unit_roles.master.model.dto.CompanyUnitRoleDTO;
import enterprise.company_unit_roles.master.services.I_CompanyUnitRolesService;

@RestController
@RequestMapping("/companyUnitRoleManagement")
public class CompanyUnitRole_Controller 
{

	//private static final Logger logger = LoggerFactory.getLogger(Customer_CompanyUnit_Controller.class);

	@Autowired
	private I_CompanyUnitRolesService companyUnitRoleServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitRoleDTO> newCompanyUnitRole(@RequestBody CompanyUnitRoleDTO companyUnitRoleDTO)
	{
		CompanyUnitRoleDTO companyDTO2 = companyUnitRoleServ.newCompanyUnitRole(companyUnitRoleDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitRoleDTO>> getAllCompanyUnitRoles() {
		ArrayList<CompanyUnitRoleDTO> companyDTOs = companyUnitRoleServ.getAllCompanyUnitRoles();		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitRoleDTO>> getSelectCompanyUnits(@RequestBody ArrayList<Long> companyUnitRoleSeqNos) {
		ArrayList<CompanyUnitRoleDTO> companyDTOs = companyUnitRoleServ.getSelectCompanyUnitRoles(companyUnitRoleSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitsForCompanyUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitRoleDTO>> getSelectCompanyUnitsForCompanyUnits(@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitRoleDTO> companyDTOs = companyUnitRoleServ.getSelectCompanyUnitRolesForUnits(companyUnitSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitRole")
	public void updateCompanyUnit(@RequestBody CompanyUnitRoleDTO companyUnitRoleDTO) {
		companyUnitRoleServ.updCompanyUnitRole(companyUnitRoleDTO);
	}

	@DeleteMapping("/delSelectCoUnitRoles")
	public void deleteSelectCoUnitRoles(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitRoleServ.delSelectCompanyUnitRoles(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsForCompanyUnits")
	public void delSelectCompanyUnitsForCompanyUnits(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitRoleServ.delSelectCompanyUnitRolesForUnits(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitRoles")
	public void deleteAllCompanyUnits() {
		companyUnitRoleServ.delAllCompanyUnitRoles();
	}
	}