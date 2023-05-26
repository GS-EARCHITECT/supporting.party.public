package customer.customer_prodservcs.controller;

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

import customer.customer_prodservcs.model.dto.CustomerProdServDetailsDTO;
import customer.customer_prodservcs.services.I_CustomerProdServDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/customerProdServDetailsManagement")
public class CustomerProdServDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(CustomerProdServDetails_Controller.class);

	@Autowired
	private I_CustomerProdServDetailsService customerProdServDetailsServ;

	@PostMapping("/new")
	public ResponseEntity<CustomerProdServDetailsDTO> newCustomerProdServDetail(
			@RequestBody CustomerProdServDetailsDTO CustomerProdServDetailsDTO) {
		CustomerProdServDetailsDTO CustomerProdServDetailsDTO2 = customerProdServDetailsServ
				.newCustomerProdServDetail(CustomerProdServDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(CustomerProdServDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectCustomerProdServDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CustomerProdServDetailsDTO>> getSelectCustomerProdServDetails(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetailsDTO> CustomerProdServDetailsDTOs = customerProdServDetailsServ
				.getSelectCustomerProdServDetails(ids);
		return new ResponseEntity<>(CustomerProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCustomerAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CustomerProdServDetailsDTO>> getSelectCustomerAssets(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetailsDTO> CustomerProdServDetailsDTOs = customerProdServDetailsServ
				.getSelectCustomerAssets(ids);
		return new ResponseEntity<>(CustomerProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCustomerResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CustomerProdServDetailsDTO>> getSelectCustomerResources(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetailsDTO> CustomerProdServDetailsDTOs = customerProdServDetailsServ
				.getSelectCustomerResources(ids);
		return new ResponseEntity<>(CustomerProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCustomerServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CustomerProdServDetailsDTO>> getSelectCustomerServices(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetailsDTO> CustomerProdServDetailsDTOs = customerProdServDetailsServ
				.getSelectCustomerServices(ids);
		return new ResponseEntity<>(CustomerProdServDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllCustomerProdServDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CustomerProdServDetailsDTO>> getAllCustomerProdServDetails() {
		ArrayList<CustomerProdServDetailsDTO> CustomerProdServDetailsDTOs = customerProdServDetailsServ
				.getAllCustomerProdServDetails();
		return new ResponseEntity<>(CustomerProdServDetailsDTOs, HttpStatus.OK);
	}

	@PutMapping("/updCustomerProdServDetails")
	public void updateCustomerProdServDetails(@RequestBody CustomerProdServDetailsDTO customerProdServDetailsDTO) {
		customerProdServDetailsServ.updCustomerProdServDetail(customerProdServDetailsDTO);
		return;
	}

	@DeleteMapping("/delSelectCustomerProdServDetails")
	public void deleteSelectCustomerProdServDetails(@RequestBody ArrayList<Long> customerProdServDetailsSeqNoList) {
		customerProdServDetailsServ.delSelectCustomerProdServDetails(customerProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectCustomerAssets")
	public void delSelectCustomerAssets(@RequestBody ArrayList<Long> customerProdServDetailsSeqNoList) {
		customerProdServDetailsServ.delSelectCustomerAssets(customerProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectCustomerResources")
	public void delSelectCustomerResources(@RequestBody ArrayList<Long> customerProdServDetailsSeqNoList) {
		customerProdServDetailsServ.delSelectCustomerResources(customerProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectCustomerServices")
	public void delSelectCustomerServices(@RequestBody ArrayList<Long> customerProdServDetailsSeqNoList) {
		customerProdServDetailsServ.delSelectCustomerServices(customerProdServDetailsSeqNoList);
		return;
	}

	@DeleteMapping("/delAllCustomerProdServDetails")
	public void deleteAllCustomerProdServDetails() {
		customerProdServDetailsServ.delAllCustomerProdServDetails();

		return;
	}
}