package enterprise.company_unit_roles.master.services;

import java.util.ArrayList;
import enterprise.company_unit_roles.master.model.dto.CompanyUnitRoleDTO;

public interface I_CompanyUnitRolesService
{
    abstract public CompanyUnitRoleDTO newCompanyUnitRole(CompanyUnitRoleDTO companyUnitRoleDTO);
    abstract public ArrayList<CompanyUnitRoleDTO> getAllCompanyUnitRoles();
    abstract public ArrayList<CompanyUnitRoleDTO> getSelectCompanyUnitRoles(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitRoleDTO> getSelectCompanyUnitRolesForUnits(ArrayList<Long> ids);
    abstract public void updCompanyUnitRole(CompanyUnitRoleDTO companyUnitRoleDTO);
    abstract public void delAllCompanyUnitRoles();
    abstract public void delSelectCompanyUnitRoles(ArrayList<Long> ids);
    abstract public void delSelectCompanyUnitRolesForUnits(ArrayList<Long> ids);


}