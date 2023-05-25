package membership.membership_master.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import membership.membership_master.model.dto.PartyMembershipMasterDTO;
import membership.membership_master.model.master.PartyMembershipMaster;
import membership.membership_master.model.repo.PartyMembershipMasterRepo;

@Service("partyMembershipServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyMembershipMasterService implements I_PartyMembershipMasterService {
	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyMembershipMasterService.class);

	@Autowired
	private PartyMembershipMasterRepo partyMembershipRepo;

	public PartyMembershipMasterDTO newPartyMembership(PartyMembershipMasterDTO cDTO) {
		if (!partyMembershipRepo.existsById(cDTO.getMembershipSeqNo())) {
			PartyMembershipMaster partyMembershipMaster = partyMembershipRepo.save(this.setPartyMembershipMaster(cDTO));
			cDTO = getPartyMembershipMasterDTO(partyMembershipMaster);
		}
		return cDTO;
	}

	public ArrayList<PartyMembershipMasterDTO> getAllPartyMemberships() {
		ArrayList<PartyMembershipMaster> partyMembershipList = (ArrayList<PartyMembershipMaster>) partyMembershipRepo
				.findAll();
		ArrayList<PartyMembershipMasterDTO> cDTOs = new ArrayList<PartyMembershipMasterDTO>();
		cDTOs = partyMembershipList != null ? this.getPartyMembershipMasterDtos(partyMembershipList) : null;
		return cDTOs;
	}

	public ArrayList<PartyMembershipMasterDTO> getSelectPartyMemberships(ArrayList<Long> partyMembershipSeqNos) {

		ArrayList<PartyMembershipMaster> partyMembershipList = (ArrayList<PartyMembershipMaster>) partyMembershipRepo
				.getSelectPartyMemberships(partyMembershipSeqNos);
		ArrayList<PartyMembershipMasterDTO> cDTOs = new ArrayList<PartyMembershipMasterDTO>();
		cDTOs = partyMembershipList != null ? this.getPartyMembershipMasterDtos(partyMembershipList) : null;
		return cDTOs;
	}

	public ArrayList<PartyMembershipMasterDTO> getSelectPartyMembershipsBetweenTimes(ArrayList<Long> ids, String frDtTm,
			String toDtTm) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		ArrayList<PartyMembershipMaster> partyMembershipMasters = partyMembershipRepo
				.getSelectPartyMembershipBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		ArrayList<PartyMembershipMasterDTO> partyMembershipDTOs = partyMembershipMasters != null
				? this.getPartyMembershipMasterDtos(partyMembershipMasters)
				: null;
		return partyMembershipDTOs;

	}

	public ArrayList<PartyMembershipMasterDTO> getSelectMembershipsForParties(ArrayList<Long> partyMembershipSeqNos) {

		ArrayList<PartyMembershipMaster> partyMembershipList = (ArrayList<PartyMembershipMaster>) partyMembershipRepo
				.getSelectMembershipsForParties(partyMembershipSeqNos);
		ArrayList<PartyMembershipMasterDTO> cDTOs = new ArrayList<PartyMembershipMasterDTO>();
		cDTOs = partyMembershipList != null ? this.getPartyMembershipMasterDtos(partyMembershipList) : null;
		return cDTOs;
	}

	public ArrayList<PartyMembershipMasterDTO> getSelectMembershipsOfParties(ArrayList<Long> partyMembershipSeqNos) {

		ArrayList<PartyMembershipMaster> partyMembershipList = (ArrayList<PartyMembershipMaster>) partyMembershipRepo
				.getSelectMembershipsOfParties(partyMembershipSeqNos);
		ArrayList<PartyMembershipMasterDTO> cDTOs = new ArrayList<PartyMembershipMasterDTO>();
		cDTOs = partyMembershipList != null ? this.getPartyMembershipMasterDtos(partyMembershipList) : null;
		return cDTOs;
	}

	public void updPartyMembership(PartyMembershipMasterDTO cDTO) {

		PartyMembershipMaster partyMembershipMaster = this.setPartyMembershipMaster(cDTO);
		if (partyMembershipRepo.existsById(cDTO.getMembershipSeqNo())) {
			partyMembershipMaster.setMembershipSeqNo(cDTO.getMembershipSeqNo());
			partyMembershipRepo.save(partyMembershipMaster);
		}
	}

	public void delAllPartyMemberships() 
	{
		partyMembershipRepo.deleteAll();
	}

	public void delSelectMembershipsForParties(ArrayList<Long> partyMembershipSeqNos) 
	{
		partyMembershipRepo.delSelectMembershipsForParties(partyMembershipSeqNos);
	
	}
	
	public void delSelectMembershipsOfParties(ArrayList<Long> partyMembershipSeqNos) 
	{
		partyMembershipRepo.delSelectMembershipsOfParties(partyMembershipSeqNos);
	
	}

	public void delSelectPartyMemberships(ArrayList<Long> partyMembershipSeqNos) 
	{
		partyMembershipRepo.delSelectPartyMemberships(partyMembershipSeqNos);
	
	}
	
	public void delSelectPartyMembershipsBetweenTimes(ArrayList<Long> ids, String frDtTm,String toDtTm) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		partyMembershipRepo.delSelectPartyMembershipBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
	
	}
	
	private ArrayList<PartyMembershipMasterDTO> getPartyMembershipMasterDtos(
			ArrayList<PartyMembershipMaster> cMasters) {
		PartyMembershipMasterDTO cDTO = null;
		ArrayList<PartyMembershipMasterDTO> cDTOs = new ArrayList<PartyMembershipMasterDTO>();

		for (int i = 0; i < cMasters.size(); i++) {
			cDTO = this.getPartyMembershipMasterDTO(cMasters.get(i));			
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private PartyMembershipMasterDTO getPartyMembershipMasterDTO(PartyMembershipMaster cMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		PartyMembershipMasterDTO lDTO = new PartyMembershipMasterDTO();
		lDTO.setFrDtTm(formatter.format(cMaster.getFrDtTm().toLocalDateTime()));
		lDTO.setToDtTm(formatter.format(cMaster.getToDtTm().toLocalDateTime()));
		lDTO.setMembershipId(cMaster.getMembershipId());
		lDTO.setMembershipSeqNo(cMaster.getMembershipSeqNo());
		lDTO.setMembershipOfSeqNo(cMaster.getMembershipOfSeqNo());
		lDTO.setMembershipForSeqNo(cMaster.getMembershipForSeqNo());	
		lDTO.setRemark(cMaster.getRemark());
		lDTO.setStatus(cMaster.getStatus());
		return lDTO;
	}

	private PartyMembershipMaster setPartyMembershipMaster(PartyMembershipMasterDTO lDTO) 
	{
		PartyMembershipMaster cMaster = new PartyMembershipMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(lDTO.getFrDtTm(), formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(lDTO.getToDtTm(), formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);		
		cMaster.setFrDtTm(toTsTimestamp);
		cMaster.setToDtTm(toTsTimestamp);
		cMaster.setMembershipId(cMaster.getMembershipId());
		cMaster.setMembershipOfSeqNo(cMaster.getMembershipOfSeqNo());
		cMaster.setMembershipForSeqNo(cMaster.getMembershipForSeqNo());	
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setStatus(cMaster.getStatus());
		return cMaster;
	}

}