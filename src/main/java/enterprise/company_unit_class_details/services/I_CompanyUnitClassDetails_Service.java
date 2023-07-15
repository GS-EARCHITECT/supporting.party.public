package enterprise.company_unit_class_details.services;

import java.util.ArrayList;

import enterprise.company_unit_class_details.model.dto.CompanyUnitClassDetail_DTO;

public interface I_CompanyUnitClassDetails_Service
{
    abstract public CompanyUnitClassDetail_DTO newCompanyUnitClassDetail(CompanyUnitClassDetail_DTO companyUnitClassDetailDTO);
    abstract public ArrayList<CompanyUnitClassDetail_DTO> getAllCompanyUnitClassDetails();
    abstract public ArrayList<CompanyUnitClassDetail_DTO> getSelectCompanyUnitClassDetails(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitClassDetail_DTO> getSelectCompanyUnitClassDetailsForChildClasses(ArrayList<Long> ids, ArrayList<Long> pids);
    abstract public void updCompanyUnitClassDetail(CompanyUnitClassDetail_DTO companyUnitClassDetailDTO);    
    abstract public void delAllCompanyUnitClassDetails();
    abstract public void delSelectCompanyUnitClassDetails(ArrayList<Long> companyUnitSeqNos);
    abstract public void delSelectCompanyUnitClassDetailsForChildClasses(ArrayList<Long> ids, ArrayList<Long> pids);
}