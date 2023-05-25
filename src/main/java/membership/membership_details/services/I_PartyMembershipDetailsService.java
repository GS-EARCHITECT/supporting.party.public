package membership.membership_details.services;

import java.util.ArrayList;
import membership.membership_details.model.dto.PartyMembershipDetailDTO;

public interface I_PartyMembershipDetailsService 
{
	abstract public PartyMembershipDetailDTO newPartyMembershipDetail(PartyMembershipDetailDTO membershipDetailDTO);

	abstract public ArrayList<PartyMembershipDetailDTO> getAllPartyMembershipDetails();

	abstract public ArrayList<PartyMembershipDetailDTO> getSelectPartyMembershipDetails(
			ArrayList<Long> membershipSeqNos);

	abstract public ArrayList<PartyMembershipDetailDTO> getSelectPartyMembershipDetailsBetweenTimes(ArrayList<Long> ids,
			String frDtTm, String toDtTm);

	abstract public void updPartyMembershipDetail(PartyMembershipDetailDTO membershipDTO);

	abstract public void delAllPartyMembershipDetails();

	abstract public void delSelectPartyMembershipDetails(ArrayList<Long> membershipSeqNos);

	abstract void delSelectPartyMembershipDetailsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);

}