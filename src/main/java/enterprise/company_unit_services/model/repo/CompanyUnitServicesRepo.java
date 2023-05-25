package enterprise.company_unit_services.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_unit_services.model.master.CompanyUnitServiceMaster;

@Repository("companyUnitServiceRepo")
public interface CompanyUnitServicesRepo extends CrudRepository<CompanyUnitServiceMaster, Long> 
{
	@Query(value = "SELECT * FROM Company_Unit_Services a WHERE a.company_service_SEQ_NO in :ids order by company_service_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitServiceMaster> getSelectCompanyUnitServices(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Unit_Services a WHERE a.company_unit_SEQ_NO in :ids order by company_service_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitServiceMaster> getSelectCompanyUnitServicesForCompanyUnits(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Unit_Services a WHERE a.company_service_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitServices(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Unit_Services a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitServicesForCompanyUnits(@Param("ids") ArrayList<Long> ids);
} 

