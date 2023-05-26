package supplier.supplier_mgmt.controller;

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

import supplier.supplier_mgmt.model.dto.SupplierMasterDTO;
import supplier.supplier_mgmt.services.I_SupplierMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/suppliersManagement")
public class SupplierMasterController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Suppliers_Controller.class);

	@Autowired
	private I_SupplierMasterService supplierMasterServ;

	@PostMapping("/new")
	public ResponseEntity<SupplierMasterDTO> newSuppliers(@RequestBody SupplierMasterDTO SupplierMasterDTO) 
	{
		SupplierMasterDTO SupplierMasterDTO2 = supplierMasterServ.newSupplier(SupplierMasterDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(SupplierMasterDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectSuppliers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierMasterDTO>> getSelectSuppliers(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<SupplierMasterDTO> SupplierMasterDTOs = supplierMasterServ.getSelectSuppliers(ids);
		return new ResponseEntity<>(SupplierMasterDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllSuppliers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierMasterDTO>> getAllSupplierss() {
		ArrayList<SupplierMasterDTO> SupplierMasterDTOs = supplierMasterServ.getAllSuppliers();
		return new ResponseEntity<>(SupplierMasterDTOs, HttpStatus.OK);
	}

	
	@PutMapping("/updSuppliers")
	public void updateSuppliers(@RequestBody SupplierMasterDTO SupplierMasterDTO) {
		supplierMasterServ.updSupplier(SupplierMasterDTO);
		return;
	}

	@DeleteMapping("/delSelectSuppliers")	
	public void deleteSelectSuppliers(@RequestBody ArrayList<Long> SuppliersSeqNoList) {
		supplierMasterServ.getSelectSuppliers(SuppliersSeqNoList);
		return;
	}

	@DeleteMapping("/delAllSuppliers")
	public void deleteAllSuppliers() {
		supplierMasterServ.delAllSuppliers();
		return;
	}
}