package membership.membership_details.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import membership.membership_details.model.master.PartyMembershipDetail;
import membership.membership_details.model.master.PartyMembershipDetailPK;

@Repository("partyMembershipDetailsRepo")
public interface PartyMembershipDetailsRepo extends JpaRepository<PartyMembershipDetail, PartyMembershipDetailPK>
{

	@Query(value = "SELECT * FROM Party_MembershipDetails_Details a WHERE (a.membership_SEQ_NO in :ids) and (a.on_DTTM BETWEEN :frDtTm  and :toDtTm) order by a.membership_SEQ_NO", nativeQuery = true)
	ArrayList<PartyMembershipDetail> getSelectPartyMembershipDetailsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

	@Query(value = "SELECT * FROM Party_MembershipDetails_Details a WHERE a.membership_SEQ_NO in :ids order by membership_SEQ_NO", nativeQuery = true)
	ArrayList<PartyMembershipDetail> getSelectPartyMembershipDetails(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Party_MembershipDetails_Details a WHERE (a.membership_SEQ_NO in :ids) and (a.on_DTTM BETWEEN :frDtTm  and :toDtTm)", nativeQuery = true)
	void delSelectPartyMembershipBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

	@Query(value = "SELECT * FROM Party_MembershipDetails_Details a WHERE a.membership_SEQ_NO in :ids", nativeQuery = true)
	void delSelectPartyMembershipDetails(@Param("ids") ArrayList<Long> ids);

}
