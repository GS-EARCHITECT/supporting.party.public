package enterprise.company_units.master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company_units.master.model.master.CompanyUnit;

@Repository("companyUnitRepo")
public interface CompanyUnitRepo extends CrudRepository<CompanyUnit, Long> 
{
	@Query(value = "SELECT * FROM Company_Units a WHERE a.company_unit_SEQ_NO in :ids order by company_unit_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnit> getSelectCompanyUnits(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Units a WHERE a.unit_SEQ_NO in :ids order by company_unit_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnit> getSelectCompanyUnitsForUnitTypes(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Units a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnits(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Units a WHERE a.unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitsForUnitTypes(@Param("ids") ArrayList<Long> ids);
} 

