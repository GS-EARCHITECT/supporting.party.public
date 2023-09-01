package party_class_details.controller;

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

import party_class_details.model.dto.SupplierClassDetail_DTO;
import party_class_details.service.I_SupplierClassDetails_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/supplierClassDetailsManagement")
public class SupplierClassDetails_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(SupplierClassDetails_Controller.class);

	@Autowired
	private I_SupplierClassDetails_Service supplierClassDetailsServ;

	@PostMapping("/new")
	public ResponseEntity<SupplierClassDetail_DTO> newsupplierClass(
			@RequestBody SupplierClassDetail_DTO supplierClassDTO) {
		SupplierClassDetail_DTO supplierClassDTO2 = supplierClassDetailsServ.newSupplierClassDetail(supplierClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(supplierClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllSupplierClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierClassDetail_DTO>> getAllSupplierClassDetails() {
		ArrayList<SupplierClassDetail_DTO> supplierClassDTOs = supplierClassDetailsServ.getAllSupplierClassDetails();
		return new ResponseEntity<>(supplierClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSupplierClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierClassDetail_DTO>> getSelectSupplierClassDetails(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<SupplierClassDetail_DTO> supplierClassDTOs = supplierClassDetailsServ
				.getSelectSupplierClassDetails(ids);
		return new ResponseEntity<>(supplierClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSuppliersForClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierClassDetail_DTO>> getSelectSuppliersForClasses(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<SupplierClassDetail_DTO> supplierClassDTOs = supplierClassDetailsServ
				.getSelectSuppliersForClasses(ids);
		return new ResponseEntity<>(supplierClassDTOs, HttpStatus.OK);
	}

	@PutMapping("/updSupplierClassDetail")
	public void updateSupplierClassDetail(@RequestBody SupplierClassDetail_DTO supplierClassDetailsDTO) {
		supplierClassDetailsServ.updSupplierClassDetail(supplierClassDetailsDTO);
		return;
	}

	@DeleteMapping("/delSelectSupplierClassDetails")
	public void deleteSelectsupplierClassDetails(@RequestBody ArrayList<Long> ids) {
		supplierClassDetailsServ.delSelectSupplierClassDetails(ids);
		return;
	}

	@DeleteMapping("/delAllSupplierClassDetails")
	public void deleteAllsupplierClassDetails() {
		supplierClassDetailsServ.delAllSupplierClassDetails();
		;
		return;
	}
}