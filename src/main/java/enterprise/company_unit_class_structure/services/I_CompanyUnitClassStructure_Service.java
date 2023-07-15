package enterprise.company_unit_class_structure.services;

import java.util.ArrayList;
import enterprise.company_unit_class_structure.model.dto.CompanyUnitClassStructure_DTO;

public interface I_CompanyUnitClassStructure_Service
{
    abstract public CompanyUnitClassStructure_DTO newCompanyUnitClassStructure(CompanyUnitClassStructure_DTO companyUnitClassStructureDTO);
    abstract public ArrayList<CompanyUnitClassStructure_DTO> getAllCompanyUnitClassStructures();
    abstract public ArrayList<CompanyUnitClassStructure_DTO> getSelectCompanyUnitClassStructures(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitClassStructure_DTO> getSelectCompanyUnitClassStructuresForParentClasses(ArrayList<Long> ids, ArrayList<Long> pids);
    abstract public ArrayList<CompanyUnitClassStructure_DTO> getSelectCompanyUnitClassStructuresForChildClasses(ArrayList<Long> ids, ArrayList<Long> cids);	
    abstract public void updCompanyUnitClassStructure(CompanyUnitClassStructure_DTO companyUnitClassStructureDTO);    
    abstract public void delAllCompanyUnitClassStructures();
    abstract public void delSelectCompanyUnitClassStructures(ArrayList<Long> ids);
    abstract public void delSelectCompanyUnitClassStructuresForParentClasses(ArrayList<Long> ids, ArrayList<Long> pids);
    abstract public void delSelectCompanyUnitClassStructuresForChildClasses(ArrayList<Long> ids, ArrayList<Long> cids);
}