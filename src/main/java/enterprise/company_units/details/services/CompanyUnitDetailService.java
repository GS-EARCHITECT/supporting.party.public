package enterprise.company_units.details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.company_units.details.model.dto.CompanyUnitDetailDTO;
import enterprise.company_units.details.model.master.CompanyUnitDetail;
import enterprise.company_units.details.model.master.CompanyUnitDetailPK;
import enterprise.company_units.details.model.repo.CompanyUnitDetailsRepo;

@Service("companyUnitDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitDetailService implements I_CompanyUnitDetailsService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitDetailService.class);
	
	@Autowired
    private CompanyUnitDetailsRepo companyUnitDetailsRepo;
		
	public CompanyUnitDetailDTO newCompanyUnitDetail(CompanyUnitDetailDTO companyUnitDTO) 
	{
		CompanyUnitDetailPK companyUnitDetailsPK = new CompanyUnitDetailPK();
		companyUnitDetailsPK.setCompanyUnitSeqNo(companyUnitDTO.getCompanyUnitSeqNo());
		companyUnitDetailsPK.setParCompanyUnitSeqNo(companyUnitDTO.getParCompanyUnitSeqNo());
		
		if(!companyUnitDetailsRepo.existsById(companyUnitDetailsPK))
		{
		CompanyUnitDetail companyUnitDetails = companyUnitDetailsRepo.save(this.setCompanyUnitDetail(companyUnitDTO));
		companyUnitDTO = getCompanyUnitDetailDTO(companyUnitDetails);
		}
		return companyUnitDTO;
	}

	public ArrayList<CompanyUnitDetailDTO> getAllCompanyUnitDetails() 
	{
		ArrayList<CompanyUnitDetail> companyUnitList = (ArrayList<CompanyUnitDetail>) companyUnitDetailsRepo.findAll();
		ArrayList<CompanyUnitDetailDTO> companyUnitDTOs = new ArrayList<CompanyUnitDetailDTO>();
		companyUnitDTOs = companyUnitList != null ? this.getCompanyUnitDetailDtos(companyUnitList) : null;
		return companyUnitDTOs;
	}

	public ArrayList<CompanyUnitDetailDTO> getSelectCompanyUnits(ArrayList<Long> companyUnitSeqNos, ArrayList<Long> parCompanySeqNos) 
	{
		ArrayList<CompanyUnitDetail> companyUnitList = companyUnitDetailsRepo.getSelectCompanyUnitDetails(companyUnitSeqNos, parCompanySeqNos);
		ArrayList<CompanyUnitDetailDTO> companyUnitDTOs = new ArrayList<CompanyUnitDetailDTO>();
		CompanyUnitDetailDTO companyUnitDetailsDTO = null;

		for (int i = 0; i < companyUnitSeqNos.size(); i++) 
		{
			companyUnitDetailsDTO = this.getCompanyUnitDetailDTO(companyUnitList.get(i));			
			companyUnitDTOs.add(companyUnitDetailsDTO);
		}
		
		return companyUnitDTOs;
	}

	public ArrayList<CompanyUnitDetailDTO> getSelectCompanyUnitsByParents(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitDetail> companyUnitList = companyUnitDetailsRepo.getSelectCompanyUnitDetailsByParents(ids);
		ArrayList<CompanyUnitDetailDTO> companyUnitDTOs = new ArrayList<CompanyUnitDetailDTO>();
		CompanyUnitDetailDTO companyUnitDetailsDTO = null;

		for (int i = 0; i < companyUnitList.size(); i++) 
		{
			companyUnitDetailsDTO = this.getCompanyUnitDetailDTO(companyUnitList.get(i));			
			companyUnitDTOs.add(companyUnitDetailsDTO);
		}
		
		return companyUnitDTOs;
	}
	

	public void updCompanyUnitDetail(CompanyUnitDetailDTO companyUnitDTO) 
	{		
		CompanyUnitDetailPK companyUnitDetailsPK = new CompanyUnitDetailPK();
		companyUnitDetailsPK.setCompanyUnitSeqNo(companyUnitDTO.getCompanyUnitSeqNo());
		companyUnitDetailsPK.setParCompanyUnitSeqNo(companyUnitDTO.getParCompanyUnitSeqNo());
		
		if (companyUnitDetailsRepo.existsById(companyUnitDetailsPK)) 
		{
			CompanyUnitDetail companyUnitDetails = this.setCompanyUnitDetail(companyUnitDTO);			
			companyUnitDetailsRepo.save(companyUnitDetails);
		}
	}

	public void delAllCompanyUnitDetails() 
	{
		companyUnitDetailsRepo.deleteAll();
	}

	public void delSelectCompanyUnits(ArrayList<Long> companyUnitSeqNos, ArrayList<Long> parCompanySeqNos) 
	{
	companyUnitDetailsRepo.delSelectCompanyUnitDetails(companyUnitSeqNos,parCompanySeqNos);		
	}
	
	public void delSelectCompanyUnitsByParents(ArrayList<Long> ids) 
	{
	companyUnitDetailsRepo.delSelectCompanyUnitDetailsByParents(ids);		
	}

	private ArrayList<CompanyUnitDetailDTO> getCompanyUnitDetailDtos(ArrayList<CompanyUnitDetail> compDetailss) {
		CompanyUnitDetailDTO companyUnitDTO = null;
		ArrayList<CompanyUnitDetailDTO> companyUnitDTOs = new ArrayList<CompanyUnitDetailDTO>();

		for (int i = 0; i < compDetailss.size(); i++) {
			companyUnitDTO = this.getCompanyUnitDetailDTO(compDetailss.get(i));			
			companyUnitDTOs.add(companyUnitDTO);
		}
		return companyUnitDTOs;
	}

	private CompanyUnitDetailDTO getCompanyUnitDetailDTO(CompanyUnitDetail compDetails) 
	{
		CompanyUnitDetailDTO companyUnitDTO = null;
		companyUnitDTO = new CompanyUnitDetailDTO();
		companyUnitDTO.setCompanyUnitSeqNo(compDetails.getId().getCompanyUnitSeqNo());
		companyUnitDTO.setParCompanyUnitSeqNo(compDetails.getId().getParCompanyUnitSeqNo());		
		return companyUnitDTO;
	}

	private CompanyUnitDetail setCompanyUnitDetail(CompanyUnitDetailDTO cDTO) 
	{
		CompanyUnitDetailPK companyUnitDetailsPK = new CompanyUnitDetailPK();
		companyUnitDetailsPK.setCompanyUnitSeqNo(cDTO.getCompanyUnitSeqNo());
		companyUnitDetailsPK.setParCompanyUnitSeqNo(cDTO.getParCompanyUnitSeqNo());			
		CompanyUnitDetail cDetails = new CompanyUnitDetail();		
		cDetails.setId(companyUnitDetailsPK);
		return cDetails;
	}
	
}