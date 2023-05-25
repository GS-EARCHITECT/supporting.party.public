package enterprise.company_unit_functions.master.services;

import java.util.ArrayList;
import enterprise.company_unit_functions.master.model.dto.CompanyUnitFunctionDTO;

public interface I_CompanyUnitFunctionsService
{
    abstract public CompanyUnitFunctionDTO newCompanyUnitFunction(CompanyUnitFunctionDTO companyUnitFunctionDTO);
    abstract public ArrayList<CompanyUnitFunctionDTO> getAllCompanyUnitFunctions();
    abstract public ArrayList<CompanyUnitFunctionDTO> getSelectCompanyUnitFunctions(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitFunctionDTO> getSelectCompanyUnitFunctionsForUnits(ArrayList<Long> ids);
    abstract public void updCompanyUnitFunction(CompanyUnitFunctionDTO companyUnitFunctionDTO);
    abstract public void delAllCompanyUnitFunctions();
    abstract public void delSelectCompanyUnitFunctions(ArrayList<Long> ids);
    abstract public void delSelectCompanyUnitFunctionsForUnits(ArrayList<Long> ids);


}