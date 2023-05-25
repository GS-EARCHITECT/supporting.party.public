package person.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import person.model.master.PersonMaster;

@Repository("personRepo")
public interface PersonMasterRepo extends CrudRepository<PersonMaster, Long> 
{
	@Query(value = "SELECT * FROM Person_Master a WHERE (a.dob BETWEEN :frDtTm  and :toDtTm) order by a.person_SEQ_NO", nativeQuery = true)
	ArrayList<PersonMaster> getSelectPersonsBetweenTimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "SELECT * FROM Person_Master a WHERE a.person_SEQ_NO in :ids order by person_SEQ_NO", nativeQuery = true)
	ArrayList<PersonMaster> getSelectPersons(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Person_Master a WHERE upper(trim(a.gender)) = upper_trim(:gender)) order by person_SEQ_NO", nativeQuery = true)
	ArrayList<PersonMaster> getSelectPersonsByGender(@Param("gender") String gender);

	@Query(value = "DELETE FROM Person_Master a WHERE (a.dob BETWEEN :frDtTm  and :toDtTm) order by a.person_SEQ_NO", nativeQuery = true)
	void delSelectPersonsBetweenTimes(@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "DELETE FROM Person_Master a WHERE a.person_SEQ_NO in :ids order by person_SEQ_NO", nativeQuery = true)
	void delSelectPersons(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Person_Master a WHERE upper(trim(a.gender)) = upper_trim(:gender))", nativeQuery = true)
	void delSelectPersonsByGender(@Param("gender") String gender);

} 

