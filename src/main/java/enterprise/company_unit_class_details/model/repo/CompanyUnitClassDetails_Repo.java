package enterprise.company_unit_class_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company_unit_class_details.model.master.CompanyUnitClassDetail;
import enterprise.company_unit_class_details.model.master.CompanyUnitClassDetailPK;

@Repository("companyUnitClassDetailsRepo")
public interface CompanyUnitClassDetails_Repo extends CrudRepository<CompanyUnitClassDetail, CompanyUnitClassDetailPK> 
{
	@Query(value = "SELECT * FROM Company_Unit_Class_Details a WHERE a.company_unit_SEQ_NO in :ids order by company_unit_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitClassDetail> getSelectCompanyUnitClassDetails(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Unit_Class_Details a WHERE (a.company_unit_SEQ_NO in :ids and a.par_company_unit_SEQ_NO in :pids) order by company_unit_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitClassDetail> getSelectCompanyUnitClassDetailsForChildClasses(@Param("ids") ArrayList<Long> ids, @Param("ids") ArrayList<Long> pids);
	
	@Query(value = "DELETE FROM Company_Unit_Class_Details a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitClassDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Unit_Class_Details a WHERE (a.company_unit_SEQ_NO in :ids and a.par_company_unit_SEQ_NO in :pids)", nativeQuery = true)
	void delSelectCompanyUnitClassDetailsForChildClasses(@Param("ids") ArrayList<Long> ids, @Param("ids") ArrayList<Long> pids);
} 

