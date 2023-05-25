package enterprise.company_units.details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company_units.details.model.master.CompanyUnitDetail;
import enterprise.company_units.details.model.master.CompanyUnitDetailPK;

@Repository("companyUnitDetailsRepo")
public interface CompanyUnitDetailsRepo extends CrudRepository<CompanyUnitDetail, CompanyUnitDetailPK> 
{
	@Query(value = "SELECT * FROM Company_Unit_Details a WHERE (a.company_unit_SEQ_NO in :ids and a.par_company_unit_SEQ_NO in :ids) order by company_unit_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitDetail> getSelectCompanyUnitDetails(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM Company_Unit_Details a WHERE a.par_company_unit_SEQ_NO in :ids order by company_unit_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitDetail> getSelectCompanyUnitDetailsByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Unit_Details a WHERE (a.company_unit_SEQ_NO in :ids and a.par_company_unit_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyUnitDetails(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);
	
	@Query(value = "DELETE FROM Company_Unit_Details a WHERE (a.company_unit_SEQ_NO in :ids and a.par_company_unit_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyUnitDetailsByParents(@Param("ids") ArrayList<Long> ids);
} 

