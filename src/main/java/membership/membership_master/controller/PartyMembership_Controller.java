package membership.membership_master.controller;

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

import membership.membership_master.model.dto.PartyMembershipMasterDTO;
import membership.membership_master.services.I_PartyMembershipMasterService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyMembership")
public class PartyMembership_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(PartyMembership_PartyMembership_Cuntroller.class);

	@Autowired
	private I_PartyMembershipMasterService partyMembershipServ;
	
	@PostMapping("/new")
	public ResponseEntity<PartyMembershipMasterDTO> newPartyMembership(@RequestBody PartyMembershipMasterDTO partyMembershipDTO) {
		PartyMembershipMasterDTO partyMembershipDTO2 = partyMembershipServ.newPartyMembership(partyMembershipDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(partyMembershipDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllPartyMemberships", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipMasterDTO>> getAllPartyMembershipMasters() 
	{
		ArrayList<PartyMembershipMasterDTO> partyMembershipDTOs = partyMembershipServ.getAllPartyMemberships();
		//logger.info("size :"+partyMembershipDTOs.size());
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPartyMemberships", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipMasterDTO>> getSelectPartyMemberships(@RequestBody ArrayList<Long> partyMembershipCuSeqNos) {
		ArrayList<PartyMembershipMasterDTO> partyMembershipDTOs = partyMembershipServ.getSelectPartyMemberships(partyMembershipCuSeqNos);		
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPartyMembershipsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipMasterDTO>> getSelectPartyMembershipsBetweenTimes(@RequestBody ArrayList<Long> partyMembershipCuSeqNos, @PathVariable String fr, @PathVariable String to)
	{
		ArrayList<PartyMembershipMasterDTO> partyMembershipDTOs = partyMembershipServ.getSelectPartyMembershipsBetweenTimes(partyMembershipCuSeqNos, fr, to);		
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectMembershipsForParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipMasterDTO>> getSelectMembershipsForParties(@RequestBody ArrayList<Long> partyMembershipCuSeqNos) {
		ArrayList<PartyMembershipMasterDTO> partyMembershipDTOs = partyMembershipServ.getSelectMembershipsForParties(partyMembershipCuSeqNos);		
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectMembershipsOfParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMembershipMasterDTO>> getSelectMembershipsOfParties(@RequestBody ArrayList<Long> partyMembershipCuSeqNos) {
		ArrayList<PartyMembershipMasterDTO> partyMembershipDTOs = partyMembershipServ.getSelectMembershipsOfParties(partyMembershipCuSeqNos);		
		return new ResponseEntity<>(partyMembershipDTOs, HttpStatus.OK);
	}
	

	@PutMapping("/updPartyMembership")
	public void updatePartyMembership(@RequestBody PartyMembershipMasterDTO partyMembershipDTO) {
		partyMembershipServ.updPartyMembership(partyMembershipDTO);
	}

	
	@DeleteMapping("/delSelectPartyMemberships")
	public void deleteSelectPartyMemberships(@RequestBody ArrayList<Long> coSeqNoList) {
		partyMembershipServ.delSelectPartyMemberships(coSeqNoList);
	}
	
	@GetMapping(value = "/delSelectPartyMembershipsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void delSelectPartyMembershipsBetweenTimes(@RequestBody ArrayList<Long> partyMembershipCuSeqNos, @PathVariable String fr, @PathVariable String to)
	{
		partyMembershipServ.delSelectPartyMembershipsBetweenTimes(partyMembershipCuSeqNos, fr, to);		
		return;
	}
	
	@GetMapping(value = "/delSelectMembershipsForParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void delSelectMembershipsForParties(@RequestBody ArrayList<Long> partyMembershipCuSeqNos) {
		partyMembershipServ.delSelectMembershipsForParties(partyMembershipCuSeqNos);		
		return;
	}
	
	@GetMapping(value = "/delSelectMembershipsOfParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void delSelectMembershipsOfParties(@RequestBody ArrayList<Long> partyMembershipCuSeqNos) 
	{
		partyMembershipServ.delSelectMembershipsOfParties(partyMembershipCuSeqNos);		
		return;
	}

	
	@DeleteMapping("/delAllPartyMemberships")
	public void deleteAllPartyMemberships() {
		partyMembershipServ.delAllPartyMemberships();
	}
	}