package enterprise.company.company_class_details.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company.company_class_details.model.dto.CompanyClassDetail_DTO;
import enterprise.company.company_class_details.model.master.CompanyClassDetail;
import enterprise.company.company_class_details.model.master.CompanyClassDetailPK;
import enterprise.company.company_class_details.model.repo.CompanyClassDetailsPublicRead_Repo;
import enterprise.company_class.model.dto.CompanyClassMaster_DTO;

@Service("companyClassDetailPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyClassDetailsPublicRead_Service implements I_CompanyClassDetailsPublicRead_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyClassDetailService.class);
	
	@Autowired
    private CompanyClassDetailsPublicRead_Repo companyClassDetailsPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getAllCompanyClassDetails() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyClassDetail> companyList = (CopyOnWriteArrayList<CompanyClassDetail>) companyClassDetailsPublicReadRepo.getAllCompanyClassDetails();
		CopyOnWriteArrayList<CompanyClassDetail_DTO> companyDetailDTOs = companyList != null ? this.getCompanyClassDetailDtos(companyList) : null;
		return companyDetailDTOs;
   		},asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByClasses(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyClassDetail> companyList = (CopyOnWriteArrayList<CompanyClassDetail>) companyClassDetailsPublicReadRepo.getSelectCompanyClassDetailsByClasses(ids);
		CopyOnWriteArrayList<CompanyClassDetail_DTO> companyDetailDTOs = companyList != null ? this.getCompanyClassDetailDtos(companyList) : null;
		return companyDetailDTOs;
   		},asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByCompanies(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyClassDetail> companyList = (CopyOnWriteArrayList<CompanyClassDetail>) companyClassDetailsPublicReadRepo.getSelectCompanyClassDetailsByCompanies(ids);
		CopyOnWriteArrayList<CompanyClassDetail_DTO> companyDetailDTOs = companyList != null ? this.getCompanyClassDetailDtos(companyList) : null;
		return companyDetailDTOs;
   		},asyncExecutor);
		return future;
	}
	
	private CopyOnWriteArrayList<CompanyClassDetail_DTO> getCompanyClassDetailDtos(CopyOnWriteArrayList<CompanyClassDetail> compDetails) {
		CompanyClassDetail_DTO companyDetailDTO = null;
		CopyOnWriteArrayList<CompanyClassDetail_DTO> companyDetailDTOs = new CopyOnWriteArrayList<CompanyClassDetail_DTO>();

		for (int i = 0; i < compDetails.size(); i++) {
			companyDetailDTO = this.getCompanyClassDetail_DTO(compDetails.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		return companyDetailDTOs;
	}

	private CompanyClassDetail_DTO getCompanyClassDetail_DTO(CompanyClassDetail compDetail) 
	{
		CompanyClassDetail_DTO companyDetailDTO = null;
		companyDetailDTO = new CompanyClassDetail_DTO();
		companyDetailDTO.setCompanySeqNo(compDetail.getId().getCompanySeqNo());
		companyDetailDTO.setCompanyClassSeqNo(compDetail.getId().getCompanyClassSeqNo());		
		return companyDetailDTO;
	}
	
}