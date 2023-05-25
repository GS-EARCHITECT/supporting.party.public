package person.controller;

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
import person.model.dto.PersonMasterDTO;
import person.services.I_PersonMasterService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/personManagement")
public class Person_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Person_Personntroller.class);

	@Autowired
	private I_PersonMasterService personMasterServ;

	
	@PostMapping("/new")
	public ResponseEntity<PersonMasterDTO> newPerson(@RequestBody PersonMasterDTO personDTO) {
		PersonMasterDTO personDTO2 = personMasterServ.newPerson(personDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(personDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllPersons", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PersonMasterDTO>> getAllPersonMasters() {
		ArrayList<PersonMasterDTO> personDTOs = personMasterServ.getAllPersons();
		//logger.info("size :"+personDTOs.size());
		return new ResponseEntity<>(personDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPersons", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PersonMasterDTO>> getSelectPersonMasters(@RequestBody ArrayList<Long> customerPersonSeqNos) {
		ArrayList<PersonMasterDTO> personDTOs = personMasterServ.getSelectPersons(customerPersonSeqNos);		
		return new ResponseEntity<>(personDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPersonsByGender/{gender}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PersonMasterDTO>> getSelectPersonsByGender(@PathVariable String gender)
	{
		ArrayList<PersonMasterDTO> personDTOs = personMasterServ.getSelectPersonsByGender(gender);		
		return new ResponseEntity<>(personDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPersonsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PersonMasterDTO>> getSelectPersonsBetweenTimes(@PathVariable String fr, @PathVariable String to)
	{
		ArrayList<PersonMasterDTO> personDTOs = personMasterServ.getSelectPersonsBetweenTimes(fr, to);		
		return new ResponseEntity<>(personDTOs, HttpStatus.OK);
	}

	@PutMapping("/updPerson")
	public void updatePerson(@RequestBody PersonMasterDTO personDTO) {
		personMasterServ.updPerson(personDTO);
	}

	@DeleteMapping("/delSelectPersons")
	public void deleteSelectPersons(@RequestBody ArrayList<Long> perSeqNoList) 
	{
		personMasterServ.delSelectPersons(perSeqNoList);
	}
	
	@DeleteMapping("/delSelectPersonsByGender/{gender}")
	public void delSelectPersonsByGender(@PathVariable String gender)
	{
		personMasterServ.delSelectPersonsByGender(gender);		
		return;
	}
	
	@DeleteMapping("/delSelectPersonsBetweenTimes/{fr}/{to}")
	public void delSelectPersonsBetweenTimes(@PathVariable String fr, @PathVariable String to)
	{
		personMasterServ.delSelectPersonsBetweenTimes(fr, to);		
		return;
	}
	
	@DeleteMapping("/delAllPersons")
	public void deleteAllPersons() {
		personMasterServ.delAllPersons();
	}
	}