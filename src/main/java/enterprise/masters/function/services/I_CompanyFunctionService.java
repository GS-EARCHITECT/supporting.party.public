package enterprise.masters.function.services;

import java.util.ArrayList;

import enterprise.masters.function.model.dto.CompanyFunctionDTO;


public interface I_CompanyFunctionService 
{
	public CompanyFunctionDTO newFunction(CompanyFunctionDTO functionDTO);
	public ArrayList<CompanyFunctionDTO> getAllFunctions();
	public ArrayList<CompanyFunctionDTO> getSelectFunctions(ArrayList<Long> functionSeqNos);
	public void updFunction(CompanyFunctionDTO functionDTO);	
	public void delAllFunctions();
	public void delSelectFunctions(ArrayList<Long> functionSeqNos);
}