package membership.membership_details.controller;

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
import membership.membership_details.model.dto.PartyMembershipDetailDTO;
import membership.membership_details.services.I_PartyMembershipDetailsService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyMembershipDetails")
public class PartyMembershipDetails_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(PartyMembership_PartyMembership_Cuntroller.class);

	@Autowired
	private I_PartyMembershipDetailsService partyMembershipDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<PartyMembershipDetailDTO> newPartyMembershipDetail(@RequestBody PartyMembershipDetailDTO partyMembershipDTO) {
		PartyMembershipDetailDTO partyMembershipDTO2 = partyMembershipDetailsServ.newPartyMembershipDetail(partyMembershipDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(partyMembershipDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllPartyMembershipDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipDetailDTO>> getAllPartyMembershipDetailss() 
	{
		ArrayList<PartyMembershipDetailDTO> partyMembershipDTOs = partyMembershipDetailsServ.getAllPartyMembershipDetails();
		//logger.info("size :"+partyMembershipDTOs.size());
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPartyMembershipDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipDetailDTO>> getSelectPartyMembershipDetails(@RequestBody ArrayList<Long> partyMembershipCuSeqNos) {
		ArrayList<PartyMembershipDetailDTO> partyMembershipDTOs = partyMembershipDetailsServ.getSelectPartyMembershipDetails(partyMembershipCuSeqNos);		
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPartyMembershipDetailsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipDetailDTO>> getSelectPartyMembershipDetailsBetweenTimes(@RequestBody ArrayList<Long> partyMembershipCuSeqNos, @PathVariable String fr, @PathVariable String to)
	{
		ArrayList<PartyMembershipDetailDTO> partyMembershipDTOs = partyMembershipDetailsServ.getSelectPartyMembershipDetailsBetweenTimes(partyMembershipCuSeqNos, fr, to);		
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updPartyMembershipDetail")
	public void updatePartyMembershipDetail(@RequestBody PartyMembershipDetailDTO partyMembershipDTO) {
		partyMembershipDetailsServ.updPartyMembershipDetail(partyMembershipDTO);
	}

	
	@DeleteMapping("/delSelectPartyMembershipDetails")
	public void deleteSelectPartyMembershipDetails(@RequestBody ArrayList<Long> coSeqNoList) {
		partyMembershipDetailsServ.delSelectPartyMembershipDetails(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectPartyMembershipDetailsBetweenTimes/{fr}/{to}")
	public void delSelectPartyMembershipDetailsBetweenTimes(@RequestBody ArrayList<Long> partyMembershipCuSeqNos, @PathVariable String fr, @PathVariable String to)
	{
		partyMembershipDetailsServ.delSelectPartyMembershipDetailsBetweenTimes(partyMembershipCuSeqNos, fr, to);		
		return;
	}
	
	@DeleteMapping("/delAllPartyMembershipDetails")
	public void deleteAllPartyMembershipDetails() {
		partyMembershipDetailsServ.delAllPartyMembershipDetails();
	}
	}