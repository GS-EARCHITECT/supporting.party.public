package enterprise.company_unit_services.services;

import java.util.ArrayList;

import enterprise.company_unit_services.model.dto.CompanyUnitServiceMasterDTO;

public interface I_CompanyUnitService
{
    abstract public CompanyUnitServiceMasterDTO newCompanyUnitService(CompanyUnitServiceMasterDTO companyUnitDTO);
    abstract public ArrayList<CompanyUnitServiceMasterDTO> getAllCompanyUnitServices();
    abstract public ArrayList<CompanyUnitServiceMasterDTO> getSelectCompanyUnitServices(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitServiceMasterDTO> getSelectCompanyUnitServicesForUnits(ArrayList<Long> ids);
    abstract public void updCompanyUnitService(CompanyUnitServiceMasterDTO companyUnitDTO);    
    abstract public void delAllCompanyUnitServices();
    abstract public void delSelectCompanyUnitServices(ArrayList<Long> ids);
    abstract public void delSelectCompanyUnitServicesForUnits(ArrayList<Long> ids);


}