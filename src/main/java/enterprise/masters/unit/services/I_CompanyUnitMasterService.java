package enterprise.masters.unit.services;

import java.util.ArrayList;
import enterprise.masters.unit.model.dto.CompanyUnitMasterDTO;

public interface I_CompanyUnitMasterService 
{
	public CompanyUnitMasterDTO newUnit(CompanyUnitMasterDTO roleDTO);
	public ArrayList<CompanyUnitMasterDTO> getAllUnits();
	public ArrayList<CompanyUnitMasterDTO> getSelectUnits(ArrayList<Long> roleSeqNos);
	public void updUnit(CompanyUnitMasterDTO roleDTO);	
	public void delAllUnits();
	public void delSelectUnits(ArrayList<Long> roleSeqNos);
}