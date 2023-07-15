package enterprise.company_unit_class_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.company_unit_class_details.model.dto.CompanyUnitClassDetail_DTO;
import enterprise.company_unit_class_details.model.master.CompanyUnitClassDetail;
import enterprise.company_unit_class_details.model.master.CompanyUnitClassDetailPK;
import enterprise.company_unit_class_details.model.repo.CompanyUnitClassDetails_Repo;

@Service("companyUnitClassDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitClassDetails_Service implements I_CompanyUnitClassDetails_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitClassDetailService.class);
	
	@Autowired
    private CompanyUnitClassDetails_Repo companyUnitClassDetailsRepo;
		
	public CompanyUnitClassDetail_DTO newCompanyUnitClassDetail(CompanyUnitClassDetail_DTO companyUnitClassDetailDTO) 
	{
		CompanyUnitClassDetailPK companyUnitClassDetailsPK = new CompanyUnitClassDetailPK();
		companyUnitClassDetailsPK.setCompanyUnitSeqNo(companyUnitClassDetailDTO.getCompanyUnitSeqNo());
		companyUnitClassDetailsPK.setParCompanyUnitSeqNo(companyUnitClassDetailDTO.getParCompanyUnitSeqNo());
		companyUnitClassDetailsPK.setUnitClassSeqNo(companyUnitClassDetailDTO.getUnitClassSeqNo());
		
		if(!companyUnitClassDetailsRepo.existsById(companyUnitClassDetailsPK))
		{
		CompanyUnitClassDetail companyUnitClassDetails = companyUnitClassDetailsRepo.save(this.setCompanyUnitClassDetail(companyUnitClassDetailDTO));
		companyUnitClassDetailDTO = getCompanyUnitClassDetail_DTO(companyUnitClassDetails);
		}
		return companyUnitClassDetailDTO;
	}

	public ArrayList<CompanyUnitClassDetail_DTO> getAllCompanyUnitClassDetails() 
	{
		ArrayList<CompanyUnitClassDetail> companyUnitList = (ArrayList<CompanyUnitClassDetail>) companyUnitClassDetailsRepo.findAll();
		ArrayList<CompanyUnitClassDetail_DTO> companyUnitClassDetailDTOs = new ArrayList<CompanyUnitClassDetail_DTO>();
		companyUnitClassDetailDTOs = companyUnitList != null ? this.getCompanyUnitClassDetailDtos(companyUnitList) : null;
		return companyUnitClassDetailDTOs;
	}

	public ArrayList<CompanyUnitClassDetail_DTO> getSelectCompanyUnitClassDetails(ArrayList<Long> companyUnitSeqNos) 
	{
		ArrayList<CompanyUnitClassDetail> companyUnitList = companyUnitClassDetailsRepo.getSelectCompanyUnitClassDetails(companyUnitSeqNos);
		ArrayList<CompanyUnitClassDetail_DTO> companyUnitClassDetailDTOs = new ArrayList<CompanyUnitClassDetail_DTO>();
		companyUnitClassDetailDTOs = companyUnitList != null ? this.getCompanyUnitClassDetailDtos(companyUnitList) : null;		
		return companyUnitClassDetailDTOs;
	}

	public ArrayList<CompanyUnitClassDetail_DTO> getSelectCompanyUnitClassDetailsForChildClasses(ArrayList<Long> ids, ArrayList<Long> pids) 
	{
		ArrayList<CompanyUnitClassDetail> companyUnitList = companyUnitClassDetailsRepo.getSelectCompanyUnitClassDetailsForChildClasses(ids, pids);;
		ArrayList<CompanyUnitClassDetail_DTO> companyUnitClassDetailDTOs = new ArrayList<CompanyUnitClassDetail_DTO>();
		companyUnitClassDetailDTOs = companyUnitList != null ? this.getCompanyUnitClassDetailDtos(companyUnitList) : null;		
		return companyUnitClassDetailDTOs;
	}
	

	public void updCompanyUnitClassDetail(CompanyUnitClassDetail_DTO companyUnitClassDetailDTO) 
	{		
		CompanyUnitClassDetailPK companyUnitClassDetailsPK = new CompanyUnitClassDetailPK();
		companyUnitClassDetailsPK.setCompanyUnitSeqNo(companyUnitClassDetailDTO.getCompanyUnitSeqNo());
		companyUnitClassDetailsPK.setParCompanyUnitSeqNo(companyUnitClassDetailDTO.getParCompanyUnitSeqNo());
		companyUnitClassDetailsPK.setUnitClassSeqNo(companyUnitClassDetailDTO.getUnitClassSeqNo());
		
		if (companyUnitClassDetailsRepo.existsById(companyUnitClassDetailsPK)) 
		{
			CompanyUnitClassDetail companyUnitClassDetails = this.setCompanyUnitClassDetail(companyUnitClassDetailDTO);			
			companyUnitClassDetailsRepo.save(companyUnitClassDetails);
		}
	}

	public void delAllCompanyUnitClassDetails() 
	{
		companyUnitClassDetailsRepo.deleteAll();
	}

	public void delSelectCompanyUnitClassDetails(ArrayList<Long> companyUnitSeqNos) 
	{
	companyUnitClassDetailsRepo.delSelectCompanyUnitClassDetails(companyUnitSeqNos);;		
	}
	
	public void delSelectCompanyUnitClassDetailsForChildClasses(ArrayList<Long> ids, ArrayList<Long> pids) 
	{
	companyUnitClassDetailsRepo.delSelectCompanyUnitClassDetailsForChildClasses(ids, pids);		
	}

	private ArrayList<CompanyUnitClassDetail_DTO> getCompanyUnitClassDetailDtos(ArrayList<CompanyUnitClassDetail> compDetailss) {
		CompanyUnitClassDetail_DTO companyUnitClassDetailDTO = null;
		ArrayList<CompanyUnitClassDetail_DTO> companyUnitClassDetailDTOs = new ArrayList<CompanyUnitClassDetail_DTO>();

		for (int i = 0; i < compDetailss.size(); i++) {
			companyUnitClassDetailDTO = this.getCompanyUnitClassDetail_DTO(compDetailss.get(i));			
			companyUnitClassDetailDTOs.add(companyUnitClassDetailDTO);
		}
		return companyUnitClassDetailDTOs;
	}

	private CompanyUnitClassDetail_DTO getCompanyUnitClassDetail_DTO(CompanyUnitClassDetail compDetails) 
	{
		CompanyUnitClassDetail_DTO companyUnitClassDetailDTO = null;
		companyUnitClassDetailDTO = new CompanyUnitClassDetail_DTO();
		companyUnitClassDetailDTO.setCompanyUnitSeqNo(compDetails.getId().getCompanyUnitSeqNo());
		companyUnitClassDetailDTO.setParCompanyUnitSeqNo(compDetails.getId().getParCompanyUnitSeqNo());
		companyUnitClassDetailDTO.setUnitClassSeqNo(compDetails.getId().getUnitClassSeqNo());
		return companyUnitClassDetailDTO;
	}

	private CompanyUnitClassDetail setCompanyUnitClassDetail(CompanyUnitClassDetail_DTO cDTO) 
	{
		CompanyUnitClassDetailPK companyUnitClassDetailsPK = new CompanyUnitClassDetailPK();
		companyUnitClassDetailsPK.setCompanyUnitSeqNo(cDTO.getCompanyUnitSeqNo());
		companyUnitClassDetailsPK.setParCompanyUnitSeqNo(cDTO.getParCompanyUnitSeqNo());
		companyUnitClassDetailsPK.setUnitClassSeqNo(cDTO.getUnitClassSeqNo());
		CompanyUnitClassDetail cDetails = new CompanyUnitClassDetail();		
		cDetails.setId(companyUnitClassDetailsPK);
		return cDetails;
	}
	
}