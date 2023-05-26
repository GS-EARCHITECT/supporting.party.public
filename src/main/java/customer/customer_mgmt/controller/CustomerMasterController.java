package customer.customer_mgmt.controller;

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

import customer.customer_mgmt.model.dto.CustomerMasterDTO;
import customer.customer_mgmt.services.I_CustomerMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/customersManagement")
public class CustomerMasterController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Customers_Controller.class);

	@Autowired
	private I_CustomerMasterService customerMasterServ;

	@PostMapping("/new")
	public ResponseEntity<CustomerMasterDTO> newCustomers(@RequestBody CustomerMasterDTO CustomerMasterDTO) 
	{
		CustomerMasterDTO CustomerMasterDTO2 = customerMasterServ.newCustomer(CustomerMasterDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(CustomerMasterDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectCustomers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CustomerMasterDTO>> getSelectCustomers(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<CustomerMasterDTO> CustomerMasterDTOs = customerMasterServ.getSelectCustomers(ids);
		return new ResponseEntity<>(CustomerMasterDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllCustomers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CustomerMasterDTO>> getAllCustomerss() {
		ArrayList<CustomerMasterDTO> CustomerMasterDTOs = customerMasterServ.getAllCustomers();
		return new ResponseEntity<>(CustomerMasterDTOs, HttpStatus.OK);
	}

	
	@PutMapping("/updCustomers")
	public void updateCustomers(@RequestBody CustomerMasterDTO CustomerMasterDTO) {
		customerMasterServ.updCustomer(CustomerMasterDTO);
		return;
	}

	@DeleteMapping("/delSelectCustomers")	
	public void deleteSelectCustomers(@RequestBody ArrayList<Long> CustomersSeqNoList) {
		customerMasterServ.getSelectCustomers(CustomersSeqNoList);
		return;
	}

	@DeleteMapping("/delAllCustomers")
	public void deleteAllCustomers() {
		customerMasterServ.delAllCustomers();
		return;
	}
}