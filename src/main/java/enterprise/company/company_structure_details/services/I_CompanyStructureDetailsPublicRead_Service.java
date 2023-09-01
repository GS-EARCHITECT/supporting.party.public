package enterprise.company.company_structure_details.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import enterprise.company.company_structure_details.model.dto.CompanyStructureDetail_DTO;

public interface I_CompanyStructureDetailsPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> getAllCompanyStructureDetails(); 
    public CompletableFuture<CopyOnWriteArrayList<CompanyStructureDetail_DTO>> getSelectCompanyStructureDetails(CopyOnWriteArrayList<Long> cSeqNos);     
}