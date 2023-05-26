package enterprise.company_unit_roles.master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company_unit_roles.master.model.master.CompanyUnitRole;

@Repository("companyUnitRoleRepo")
public interface CompanyUnitRolesRepo extends CrudRepository<CompanyUnitRole, Long> 
{
	@Query(value = "SELECT * FROM Company_Unit_Roles a WHERE a.company_role_SEQ_NO in :ids order by company_role_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitRole> getSelectCompanyUnitRoles(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Unit_Roles a WHERE a.company_unit_SEQ_NO in :ids order by company_role_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitRole> getSelectCompanyUnitRolesForCompanyUnits(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Unit_Roles a WHERE a.company_role_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitRoles(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Unit_Roles a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitRolesForCompanyUnits(@Param("ids") ArrayList<Long> ids);
} 

