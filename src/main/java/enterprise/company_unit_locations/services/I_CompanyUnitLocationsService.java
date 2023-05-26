package enterprise.company_unit_locations.services;

import java.util.ArrayList;
import enterprise.company_unit_locations.model.dto.CompanyUnitLocationDTO;

public interface I_CompanyUnitLocationsService
{
    abstract public CompanyUnitLocationDTO newCompanyUnitLocation(CompanyUnitLocationDTO companyUnitLocationDTO);
    abstract public ArrayList<CompanyUnitLocationDTO> getAllCompanyUnitLocations();
    abstract public ArrayList<CompanyUnitLocationDTO> getSelectCompanyUnitLocations(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitLocationDTO> getSelectCompanyUnitLocationsForUnits(ArrayList<Long> ids);
    abstract public void updCompanyUnitLocation(CompanyUnitLocationDTO companyUnitLocationDTO);
    abstract public void delAllCompanyUnitLocations();
    abstract public void delSelectCompanyUnitLocations(ArrayList<Long> ids);
    abstract public void delSelectCompanyUnitLocationsForUnits(ArrayList<Long> ids);


}