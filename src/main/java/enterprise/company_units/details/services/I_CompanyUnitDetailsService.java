package enterprise.company_units.details.services;

import java.util.ArrayList;
import enterprise.company_units.details.model.dto.CompanyUnitDetailDTO;

public interface I_CompanyUnitDetailsService
{
    abstract public CompanyUnitDetailDTO newCompanyUnitDetail(CompanyUnitDetailDTO companyUnitDetailDTO);
    abstract public ArrayList<CompanyUnitDetailDTO> getAllCompanyUnitDetails();
    abstract public ArrayList<CompanyUnitDetailDTO> getSelectCompanyUnitsByParents(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitDetailDTO> getSelectCompanyUnits(ArrayList<Long> companyUnitSeqNos, ArrayList<Long> parCompanySeqNos);
    abstract public void updCompanyUnitDetail(CompanyUnitDetailDTO companyUnitDetailDTO);    
    abstract public void delAllCompanyUnitDetails();
    abstract public void delSelectCompanyUnits(ArrayList<Long> companyUnitSeqNos, ArrayList<Long> parCompanyUnitSeqNos);
    abstract void delSelectCompanyUnitsByParents(ArrayList<Long> ids);

}