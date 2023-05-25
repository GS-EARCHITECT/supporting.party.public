package enterprise.company_unit_services.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_services.model.dto.CompanyUnitServiceMasterDTO;
import enterprise.company_unit_services.model.master.CompanyUnitServiceMaster;
import enterprise.company_unit_services.model.repo.CompanyUnitServicesRepo;

@Service("companyUnitServicesServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitService implements I_CompanyUnitService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitServiceMasterService.class);
	
	@Autowired
    private CompanyUnitServicesRepo companyUnitServicesRepo;
		
	public CompanyUnitServiceMasterDTO newCompanyUnitService(CompanyUnitServiceMasterDTO companyUnitServiceDTO) 
	{
		if(!companyUnitServicesRepo.existsById(companyUnitServiceDTO.getCompanyServiceSeqNo()))
		{
		CompanyUnitServiceMaster companyUnit = companyUnitServicesRepo.save(this.setCompanyUnitServiceMaster(companyUnitServiceDTO));
		companyUnitServiceDTO = getCompanyUnitServiceMasterDTO(companyUnit);
		}
		return companyUnitServiceDTO;
	}

	public ArrayList<CompanyUnitServiceMasterDTO> getAllCompanyUnitServices() 
	{
		ArrayList<CompanyUnitServiceMaster> companyList = (ArrayList<CompanyUnitServiceMaster>) companyUnitServicesRepo.findAll();
		ArrayList<CompanyUnitServiceMasterDTO> companyUnitServiceDTOs = new ArrayList<CompanyUnitServiceMasterDTO>();
		companyUnitServiceDTOs = companyList != null ? this.getCompanyUnitServiceMasterDtos(companyList) : null;
		return companyUnitServiceDTOs;
	}

	public ArrayList<CompanyUnitServiceMasterDTO> getSelectCompanyUnitServices(ArrayList<Long> companySeqNos) 
	{
		ArrayList<CompanyUnitServiceMaster> companyList = companyUnitServicesRepo.getSelectCompanyUnitServices(companySeqNos);
		ArrayList<CompanyUnitServiceMasterDTO> companyUnitServiceDTOs = new ArrayList<CompanyUnitServiceMasterDTO>();
		companyUnitServiceDTOs = companyList != null ? this.getCompanyUnitServiceMasterDtos(companyList) : null;
		return companyUnitServiceDTOs;
	}

	public ArrayList<CompanyUnitServiceMasterDTO> getSelectCompanyUnitServicesForUnits(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitServiceMaster> companyList = companyUnitServicesRepo.getSelectCompanyUnitServices(ids);
		ArrayList<CompanyUnitServiceMasterDTO> companyUnitServiceDTOs = new ArrayList<CompanyUnitServiceMasterDTO>();
		companyUnitServiceDTOs = companyList != null ? this.getCompanyUnitServiceMasterDtos(companyList) : null;		
		return companyUnitServiceDTOs;
	}
	

	public void updCompanyUnitService(CompanyUnitServiceMasterDTO companyUnitServiceDTO) {

		CompanyUnitServiceMaster companyUnit = this.setCompanyUnitServiceMaster(companyUnitServiceDTO);
		if (companyUnitServicesRepo.existsById(companyUnitServiceDTO.getCompanyServiceSeqNo())) {
			companyUnit.setCompanyServiceSeqNo(companyUnitServiceDTO.getCompanyServiceSeqNo());
			companyUnitServicesRepo.save(companyUnit);
		}
	}

	public void delCompanyUnitService(Long companySeqNo) 
	{
		if (companyUnitServicesRepo.existsById(companySeqNo)) {
			companyUnitServicesRepo.deleteById(companySeqNo);
		}
	}
	
	public void delAllCompanyUnitServices() {
		companyUnitServicesRepo.deleteAll();
	}

	public void delSelectCompanyUnitServices(ArrayList<Long> companyUnitSeqNos) 
	{
	companyUnitServicesRepo.delSelectCompanyUnitServices(companyUnitSeqNos);		
	}
	
	public void delSelectCompanyUnitServicesForUnits(ArrayList<Long> ids) 
	{
	companyUnitServicesRepo.delSelectCompanyUnitServicesForCompanyUnits(ids);		
	}

	private ArrayList<CompanyUnitServiceMasterDTO> getCompanyUnitServiceMasterDtos(ArrayList<CompanyUnitServiceMaster> compUnits) {
		CompanyUnitServiceMasterDTO companyUnitServiceDTO = null;
		ArrayList<CompanyUnitServiceMasterDTO> companyUnitServiceDTOs = new ArrayList<CompanyUnitServiceMasterDTO>();

		for (int i = 0; i < compUnits.size(); i++) {
			companyUnitServiceDTO = this.getCompanyUnitServiceMasterDTO(compUnits.get(i));			
			companyUnitServiceDTOs.add(companyUnitServiceDTO);
		}
		return companyUnitServiceDTOs;
	}

	private CompanyUnitServiceMasterDTO getCompanyUnitServiceMasterDTO(CompanyUnitServiceMaster compUnit) 
	{
		CompanyUnitServiceMasterDTO companyUnitServiceDTO = null;
		companyUnitServiceDTO = new CompanyUnitServiceMasterDTO();
		companyUnitServiceDTO.setCompanyServiceSeqNo(compUnit.getCompanyServiceSeqNo());
		companyUnitServiceDTO.setCompanyUnitSeqNo(compUnit.getCompanyUnitSeqNo());
		companyUnitServiceDTO.setServiceSeqNo(compUnit.getServiceSeqNo());
		companyUnitServiceDTO.setRemark(compUnit.getRemark());
		companyUnitServiceDTO.setStatus(compUnit.getStatus());		
		return companyUnitServiceDTO;
	}

	private CompanyUnitServiceMaster setCompanyUnitServiceMaster(CompanyUnitServiceMasterDTO cDTO)
	{
		CompanyUnitServiceMaster cUnit = new CompanyUnitServiceMaster();
		cUnit.setCompanyUnitSeqNo(cUnit.getCompanyUnitSeqNo());
		cUnit.setServiceSeqNo(cUnit.getServiceSeqNo());
		cUnit.setRemark(cUnit.getRemark());
		cUnit.setStatus(cUnit.getStatus());
		return cUnit;
	}
	
}