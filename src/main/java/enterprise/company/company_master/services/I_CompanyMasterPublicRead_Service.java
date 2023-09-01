package enterprise.company.company_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import enterprise.company.company_master.model.dto.CompanyMaster_DTO;

public interface I_CompanyMasterPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> getAllCompanies();
    public CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> getSelectCompaniesForParties(CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<CopyOnWriteArrayList<CompanyMaster_DTO>> getSelectCompanies(CopyOnWriteArrayList<Long> companySeqNos);
}