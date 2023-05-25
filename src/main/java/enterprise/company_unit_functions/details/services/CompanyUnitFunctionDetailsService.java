package enterprise.company_unit_functions.details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_functions.details.model.dto.CompanyUnitFunctionDetailDTO;
import enterprise.company_unit_functions.details.model.master.CompanyUnitFunctionDetail;
import enterprise.company_unit_functions.details.model.master.CompanyUnitFunctionDetailPK;
import enterprise.company_unit_functions.details.model.repo.CompanyUnitFunctionsDetailsRepo;

@Service("companyUnitFunctionsDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitFunctionDetailsService implements I_CompanyUnitFunctionDetailsService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitFunctionDetailService.class);
	
	@Autowired
    private CompanyUnitFunctionsDetailsRepo companyUnitFunctionsDetailsRepo;
		
	public CompanyUnitFunctionDetailDTO newCompanyUnitFunctionDetail(CompanyUnitFunctionDetailDTO companyUnitFunctionsDetailDTO) 
	{
		CompanyUnitFunctionDetailPK companyUnitFunctionsDetailPK = new CompanyUnitFunctionDetailPK();
		companyUnitFunctionsDetailPK.setFunctionSeqNo(companyUnitFunctionsDetailDTO.getFunctionSeqNo());
		companyUnitFunctionsDetailPK.setParFunctionSeqNo(companyUnitFunctionsDetailDTO.getParFunctionSeqNo());
		
		if(!companyUnitFunctionsDetailsRepo.existsById(companyUnitFunctionsDetailPK))
		{
		CompanyUnitFunctionDetail companyDetail = companyUnitFunctionsDetailsRepo.save(this.setCompanyUnitFunctionDetail(companyUnitFunctionsDetailDTO));
		companyUnitFunctionsDetailDTO = getCompanyUnitFunctionDetailDTO(companyDetail);
		}
		return companyUnitFunctionsDetailDTO;
	}

	public ArrayList<CompanyUnitFunctionDetailDTO> getAllCompanyUnitFunctionDetails() 
	{
		ArrayList<CompanyUnitFunctionDetail> companyList = (ArrayList<CompanyUnitFunctionDetail>) companyUnitFunctionsDetailsRepo.findAll();
		ArrayList<CompanyUnitFunctionDetailDTO> companyDetailDTOs = new ArrayList<CompanyUnitFunctionDetailDTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyUnitFunctionDetailDtos(companyList) : null;
		return companyDetailDTOs;
	}

	public ArrayList<CompanyUnitFunctionDetailDTO> getSelectCompanyUnitFunctionDetails(ArrayList<Long> companySeqNos, ArrayList<Long> parCompanySeqNos) 
	{
		ArrayList<CompanyUnitFunctionDetail> companyList = companyUnitFunctionsDetailsRepo.getSelectCompanyFunctionDetails(companySeqNos, parCompanySeqNos);
		ArrayList<CompanyUnitFunctionDetailDTO> companyDetailDTOs = new ArrayList<CompanyUnitFunctionDetailDTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyUnitFunctionDetailDtos(companyList) : null;		
		return companyDetailDTOs;
	}

	public ArrayList<CompanyUnitFunctionDetailDTO> getSelectCompanyUnitFunctionDetailsByParents(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitFunctionDetail> companyList = companyUnitFunctionsDetailsRepo.getSelectCompanyFunctionDetailsByParents(ids);
		ArrayList<CompanyUnitFunctionDetailDTO> companyDetailDTOs = new ArrayList<CompanyUnitFunctionDetailDTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyUnitFunctionDetailDtos(companyList) : null;		
		return companyDetailDTOs;
	}
	

	public void updCompanyUnitFunctionDetail(CompanyUnitFunctionDetailDTO companyUnitFunctionsDetailDTO) 
	{		
		CompanyUnitFunctionDetailPK companyUnitFunctionsDetailPK = new CompanyUnitFunctionDetailPK();
		companyUnitFunctionsDetailPK.setFunctionSeqNo(companyUnitFunctionsDetailDTO.getFunctionSeqNo());
		companyUnitFunctionsDetailPK.setParFunctionSeqNo(companyUnitFunctionsDetailDTO.getParFunctionSeqNo());
		
		if (companyUnitFunctionsDetailsRepo.existsById(companyUnitFunctionsDetailPK)) 
		{
			CompanyUnitFunctionDetail companyDetail = this.setCompanyUnitFunctionDetail(companyUnitFunctionsDetailDTO);			
			companyUnitFunctionsDetailsRepo.save(companyDetail);
		}
	}

	public void delAllCompanyUnitFunctionDetails() 
	{
		companyUnitFunctionsDetailsRepo.deleteAll();
	}

	public void delSelectCompanyUnitFunctionDetails(ArrayList<Long> companySeqNos, ArrayList<Long> parCompanySeqNos) 
	{
	companyUnitFunctionsDetailsRepo.delSelectCompanyFunctionDetails(companySeqNos,parCompanySeqNos);		
	}
	
	public void delSelectCompanyUnitFunctionDetailsByParents(ArrayList<Long> ids) 
	{
	companyUnitFunctionsDetailsRepo.delSelectCompanyFunctionDetailsByParents(ids);		
	}

	private ArrayList<CompanyUnitFunctionDetailDTO> getCompanyUnitFunctionDetailDtos(ArrayList<CompanyUnitFunctionDetail> compDetails) {
		CompanyUnitFunctionDetailDTO companyDetailDTO = null;
		ArrayList<CompanyUnitFunctionDetailDTO> companyDetailDTOs = new ArrayList<CompanyUnitFunctionDetailDTO>();

		for (int i = 0; i < compDetails.size(); i++) {
			companyDetailDTO = this.getCompanyUnitFunctionDetailDTO(compDetails.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		return companyDetailDTOs;
	}

	private CompanyUnitFunctionDetailDTO getCompanyUnitFunctionDetailDTO(CompanyUnitFunctionDetail compuCompanyUnitFunctionDetail) 
	{
		CompanyUnitFunctionDetailDTO companyUnitFunctionsDetailDTO = null;
		companyUnitFunctionsDetailDTO = new CompanyUnitFunctionDetailDTO();
		companyUnitFunctionsDetailDTO.setFunctionSeqNo(compuCompanyUnitFunctionDetail.getId().getFunctionSeqNo());
		companyUnitFunctionsDetailDTO.setParFunctionSeqNo(compuCompanyUnitFunctionDetail.getId().getParFunctionSeqNo());
		return companyUnitFunctionsDetailDTO;
	}

	private CompanyUnitFunctionDetail setCompanyUnitFunctionDetail(CompanyUnitFunctionDetailDTO cDTO) 
	{
		CompanyUnitFunctionDetailPK companyUnitFunctionsDetailPK = new CompanyUnitFunctionDetailPK();
		companyUnitFunctionsDetailPK.setFunctionSeqNo(cDTO.getFunctionSeqNo());
		companyUnitFunctionsDetailPK.setParFunctionSeqNo(cDTO.getParFunctionSeqNo());			
		CompanyUnitFunctionDetail cDetail = new CompanyUnitFunctionDetail();		
		cDetail.setId(companyUnitFunctionsDetailPK);
		return cDetail;
	}
	
}