package enterprise.company_unit_class_structure.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_unit_class_structure.model.master.CompanyUnitClassStructure;
import enterprise.company_unit_class_structure.model.master.CompanyUnitClassStructurePK;

@Repository("companyClassStructureRepo")
public interface CompanyUnitClassStructure_Repo extends CrudRepository<CompanyUnitClassStructure, CompanyUnitClassStructurePK> 
{
	@Query(value = "SELECT * FROM Company_Unit_Class_Structure a WHERE a.company_unit_SEQ_NO in :ids order by company_SEQ_NO, unit_class_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitClassStructure> getSelectCompanyUnitClassStructures(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Unit_Class_Structure a WHERE (a.company_SEQ_NO in :ids and a.par_unit_class_SEQ_NO in :pids) order by company_SEQ_NO, unit_class_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitClassStructure> getSelectCompanyUnitClassStructuresForParentClasses(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);
	
	@Query(value = "SELECT * FROM Company_Unit_Class_Structure a WHERE (a.company_SEQ_NO in :ids and a.unit_class_SEQ_NO in :cids) order by company_SEQ_NO, unit_class_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitClassStructure> getSelectCompanyUnitClassStructuresForChildClasses(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
		
	@Query(value = "delete FROM Company_Unit_Class_Structure a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitClassStructures(@Param("ids") ArrayList<Long> ids);

	@Query(value = "delete FROM Company_Unit_Class_Structure a WHERE (a.company_SEQ_NO in :ids and a.par_unit_class_SEQ_NO in :pids)", nativeQuery = true)
	void delSelectCompanyUnitClassStructuresForParentClasses(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);
	
	@Query(value = "delete FROM Company_Unit_Class_Structure a WHERE (a.company_SEQ_NO in :ids and a.unit_class_SEQ_NO in :cids)", nativeQuery = true)
	void delSelectCompanyUnitClassStructuresForChildClasses(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
}

