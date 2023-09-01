package enterprise.company.company_structure_details.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company.company_structure_details.model.master.CompanyStructureDetail;
import enterprise.company.company_structure_details.model.master.CompanyStructureDetailPK;

@Repository("companyStructureDetailsPublicReadRepo")
public interface CompanyStructureDetailsPublicRead_Repo extends JpaRepository<CompanyStructureDetail, CompanyStructureDetailPK> 
{
	@Query(value = "SELECT * FROM Company_Structure_Details a WHERE a.company_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyStructureDetail> getSelectCompanyStructureDetails(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Structure_Details a WHERE a.company_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyStructureDetail> getAllCompanyStructureDetails();
} 

