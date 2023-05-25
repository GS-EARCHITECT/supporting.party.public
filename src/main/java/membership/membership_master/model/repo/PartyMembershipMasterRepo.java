package membership.membership_master.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import membership.membership_master.model.master.PartyMembershipMaster;

@Repository("partyMembershipRepo")
public interface PartyMembershipMasterRepo extends JpaRepository<PartyMembershipMaster, Long> {

	@Query(value = "SELECT * FROM Party_Memberships_Masters a WHERE ((a.membership_SEQ_NO in :ids) and ((a.FR_DTTM BETWEEN :frDtTm  and :toDtTm) and (a.TO_DTTM BETWEEN :frDtTm  and :toDtTm)) order by a.membership_SEQ_NO", nativeQuery = true)
	ArrayList<PartyMembershipMaster> getSelectPartyMembershipBetweenTimes(@Param("ids") ArrayList<Long> ids,
			@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

	@Query(value = "SELECT * FROM Party_Memberships_Masters a WHERE a.membership_SEQ_NO in :ids order by membership_SEQ_NO", nativeQuery = true)
	ArrayList<PartyMembershipMaster> getSelectPartyMemberships(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Party_Memberships_Masters a WHERE a.PARTY_SEQ_NO in :ids order by membership_SEQ_NO", nativeQuery = true)
	ArrayList<PartyMembershipMaster> getSelectMembershipsForParties(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Party_Memberships_Masters a WHERE a.PARTY_OF_SEQ_NO in :ids order by membership_SEQ_NO", nativeQuery = true)
	ArrayList<PartyMembershipMaster> getSelectMembershipsOfParties(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Party_Memberships_Masters a WHERE ((a.membership_SEQ_NO in :ids) and ((a.FR_DTTM BETWEEN :frDtTm  and :toDtTm) and (a.TO_DTTM BETWEEN :frDtTm  and :toDtTm))", nativeQuery = true)
	void delSelectPartyMembershipBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm,
			@Param("toDtTm") Timestamp toDtTm);

	@Query(value = "SELECT * FROM Party_Memberships_Masters a WHERE a.membership_SEQ_NO in :ids", nativeQuery = true)
	void delSelectPartyMemberships(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Party_Memberships_Masters a WHERE a.PARTY_SEQ_NO in :ids", nativeQuery = true)
	void delSelectMembershipsForParties(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Party_Memberships_Masters a WHERE a.PARTY_OF_SEQ_NO in :ids", nativeQuery = true)
	void delSelectMembershipsOfParties(@Param("ids") ArrayList<Long> ids);

}
