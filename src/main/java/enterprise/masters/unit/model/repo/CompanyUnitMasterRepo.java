package enterprise.masters.unit.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.masters.unit.model.master.CompanyUnitMaster;

@Repository("unitRepo")
public interface CompanyUnitMasterRepo extends JpaRepository<CompanyUnitMaster, Long> 
{

	@Query(value = "SELECT * FROM Company_Unit_Master a WHERE a.unit_SEQ_NO in :ids order by unit_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitMaster> getSelectUnits(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Company_Unit_Master a WHERE a.unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectUnits(@Param("ids") ArrayList<Long> ids);
}
