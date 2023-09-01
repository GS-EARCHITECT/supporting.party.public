package enterprise.company.company_class_details.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import enterprise.company.company_class_details.model.dto.CompanyClassDetail_DTO;

public interface I_CompanyClassDetailsPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getAllCompanyClassDetails();
    public CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByClasses(CopyOnWriteArrayList<Long> ids);    
    public CompletableFuture<CopyOnWriteArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByCompanies(CopyOnWriteArrayList<Long> ids);
 }