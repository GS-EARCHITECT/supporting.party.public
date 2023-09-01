package enterprise.company.company_structure_details.services;

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
import enterprise.company.company_structure_details.model.dto.CompanyStructureDetail_DTO;
import enterprise.company.company_structure_details.model.master.CompanyStructureDetail;
import enterprise.company.company_structure_details.model.repo.CompanyStructureDetailsPublicRead_Repo;

@Service("companyStructureDetailsPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyStructureDetailsPublicRead_Service implements I_CompanyStructureDetailsPublicRead_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyStructureDetailService.class);
	
	@Autowired
    private CompanyStructureDetailsPublicRead_Repo companyStructureDetailsPublicReadRepo;
		
	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> getAllCompanyStructureDetails() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyStructureDetail> companyList = companyStructureDetailsPublicReadRepo.getAllCompanyStructureDetails();
		CopyOnWriteArrayList<CompanyStructureDetail_DTO> companyDetailDTOs = companyList != null ? this.getCompanyStructureDetailDtos(companyList) : null;
		return companyDetailDTOs;
   		},asyncExecutor);
		return future;

	}

	public CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> getSelectCompanyStructureDetails(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyStructureDetail> companyList = companyStructureDetailsPublicReadRepo.getSelectCompanyStructureDetails(ids);
		CopyOnWriteArrayList<CompanyStructureDetail_DTO> companyDetailDTOs = companyList != null ? this.getCompanyStructureDetailDtos(companyList) : null;
		return companyDetailDTOs;
   		},asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<CompanyStructureDetail_DTO> getCompanyStructureDetailDtos(CopyOnWriteArrayList<CompanyStructureDetail> compDetails) {
		CompanyStructureDetail_DTO companyDetailDTO = null;
		CopyOnWriteArrayList<CompanyStructureDetail_DTO> companyDetailDTOs = new CopyOnWriteArrayList<CompanyStructureDetail_DTO>();

		for (int i = 0; i < compDetails.size(); i++) {
			companyDetailDTO = this.getCompanyStructureDetail_DTO(compDetails.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		return companyDetailDTOs;
	}

	private synchronized CompanyStructureDetail_DTO getCompanyStructureDetail_DTO(CompanyStructureDetail compDetail) 
	{
		CompanyStructureDetail_DTO companyDetailDTO = null;
		companyDetailDTO = new CompanyStructureDetail_DTO();
		companyDetailDTO.setCompanySeqNo(compDetail.getId().getCompanySeqNo());
		companyDetailDTO.setParCompanySeqNo(compDetail.getId().getParCompanySeqNo());
		companyDetailDTO.setCompanyClassSeqNo(compDetail.getId().getCompanyClassSeqNo());
		companyDetailDTO.setParCompanyClassSeqNo(compDetail.getId().getParCompanyClassSeqNo());
		return companyDetailDTO;
	}
	
}