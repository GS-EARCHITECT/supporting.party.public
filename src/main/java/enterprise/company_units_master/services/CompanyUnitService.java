package enterprise.company_units_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.company_units_master.model.dto.CompanyUnitDTO;
import enterprise.company_units_master.model.master.CompanyUnit;
import enterprise.company_units_master.model.repo.CompanyUnitRepo;

@Service("companyUnitServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitService implements I_CompanyUnitService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitService.class);
	
	@Autowired
    private CompanyUnitRepo companyRepo;
		
	public CompanyUnitDTO newCompanyUnit(CompanyUnitDTO companyDTO) 
	{
		if(!companyRepo.existsById(companyDTO.getCompanySeqNo()))
		{
		CompanyUnit companyUnit = companyRepo.save(this.setCompanyUnit(companyDTO));
		companyDTO = getCompanyUnitDTO(companyUnit);
		}
		return companyDTO;
	}

	public ArrayList<CompanyUnitDTO> getAllCompanyUnits() 
	{
		ArrayList<CompanyUnit> companyList = (ArrayList<CompanyUnit>) companyRepo.findAll();
		ArrayList<CompanyUnitDTO> companyDTOs = new ArrayList<CompanyUnitDTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyUnitDTO> getSelectCompanyUnits(ArrayList<Long> companySeqNos) 
	{
		ArrayList<CompanyUnit> companyList = companyRepo.getSelectCompanyUnits(companySeqNos);
		ArrayList<CompanyUnitDTO> companyDTOs = new ArrayList<CompanyUnitDTO>();
		CompanyUnitDTO companyUnitDTO = null;

		for (int i = 0; i < companySeqNos.size(); i++) 
		{
			companyUnitDTO = this.getCompanyUnitDTO(companyList.get(i));			
			companyDTOs.add(companyUnitDTO);
		}
		
		return companyDTOs;
	}

	public ArrayList<CompanyUnitDTO> getSelectCompanyUnitsForUnitTypes(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnit> companyList = companyRepo.getSelectCompanyUnits(ids);
		ArrayList<CompanyUnitDTO> companyDTOs = new ArrayList<CompanyUnitDTO>();
		CompanyUnitDTO companyUnitDTO = null;

		for (int i = 0; i < companyList.size(); i++) 
		{
			companyUnitDTO = this.getCompanyUnitDTO(companyList.get(i));			
			companyDTOs.add(companyUnitDTO);
		}
		
		return companyDTOs;
	}
	

	public void updCompanyUnit(CompanyUnitDTO companyDTO) {

		CompanyUnit companyUnit = this.setCompanyUnit(companyDTO);
		if (companyRepo.existsById(companyDTO.getCompanySeqNo())) {
			companyUnit.setCompanySeqNo(companyDTO.getCompanySeqNo());
			companyRepo.save(companyUnit);
		}
	}

	public void delCompanyUnit(Long companySeqNo) {
		if (companyRepo.existsById(companySeqNo)) {
			companyRepo.deleteById(companySeqNo);
		}
	}
	
	public void delAllCompanyUnits() {
		companyRepo.deleteAll();
	}

	public void delSelectCompanyUnits(ArrayList<Long> companySeqNos) 
	{
	companyRepo.delSelectCompanyUnits(companySeqNos);		
	}
	
	public void delSelectCompanyUnitsForUnitTypes(ArrayList<Long> ids) 
	{
	companyRepo.delSelectCompanyUnitsForUnitTypes(ids);		
	}

	private ArrayList<CompanyUnitDTO> getCompanyUnitDtos(ArrayList<CompanyUnit> compUnits) {
		CompanyUnitDTO companyDTO = null;
		ArrayList<CompanyUnitDTO> companyDTOs = new ArrayList<CompanyUnitDTO>();

		for (int i = 0; i < compUnits.size(); i++) {
			companyDTO = this.getCompanyUnitDTO(compUnits.get(i));			
			companyDTOs.add(companyDTO);
		}
		return companyDTOs;
	}

	private CompanyUnitDTO getCompanyUnitDTO(CompanyUnit compUnit) 
	{
		CompanyUnitDTO companyDTO = null;
		companyDTO = new CompanyUnitDTO();
		companyDTO.setCompanyUnitSequenceNo(compUnit.getCompanyUnitSequenceNo());
		companyDTO.setUnitSeqNo(compUnit.getUnitSeqNo());
		companyDTO.setCompanyUnitClassSequenceNo(compUnit.getCompanyUnitClassSequenceNo());
		companyDTO.setCompanySeqNo(compUnit.getCompanySeqNo());
		companyDTO.setCompanyUnit(compUnit.getCompanyUnit());		
		companyDTO.setRemark(compUnit.getRemark());
		companyDTO.setStatus(compUnit.getStatus());
		companyDTO.setDescription(compUnit.getDescription());
		return companyDTO;
	}

	private CompanyUnit setCompanyUnit(CompanyUnitDTO cDTO)
	{
		CompanyUnit cUnit = new CompanyUnit();		
		cUnit.setUnitSeqNo(cDTO.getUnitSeqNo());
		cUnit.setCompanyUnitClassSequenceNo(cDTO.getCompanyUnitClassSequenceNo());
		cUnit.setCompanySeqNo(cDTO.getCompanySeqNo());
		cUnit.setCompanyUnit(cDTO.getCompanyUnit());		
		cUnit.setRemark(cDTO.getRemark());
		cUnit.setStatus(cDTO.getStatus());
		cUnit.setDescription(cDTO.getDescription());
		return cUnit;
	}
	
}