package enterprise.company_unit_functions.details.services;

import java.util.ArrayList;
import enterprise.company_unit_functions.details.model.dto.CompanyUnitFunctionDetailDTO;

public interface I_CompanyUnitFunctionDetailsService
{
    abstract public CompanyUnitFunctionDetailDTO newCompanyUnitFunctionDetail(CompanyUnitFunctionDetailDTO companyUnitFunctionDetailDetailDTO);
    abstract public ArrayList<CompanyUnitFunctionDetailDTO> getAllCompanyUnitFunctionDetails();
    abstract public ArrayList<CompanyUnitFunctionDetailDTO> getSelectCompanyUnitFunctionDetailsByParents(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitFunctionDetailDTO> getSelectCompanyUnitFunctionDetails(ArrayList<Long> companySeqNos, ArrayList<Long> parCompanySeqNos);
    abstract public void updCompanyUnitFunctionDetail(CompanyUnitFunctionDetailDTO companyUnitFunctionsDetailDTO);    
    abstract public void delAllCompanyUnitFunctionDetails();
    abstract public void delSelectCompanyUnitFunctionDetails(ArrayList<Long> cSeqNos, ArrayList<Long> pCSeqNos);
    abstract void delSelectCompanyUnitFunctionDetailsByParents(ArrayList<Long> ids);
}