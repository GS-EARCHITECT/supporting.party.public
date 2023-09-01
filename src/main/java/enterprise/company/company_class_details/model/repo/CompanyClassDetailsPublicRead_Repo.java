package enterprise.company.company_class_details.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company.company_class_details.model.master.CompanyClassDetail;
import enterprise.company.company_class_details.model.master.CompanyClassDetailPK;

@Repository("companyClassDetailsPublicReadRepo")
public interface CompanyClassDetailsPublicRead_Repo extends JpaRepository<CompanyClassDetail, CompanyClassDetailPK> 
{
	@Query(value = "SELECT * FROM Company_Class_Details a WHERE a.company_class_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyClassDetail> getSelectCompanyClassDetailsByClasses(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Class_Details a WHERE a.company_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyClassDetail> getSelectCompanyClassDetailsByCompanies(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Class_Details a order by company_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyClassDetail> getAllCompanyClassDetails();

	
} 

