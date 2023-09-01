package party_class_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import party_class_details.model.master.PartyClassDetail;
import party_class_details.model.master.PartyClassDetailPK;

@Repository("partyClassDetailsRepo")
public interface PartyClassDetails_Repo extends CrudRepository<PartyClassDetail, PartyClassDetailPK> 
{
	@Query(value = "SELECT * FROM PARTY_CLASS_DETAILS a WHERE (a.party_seq_no in :ids) order by party_seq_no", nativeQuery = true)
	ArrayList<PartyClassDetail> getSelectPartyClassDetails(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM PARTY_CLASS_DETAILS a WHERE (a.party_class_seq_no in :ids) order by party_seq_no", nativeQuery = true)
	ArrayList<PartyClassDetail> getSelectPartysForClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PARTY_CLASS_DETAILS WHERE (a.party_seq_no in :ids)", nativeQuery = true)
	void delSelectPartyClassDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PARTY_CLASS_DETAILS a WHERE (a.party_class_seq_no in :ids)", nativeQuery = true)
	void delSelectPartysForClasses(@Param("ids") ArrayList<Long> ids);
	
}
