package enterprise.company_unit_class_structure.controller;

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
import enterprise.company_unit_class_structure.model.dto.CompanyUnitClassStructure_DTO;
import enterprise.company_unit_class_structure.services.I_CompanyUnitClassStructure_Service;

@RestController
@RequestMapping("/companyUnitClassStructureManagement")
public class CompanyUnitClassStructure_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.class);

	@Autowired
	private I_CompanyUnitClassStructure_Service companyUnitClassStructureServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitClassStructure_DTO> newCompanyUnitClassStructure(@Valid @RequestBody CompanyUnitClassStructure_DTO companyDTO) 
	{
		CompanyUnitClassStructure_DTO companyDTO2 = companyUnitClassStructureServ.newCompanyUnitClassStructure(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitClassStructure", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassStructure_DTO>> getAllCompanyUnitClassStructure() {
		ArrayList<CompanyUnitClassStructure_DTO> companyDTOs = companyUnitClassStructureServ.getAllCompanyUnitClassStructures();
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitClassStructure", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassStructure_DTO>> getSelectCompanyUnitClassStructure(@RequestBody ArrayList<Long> coSeqNoList) 
	{
		ArrayList<CompanyUnitClassStructure_DTO> companyDTOs = companyUnitClassStructureServ.getSelectCompanyUnitClassStructures(coSeqNoList);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitClassStructureForParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassStructure_DTO>> getSelectCompanyUnitClassStructureForParents(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids) 
	{
		ArrayList<CompanyUnitClassStructure_DTO> companyDTOs = companyUnitClassStructureServ.getSelectCompanyUnitClassStructuresForParentClasses(ids, pids);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyUnitClassStructureForChildren", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassStructure_DTO>> getSelectCompanyUnitClassStructureForChildren(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) 
	{
		ArrayList<CompanyUnitClassStructure_DTO> companyDTOs = companyUnitClassStructureServ.getSelectCompanyUnitClassStructuresForParentClasses(ids, cids);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyUnitClassStructure")
	public void updateCompanyUnitClassStructure(@RequestBody CompanyUnitClassStructure_DTO companyDTO) 
	{
		companyUnitClassStructureServ.updCompanyUnitClassStructure(companyDTO);
	}

	@DeleteMapping("/delSelectCoUnitClassStructure")
	public void deleteSelectCoUnitClassStructure(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		companyUnitClassStructureServ.delSelectCompanyUnitClassStructures(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsForParents")
	public void delSelectCompanyUnitsForParents(@RequestBody ArrayList<Long> cSeqNoList,@RequestBody ArrayList<Long> pSeqNoList)
	{
		companyUnitClassStructureServ.delSelectCompanyUnitClassStructuresForParentClasses(cSeqNoList, pSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyUnitsForChildren")
	public void delSelectCompanyUnitsForChildren(@RequestBody ArrayList<Long> coseqNoList,@RequestBody ArrayList<Long> cSeqNoList)
	{
		companyUnitClassStructureServ.delSelectCompanyUnitClassStructuresForChildClasses(coseqNoList, cSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitClassStructure")
	public void deleteAllCompanyUnitClassStructure() {
		companyUnitClassStructureServ.delAllCompanyUnitClassStructures();
	}
	}