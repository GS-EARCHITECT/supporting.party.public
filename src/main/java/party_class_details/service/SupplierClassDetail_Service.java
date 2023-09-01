package party_class_details.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import party_class_details.model.dto.PartyClassDetail_DTO;
import party_class_details.model.master.PartyClassDetail;
import party_class_details.model.master.PartyClassDetailPK;
import party_class_details.model.repo.PartyClassDetails_Repo;

@Service("partyClassDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyClassDetail_Service implements I_PartyClassDetails_Service 
{

	@Autowired
	private PartyClassDetails_Repo partyClassDetailsRepo;

	public ArrayList<PartyClassDetail_DTO> getAllPartyClassDetails() 
	{
		ArrayList<PartyClassDetail> partyList = (ArrayList<PartyClassDetail>) partyClassDetailsRepo.findAll();
		ArrayList<PartyClassDetail_DTO> lDetails = new ArrayList<PartyClassDetail_DTO>();
		lDetails = partyList != null ? this.getPartyClassDetail_DTOs(partyList) : null;
		return lDetails;
	}

    
	public ArrayList<PartyClassDetail_DTO> getSelectPartiesForClasses(ArrayList<Long> ids)
    {
		ArrayList<PartyClassDetail> lDetails = partyClassDetailsRepo.getSelectPartysForClasses(ids);
		ArrayList<PartyClassDetail_DTO> partyClassDetailsDTOs = null;
		partyClassDetailsDTOs = lDetails != null ? this.getPartyClassDetail_DTOs(lDetails) : null;
		return partyClassDetailsDTOs;
	}

	public ArrayList<PartyClassDetail_DTO> getSelectPartyClassDetails(ArrayList<Long> ids)
    {
		ArrayList<PartyClassDetail> lDetails = partyClassDetailsRepo.getSelectPartyClassDetails(ids);
		ArrayList<PartyClassDetail_DTO> partyClassDetailsDTOs = null;
		partyClassDetailsDTOs = lDetails != null ? this.getPartyClassDetail_DTOs(lDetails) : null;
		return partyClassDetailsDTOs;
	}
		
	private ArrayList<PartyClassDetail_DTO> getPartyClassDetail_DTOs(ArrayList<PartyClassDetail> lDetails) 
	{
		PartyClassDetail_DTO lDTO = null;
		ArrayList<PartyClassDetail_DTO> lDetailsDTOs = new ArrayList<PartyClassDetail_DTO>();		
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getPartyClassDetail_DTO(lDetails.get(i));			
			lDetailsDTOs.add(lDTO);
		}
		return lDetailsDTOs;
	}

	private PartyClassDetail_DTO getPartyClassDetail_DTO(PartyClassDetail lDetails) 
	{		
		PartyClassDetail_DTO lDTO = new PartyClassDetail_DTO();		
		lDTO.setPartySeqNo(lDetails.getId().getPartySeqNo());
		lDTO.setPartyClassSeqNo(lDetails.getId().getPartyClassSeqNo());
		return lDTO;
	}
	
}