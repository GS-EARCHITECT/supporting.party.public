package enterprise.company_class.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.masters.company_class.model.dto.CompanyClassMaster_DTO;
import enterprise.masters.company_class.model.master.CompanyClassMaster;
import enterprise.masters.company_class.model.repo.CompanyClassMaster_Repo;

@Service("companyClassServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyClassMaster_Service implements I_CompanyClassMaster_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyClassMasterService.class);

	@Autowired
	private CompanyClassMaster_Repo companyClassRepo;

	public CompanyClassMaster_DTO newCompanyClass(CompanyClassMaster_DTO cDTO) 
	{
		if (!companyClassRepo.existsById(cDTO.getCompanyClassSeqNo())) 
		{
			CompanyClassMaster companyUnitClass = companyClassRepo.save(this.setCompanyClassMaster(cDTO));
			cDTO = getCompanyClassMaster_DTO(companyUnitClass);
		}
		return cDTO;
	}

	public ArrayList<CompanyClassMaster_DTO> getAllCompanyClasses() 
	{
		ArrayList<CompanyClassMaster> companyUnitList = (ArrayList<CompanyClassMaster>) companyClassRepo.findAll();
		ArrayList<CompanyClassMaster_DTO> cDTOs = new ArrayList<CompanyClassMaster_DTO>();
		cDTOs = companyUnitList != null ? this.getCompanyClassMasterDtos(companyUnitList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyClassMaster_DTO> getSelectCompanyClasses(ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyClassMaster_DTO> cDTOs = new ArrayList<CompanyClassMaster_DTO>();
		CompanyClassMaster_DTO companyUnitClassDTO = null;
		ArrayList<CompanyClassMaster> companyUnitClasss = (ArrayList<CompanyClassMaster>) companyClassRepo.findAll();
		cDTOs = companyUnitClasss != null ? this.getCompanyClassMasterDtos(companyUnitClasss) : null;
		return cDTOs;
	}

	public void updCompanyClass(CompanyClassMaster_DTO cDTO) 
	{
		if (companyClassRepo.existsById(cDTO.getCompanyClassSeqNo()))
				{
			companyClassRepo.save(this.setCompanyClassMaster(cDTO));
		}
		return;
	}

	public void delAllCompanyClasses() 
	{
		companyClassRepo.deleteAll();
	}

	public void delSelectCompanyClasses(ArrayList<Long> companyUnitSeqNos) 
	{
		companyClassRepo.delSelectCompanyClasses(companyUnitSeqNos);

	}

	private ArrayList<CompanyClassMaster_DTO> getCompanyClassMasterDtos(ArrayList<CompanyClassMaster> cClasss) {
		CompanyClassMaster_DTO cDTO = null;
		ArrayList<CompanyClassMaster_DTO> cDTOs = new ArrayList<CompanyClassMaster_DTO>();

		for (int i = 0; i < cClasss.size(); i++) 
		{
			cDTO = this.getCompanyClassMaster_DTO(cClasss.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyClassMaster_DTO getCompanyClassMaster_DTO(CompanyClassMaster cClass) {
		CompanyClassMaster_DTO cDTO = null;
		cDTO = new CompanyClassMaster_DTO();
		cDTO.setCompanyClassSeqNo(cClass.getCompanyClassSeqNo());
		cDTO.setCompanyClass(cClass.getCompanyClass());
		cDTO.setDescription(cClass.getDescription());
		cDTO.setSpecificationSeqNo(cClass.getSpecificationSeqNo());
		cDTO.setRemark(cClass.getRemark());
		cDTO.setStatus(cClass.getStatus());
		return cDTO;
	}

	private CompanyClassMaster setCompanyClassMaster(CompanyClassMaster_DTO cDTO)
	{
		CompanyClassMaster cClass = new CompanyClassMaster();
		cClass.setCompanyClass(cDTO.getCompanyClass());
		cClass.setDescription(cDTO.getDescription());
		cClass.setSpecificationSeqNo(cDTO.getSpecificationSeqNo());
		cClass.setRemark(cDTO.getRemark());
		cClass.setStatus(cDTO.getStatus());
		return cClass;
	}

}