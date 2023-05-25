package enterprise.company_unit_functions.details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_unit_functions.details.model.master.CompanyUnitFunctionDetail;
import enterprise.company_unit_functions.details.model.master.CompanyUnitFunctionDetailPK;

@Repository("companyUnitFunctionDetailsRepo")
public interface CompanyUnitFunctionsDetailsRepo extends JpaRepository<CompanyUnitFunctionDetail, CompanyUnitFunctionDetailPK> 
{
	@Query(value = "SELECT * FROM Company_unit_functions_Details a WHERE (a.company_function_SEQ_NO in :ids and a.par_company_SEQ_NO in :ids) order by company_Function_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitFunctionDetail> getSelectCompanyFunctionDetails(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM Company_unit_functions_Details a WHERE a.par_company_Function_SEQ_NO in :ids order by company_Function_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitFunctionDetail> getSelectCompanyFunctionDetailsByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_unit_functions_Details a WHERE (a.company_Function_SEQ_NO in :ids and a.par_company_Function_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyFunctionDetails(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);
	
	@Query(value = "DELETE FROM Company_unit_functions_Details a WHERE (a.company_Function_SEQ_NO in :ids and a.par_company_Function_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyFunctionDetailsByParents(@Param("ids") ArrayList<Long> ids);
} 

