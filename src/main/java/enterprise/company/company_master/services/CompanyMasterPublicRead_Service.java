package enterprise.company.company_master.services;

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
import enterprise.company.company_master.model.dto.CompanyMaster_DTO;
import enterprise.company.company_master.model.master.CompanyMaster;
import enterprise.company.company_master.model.repo.CompanyMasterPublicRead_Repo;

@Service("companyMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyMasterPublicRead_Service implements I_CompanyMasterPublicRead_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyMasterService.class);
	
	@Autowired
    private CompanyMasterPublicRead_Repo companyPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
		
	public CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> getAllCompanies() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyMaster> companyList = (CopyOnWriteArrayList<CompanyMaster>) companyPublicReadRepo.getAllCompanies();
		CopyOnWriteArrayList<CompanyMaster_DTO> companyDTOs = companyList != null ? this.getCompanyMasterDtos(companyList) : null;
		return companyDTOs;
   		},asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> getSelectCompanies(CopyOnWriteArrayList<Long> companySeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyMaster> companyList = (CopyOnWriteArrayList<CompanyMaster>) companyPublicReadRepo.getSelectCompanies(companySeqNos);
		CopyOnWriteArrayList<CompanyMaster_DTO> companyDTOs = companyList != null ? this.getCompanyMasterDtos(companyList) : null;
		return companyDTOs;
   		},asyncExecutor);
		return future;	
		}

	public CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> getSelectCompaniesForParties(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyMaster> companyList = companyPublicReadRepo.getSelectCompaniesForParties(ids);
		CopyOnWriteArrayList<CompanyMaster_DTO> companyDTOs = new CopyOnWriteArrayList<CompanyMaster_DTO>();
		return companyDTOs;
   		},asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<CompanyMaster_DTO> getCompanyMasterDtos(CopyOnWriteArrayList<CompanyMaster> compMasters) {
		CompanyMaster_DTO companyDTO = null;
		CopyOnWriteArrayList<CompanyMaster_DTO> companyDTOs = new CopyOnWriteArrayList<CompanyMaster_DTO>();

		for (int i = 0; i < compMasters.size(); i++) {
			companyDTO = this.getCompanyMaster_DTO(compMasters.get(i));			
			companyDTOs.add(companyDTO);
		}
		return companyDTOs;
	}

	private synchronized CompanyMaster_DTO getCompanyMaster_DTO(CompanyMaster compMaster) 
	{
		CompanyMaster_DTO companyDTO = null;
		companyDTO = new CompanyMaster_DTO();
		companyDTO.setPartySeqNo(compMaster.getPartySeqNo());
		companyDTO.setCompanySeqNo(compMaster.getCompanySeqNo());
		companyDTO.setCompany(compMaster.getCompany());
		companyDTO.setCompanyId(compMaster.getCompanyId());
		companyDTO.setRemark(compMaster.getRemark());
		companyDTO.setStatus(compMaster.getStatus());
		companyDTO.setDescription(compMaster.getDescription());
		return companyDTO;
	}

	
}