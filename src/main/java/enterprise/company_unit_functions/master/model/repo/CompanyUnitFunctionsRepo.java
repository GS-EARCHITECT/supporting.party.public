package enterprise.company_unit_functions.master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company_unit_functions.master.model.master.CompanyUnitFunction;

@Repository("companyUnitFunctionRepo")
public interface CompanyUnitFunctionsRepo extends CrudRepository<CompanyUnitFunction, Long> 
{
	@Query(value = "SELECT * FROM Company_Unit_Functions a WHERE a.company_function_SEQ_NO in :ids order by company_function_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitFunction> getSelectCompanyUnitFunctions(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Unit_Functions a WHERE a.company_unit_SEQ_NO in :ids order by company_function_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitFunction> getSelectCompanyUnitFunctionsForCompanyUnits(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Unit_Functions a WHERE a.company_function_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitFunctions(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Unit_Functions a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitFunctionsForCompanyUnits(@Param("ids") ArrayList<Long> ids);
} 

