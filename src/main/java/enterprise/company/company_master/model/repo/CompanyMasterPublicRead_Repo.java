package enterprise.company.company_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company.company_master.model.master.CompanyMaster;

@Repository("companyPublicReadRepo")
public interface CompanyMasterPublicRead_Repo extends JpaRepository<CompanyMaster, Long> 
{
	@Query(value = "SELECT * FROM Company_Master order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyMaster> getAllCompanies();
	
	@Query(value = "SELECT * FROM Company_Master a WHERE a.company_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyMaster> getSelectCompanies(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Master a WHERE a.party_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyMaster> getSelectCompaniesForParties(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
} 

