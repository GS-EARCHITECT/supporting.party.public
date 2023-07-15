package enterprise.company_units_master.services;

import java.util.ArrayList;

import enterprise.company_units_master.model.dto.CompanyUnitDTO;

public interface I_CompanyUnitService
{
    abstract public CompanyUnitDTO newCompanyUnit(CompanyUnitDTO companyUnitDTO);
    abstract public ArrayList<CompanyUnitDTO> getAllCompanyUnits();
    abstract public ArrayList<CompanyUnitDTO> getSelectCompanyUnits(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitDTO> getSelectCompanyUnitsForUnitTypes(ArrayList<Long> ids);
    abstract public void updCompanyUnit(CompanyUnitDTO companyUnitDTO);
    abstract public void delCompanyUnit(Long companyUnitSeqNo);
    abstract public void delAllCompanyUnits();
    abstract public void delSelectCompanyUnits(ArrayList<Long> ids);
    abstract public void delSelectCompanyUnitsForUnitTypes(ArrayList<Long> ids);


}