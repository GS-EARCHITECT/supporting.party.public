package enterprise.company_unit_locations.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_unit_locations.model.master.CompanyUnitLocation;

@Repository("companyUnitLocationRepo")
public interface CompanyUnitLocationsRepo extends JpaRepository<CompanyUnitLocation, Long> 
{
	@Query(value = "SELECT * FROM Company_Unit_Locations a WHERE a.company_location_SEQ_NO in :ids order by company_location_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitLocation> getSelectCompanyUnitLocations(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Unit_Locations a WHERE a.company_unit_SEQ_NO in :ids order by company_location_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitLocation> getSelectCompanyUnitLocationsForCompanyUnits(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Unit_Locations a WHERE a.company_location_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitLocations(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Unit_Locations a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitLocationsForCompanyUnits(@Param("ids") ArrayList<Long> ids);
} 

