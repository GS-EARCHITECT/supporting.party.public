package supplier.supplier_prodservcs.controller;

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

import supplier.supplier_prodservcs.model.dto.SupplierProdServDetailsDTO;
import supplier.supplier_prodservcs.services.I_SupplierProdServDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/supplierProdServDetailsManagement")
public class SupplierProdServDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(SupplierProdServDetails_Controller.class);

	@Autowired
	private I_SupplierProdServDetailsService supplierProdServDetailsServ;

	@PostMapping("/new")
	public ResponseEntity<SupplierProdServDetailsDTO> newSupplierProdServDetail(
			@RequestBody SupplierProdServDetailsDTO SupplierProdServDetailsDTO) {
		SupplierProdServDetailsDTO SupplierProdServDetailsDTO2 = supplierProdServDetailsServ
				.newSupplierProdServDetail(SupplierProdServDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(SupplierProdServDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectSupplierProdServDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServDetailsDTO>> getSelectSupplierProdServDetails(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetailsDTO> SupplierProdServDetailsDTOs = supplierProdServDetailsServ
				.getSelectSupplierProdServDetails(ids);
		return new ResponseEntity<>(SupplierProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSupplierAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServDetailsDTO>> getSelectSupplierAssets(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetailsDTO> SupplierProdServDetailsDTOs = supplierProdServDetailsServ
				.getSelectSupplierAssets(ids);
		return new ResponseEntity<>(SupplierProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSupplierResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServDetailsDTO>> getSelectSupplierResources(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetailsDTO> SupplierProdServDetailsDTOs = supplierProdServDetailsServ
				.getSelectSupplierResources(ids);
		return new ResponseEntity<>(SupplierProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSupplierServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServDetailsDTO>> getSelectSupplierServices(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetailsDTO> SupplierProdServDetailsDTOs = supplierProdServDetailsServ
				.getSelectSupplierServices(ids);
		return new ResponseEntity<>(SupplierProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllSupplierProdServDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServDetailsDTO>> getAllSupplierProdServDetails() {
		ArrayList<SupplierProdServDetailsDTO> SupplierProdServDetailsDTOs = supplierProdServDetailsServ
				.getAllSupplierProdServDetails();
		return new ResponseEntity<>(SupplierProdServDetailsDTOs, HttpStatus.OK);
	}

	@PutMapping("/updSupplierProdServDetails")
	public void updateSupplierProdServDetails(@RequestBody SupplierProdServDetailsDTO supplierProdServDetailsDTO) {
		supplierProdServDetailsServ.updSupplierProdServDetail(supplierProdServDetailsDTO);
		return;
	}

	@DeleteMapping("/delSelectSupplierProdServDetails")
	public void deleteSelectSupplierProdServDetails(@RequestBody ArrayList<Long> supplierProdServDetailsSeqNoList) {
		supplierProdServDetailsServ.delSelectSupplierProdServDetails(supplierProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectSupplierAssets")
	public void delSelectSupplierAssets(@RequestBody ArrayList<Long> supplierProdServDetailsSeqNoList) {
		supplierProdServDetailsServ.delSelectSupplierAssets(supplierProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectSupplierResources")
	public void delSelectSupplierResources(@RequestBody ArrayList<Long> supplierProdServDetailsSeqNoList) {
		supplierProdServDetailsServ.delSelectSupplierResources(supplierProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectSupplierServices")
	public void delSelectSupplierServices(@RequestBody ArrayList<Long> supplierProdServDetailsSeqNoList) {
		supplierProdServDetailsServ.delSelectSupplierServices(supplierProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delAllSupplierProdServDetails")
	public void deleteAllSupplierProdServDetails() {
		supplierProdServDetailsServ.delAllSupplierProdServDetails();

		return;
	}
}