package enterprise.company_unit_functions.master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_functions.master.model.dto.CompanyUnitFunctionDTO;
import enterprise.company_unit_functions.master.model.master.CompanyUnitFunction;
import enterprise.company_unit_functions.master.model.repo.CompanyUnitFunctionsRepo;

@Service("companyUnitFunctionsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitFunctionsService implements I_CompanyUnitFunctionsService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitFunctionService.class);
	
	@Autowired
    private CompanyUnitFunctionsRepo companyUnitFunctionsRepo;
		
	public CompanyUnitFunctionDTO newCompanyUnitFunction(CompanyUnitFunctionDTO companyFunctionDTO) 
	{
		if(!companyUnitFunctionsRepo.existsById(companyFunctionDTO.getCompanyFunctionSeqNo()))
		{
		CompanyUnitFunction companyUnitFunction = companyUnitFunctionsRepo.save(this.setCompanyUnitFunction(companyFunctionDTO));
		companyFunctionDTO = getCompanyUnitFunctionDTO(companyUnitFunction);
		}
		return companyFunctionDTO;
	}

	public ArrayList<CompanyUnitFunctionDTO> getAllCompanyUnitFunctions() 
	{
		ArrayList<CompanyUnitFunction> companyList = (ArrayList<CompanyUnitFunction>) companyUnitFunctionsRepo.findAll();
		ArrayList<CompanyUnitFunctionDTO> companyDTOs = new ArrayList<CompanyUnitFunctionDTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitFunctionDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyUnitFunctionDTO> getSelectCompanyUnitFunctions(ArrayList<Long> companySeqNos) 
	{
		ArrayList<CompanyUnitFunction> companyList = companyUnitFunctionsRepo.getSelectCompanyUnitFunctions(companySeqNos);
		ArrayList<CompanyUnitFunctionDTO> companyDTOs = new ArrayList<CompanyUnitFunctionDTO>();		
		companyDTOs = companyList != null ? this.getCompanyUnitFunctionDtos(companyList) : null;		
		return companyDTOs;
	}

	public ArrayList<CompanyUnitFunctionDTO> getSelectCompanyUnitFunctionsForUnits(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitFunction> companyList = companyUnitFunctionsRepo.getSelectCompanyUnitFunctionsForCompanyUnits(ids);
		ArrayList<CompanyUnitFunctionDTO> companyDTOs = new ArrayList<CompanyUnitFunctionDTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitFunctionDtos(companyList) : null;		
		return companyDTOs;
	}
	

	public void updCompanyUnitFunction(CompanyUnitFunctionDTO companyUnitFunctionDTO)
	{

		CompanyUnitFunction companyUnitFunction = this.setCompanyUnitFunction(companyUnitFunctionDTO);
		if (companyUnitFunctionsRepo.existsById(companyUnitFunctionDTO.getCompanyFunctionSeqNo())) {
			companyUnitFunction.setCompanyFunctionSeqNo(companyUnitFunctionDTO.getCompanyFunctionSeqNo());
			companyUnitFunctionsRepo.save(companyUnitFunction);
		}
	}

	public void delCompanyUnitFunction(Long companySeqNo) {
		if (companyUnitFunctionsRepo.existsById(companySeqNo)) {
			companyUnitFunctionsRepo.deleteById(companySeqNo);
		}
	}
	
	public void delAllCompanyUnitFunctions() {
		companyUnitFunctionsRepo.deleteAll();
	}

	public void delSelectCompanyUnitFunctions(ArrayList<Long> companySeqNos) 
	{
	companyUnitFunctionsRepo.delSelectCompanyUnitFunctions(companySeqNos);		
	}
	
	public void delSelectCompanyUnitFunctionsForUnits(ArrayList<Long> ids) 
	{
	companyUnitFunctionsRepo.delSelectCompanyUnitFunctionsForCompanyUnits(ids);		
	}

	private ArrayList<CompanyUnitFunctionDTO> getCompanyUnitFunctionDtos(ArrayList<CompanyUnitFunction> compUnits) {
		CompanyUnitFunctionDTO companyDTO = null;
		ArrayList<CompanyUnitFunctionDTO> companyDTOs = new ArrayList<CompanyUnitFunctionDTO>();

		for (int i = 0; i < compUnits.size(); i++) {
			companyDTO = this.getCompanyUnitFunctionDTO(compUnits.get(i));			
			companyDTOs.add(companyDTO);
		}
		return companyDTOs;
	}

	private CompanyUnitFunctionDTO getCompanyUnitFunctionDTO(CompanyUnitFunction compUnitFunction) 
	{
		CompanyUnitFunctionDTO companyDTO = null;
		companyDTO = new CompanyUnitFunctionDTO();
		companyDTO.setCompanyFunctionSeqNo(compUnitFunction.getCompanyFunctionSeqNo());
		companyDTO.setCompanyUnitSeqNo(compUnitFunction.getCompanyUnitSeqNo());
		companyDTO.setFunctionSeqNo(compUnitFunction.getFunctionSeqNo());
		companyDTO.setUnitFunctionId(compUnitFunction.getUnitFunctionId());
		companyDTO.setRemark(compUnitFunction.getRemark());
		companyDTO.setStatus(compUnitFunction.getStatus());		
		return companyDTO;
	}

	private CompanyUnitFunction setCompanyUnitFunction(CompanyUnitFunctionDTO cDTO)
	{
		CompanyUnitFunction cUnit = new CompanyUnitFunction();
		cUnit.setCompanyUnitSeqNo(cDTO.getCompanyUnitSeqNo());
		cUnit.setFunctionSeqNo(cDTO.getFunctionSeqNo());
		cUnit.setUnitFunctionId(cDTO.getUnitFunctionId());
		cUnit.setRemark(cDTO.getRemark());
		cUnit.setStatus(cDTO.getStatus());	
		return cUnit;
	}
	
}