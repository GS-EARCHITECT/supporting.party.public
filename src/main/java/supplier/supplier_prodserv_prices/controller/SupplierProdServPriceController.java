package supplier.supplier_prodserv_prices.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supplier.supplier_prodserv_prices.model.dto.SupplierProdServPriceDTO;
import supplier.supplier_prodserv_prices.services.I_SupplierProdServPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/supplierProdServPriceManagement")
public class SupplierProdServPriceController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(SupplierProdServPrice_Controller.class);

	@Autowired
	private I_SupplierProdServPriceService supplierProdServPriceServ;

	@PostMapping("/new")
	public ResponseEntity<SupplierProdServPriceDTO> newSupplierProdServPrice(@RequestBody SupplierProdServPriceDTO SupplierProdServPriceDTO) 
	{
		SupplierProdServPriceDTO SupplierProdServPriceDTO2 = supplierProdServPriceServ.newSupplierProdServPrice(SupplierProdServPriceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(SupplierProdServPriceDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectSupplierProdServPrices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServPriceDTO>> getSelectSupplierProdServPrices(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<SupplierProdServPriceDTO> SupplierProdServPriceDTOs = supplierProdServPriceServ.getSelectSupplierProdServPrices(ids);
		return new ResponseEntity<>(SupplierProdServPriceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllSupplierProdServPrice", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServPriceDTO>> getAllSupplierProdServPrice() {
		ArrayList<SupplierProdServPriceDTO> SupplierProdServPriceDTOs = supplierProdServPriceServ.getAllSupplierProdServPrices();
		return new ResponseEntity<>(SupplierProdServPriceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSupplierProdServPricesBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SupplierProdServPriceDTO>> getSelectSupplierProdServPricesBetweenTimes(@RequestBody ArrayList<Long> ids, @PathVariable String fr, @PathVariable String to)
	{
		ArrayList<SupplierProdServPriceDTO> SupplierProdServPriceDTOs = supplierProdServPriceServ.getSelectSupplierProdServPricesBetweenTimes(ids, fr, to);
		return new ResponseEntity<>(SupplierProdServPriceDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updSupplierProdServPrice")
	public void updateSupplierProdServPrice(@RequestBody SupplierProdServPriceDTO SupplierProdServPriceDTO) {
		supplierProdServPriceServ.updSupplierProdServPrice(SupplierProdServPriceDTO);
		return;
	}

	@DeleteMapping("/delSelectSupplierProdServPrices")
	public void delSelectSupplierProdServPrices(@RequestBody ArrayList<Long> ids)
	{
		supplierProdServPriceServ.delSelectSupplierProdServPrices(ids);
	}

	@DeleteMapping("/delSelectSupplierProdServPricesBetweenTimes/{fr}/{to}")	
	public void delSelectSupplierProdServPricesBetweenTimes(@RequestBody ArrayList<Long> ids, @PathVariable String fr, @PathVariable String to) 
	{
		supplierProdServPriceServ.delSelectSupplierProdServPricesBetweenTimes(ids, fr, to);
		return;
	}

	@DeleteMapping("/delAllSupplierProdServPrice")
	public void deleteAllSupplierProdServPrice() {
		supplierProdServPriceServ.delAllSupplierProdServPrices();
		return;
	}
}