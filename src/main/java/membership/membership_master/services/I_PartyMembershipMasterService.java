package membership.membership_master.services;

import java.util.ArrayList;
import membership.membership_master.model.dto.PartyMembershipMasterDTO;

public interface I_PartyMembershipMasterService
{
    abstract public PartyMembershipMasterDTO newPartyMembership(PartyMembershipMasterDTO membershipDTO);
    abstract public ArrayList<PartyMembershipMasterDTO> getAllPartyMemberships();
    abstract public ArrayList<PartyMembershipMasterDTO> getSelectPartyMemberships(ArrayList<Long> membershipSeqNos);
    abstract public ArrayList<PartyMembershipMasterDTO> getSelectPartyMembershipsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
    abstract public ArrayList<PartyMembershipMasterDTO> getSelectMembershipsForParties(ArrayList<Long> ids);
    abstract public ArrayList<PartyMembershipMasterDTO> getSelectMembershipsOfParties(ArrayList<Long> ids);
    abstract public void updPartyMembership(PartyMembershipMasterDTO membershipDTO);
    abstract public void delAllPartyMemberships();
    abstract public void delSelectPartyMemberships(ArrayList<Long> membershipSeqNos);
    abstract void delSelectPartyMembershipsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
    abstract void delSelectMembershipsForParties(ArrayList<Long> ids);
    abstract void delSelectMembershipsOfParties(ArrayList<Long> ids);

}