package enterprise.company_unit_class_structure.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_class_structure.model.dto.CompanyUnitClassStructure_DTO;
import enterprise.company_unit_class_structure.model.master.CompanyUnitClassStructure;
import enterprise.company_unit_class_structure.model.master.CompanyUnitClassStructurePK;
import enterprise.company_unit_class_structure.model.repo.CompanyUnitClassStructure_Repo;

@Service("companyUnitClassStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitClassStructure_Service implements I_CompanyUnitClassStructure_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitClassStructureService.class);
	
	@Autowired
    private CompanyUnitClassStructure_Repo companyUnitClassStructureRepo;
		
	public CompanyUnitClassStructure_DTO newCompanyUnitClassStructure(CompanyUnitClassStructure_DTO companyUnitDTO) 
	{
		CompanyUnitClassStructurePK companyUnitClassStructurePK = new CompanyUnitClassStructurePK();
		companyUnitClassStructurePK.setCompanySeqNo(companyUnitDTO.getCompanySeqNo());
		companyUnitClassStructurePK.setUnitClassSeqNo(companyUnitDTO.getUnitClassSeqNo());
		companyUnitClassStructurePK.setParUnitClassSeqNo(companyUnitDTO.getParUnitClassSeqNo());
		
		if(!companyUnitClassStructureRepo.existsById(companyUnitClassStructurePK))
		{
		CompanyUnitClassStructure companyUnitClassStructure = companyUnitClassStructureRepo.save(this.setCompanyUnitClassStructure(companyUnitDTO));
		companyUnitDTO = getCompanyUnitClassStructure_DTO(companyUnitClassStructure);
		}
		return companyUnitDTO;
	}

	public ArrayList<CompanyUnitClassStructure_DTO> getAllCompanyUnitClassStructures() 
	{
		ArrayList<CompanyUnitClassStructure> companyUnitList = (ArrayList<CompanyUnitClassStructure>) companyUnitClassStructureRepo.findAll();
		ArrayList<CompanyUnitClassStructure_DTO> companyUnitDTOs = new ArrayList<CompanyUnitClassStructure_DTO>();
		companyUnitDTOs = companyUnitList != null ? this.getCompanyUnitClassStructureDtos(companyUnitList) : null;
		return companyUnitDTOs;
	}

	public ArrayList<CompanyUnitClassStructure_DTO> getSelectCompanyUnitClassStructures(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitClassStructure> companyUnitClassList = companyUnitClassStructureRepo.getSelectCompanyUnitClassStructures(ids);
		ArrayList<CompanyUnitClassStructure_DTO> companyUnitClassDTOs = new ArrayList<CompanyUnitClassStructure_DTO>();
		companyUnitClassDTOs = companyUnitClassList != null ? this.getCompanyUnitClassStructureDtos(companyUnitClassList) : null;		
		return companyUnitClassDTOs;
	}

	public ArrayList<CompanyUnitClassStructure_DTO> getSelectCompanyUnitClassStructuresForParentClasses(ArrayList<Long> ids, ArrayList<Long> pids) 
	{
		ArrayList<CompanyUnitClassStructure> companyUnitClassList = companyUnitClassStructureRepo.getSelectCompanyUnitClassStructuresForParentClasses(ids, pids);;
		ArrayList<CompanyUnitClassStructure_DTO> companyUnitClassDTOs = new ArrayList<CompanyUnitClassStructure_DTO>();
		companyUnitClassDTOs = companyUnitClassList != null ? this.getCompanyUnitClassStructureDtos(companyUnitClassList) : null;		
		return companyUnitClassDTOs;
	}	

	public ArrayList<CompanyUnitClassStructure_DTO> getSelectCompanyUnitClassStructuresForChildClasses(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		ArrayList<CompanyUnitClassStructure> companyUnitClassList = companyUnitClassStructureRepo.getSelectCompanyUnitClassStructuresForChildClasses(ids, cids);
		ArrayList<CompanyUnitClassStructure_DTO> companyUnitClassDTOs = new ArrayList<CompanyUnitClassStructure_DTO>();
		companyUnitClassDTOs = companyUnitClassList != null ? this.getCompanyUnitClassStructureDtos(companyUnitClassList) : null;		
		return companyUnitClassDTOs;
	}
	
	public void updCompanyUnitClassStructure(CompanyUnitClassStructure_DTO companyUnitClassStructureDTO) 
	{		
		CompanyUnitClassStructurePK companyUnitClassStructurePK = new CompanyUnitClassStructurePK();
		companyUnitClassStructurePK.setCompanySeqNo(companyUnitClassStructureDTO.getCompanySeqNo());
		companyUnitClassStructurePK.setUnitClassSeqNo(companyUnitClassStructureDTO.getUnitClassSeqNo());
		companyUnitClassStructurePK.setParUnitClassSeqNo(companyUnitClassStructureDTO.getParUnitClassSeqNo());
		
		if (companyUnitClassStructureRepo.existsById(companyUnitClassStructurePK)) 
		{
			CompanyUnitClassStructure companyUnitClassStructure = this.setCompanyUnitClassStructure(companyUnitClassStructureDTO);			
			companyUnitClassStructureRepo.save(companyUnitClassStructure);
		}
	}

	public void delAllCompanyUnitClassStructures() 
	{
		companyUnitClassStructureRepo.deleteAll();
	}

	public void delSelectCompanyUnitClassStructures(ArrayList<Long> ids) 
	{
	companyUnitClassStructureRepo.delSelectCompanyUnitClassStructures(ids);		
	}
	
	public void delSelectCompanyUnitClassStructuresForParentClasses(ArrayList<Long> ids, ArrayList<Long> pids) 
	{
	companyUnitClassStructureRepo.delSelectCompanyUnitClassStructuresForParentClasses(ids,  pids);		
	}

	public void delSelectCompanyUnitClassStructuresForChildClasses(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
	companyUnitClassStructureRepo.delSelectCompanyUnitClassStructuresForChildClasses(ids,  cids);		
	}
		
	private ArrayList<CompanyUnitClassStructure_DTO> getCompanyUnitClassStructureDtos(ArrayList<CompanyUnitClassStructure> compClassStructures) {
		CompanyUnitClassStructure_DTO companyUnitDTO = null;
		ArrayList<CompanyUnitClassStructure_DTO> companyUnitDTOs = new ArrayList<CompanyUnitClassStructure_DTO>();

		for (int i = 0; i < compClassStructures.size(); i++) {
			companyUnitDTO = this.getCompanyUnitClassStructure_DTO(compClassStructures.get(i));			
			companyUnitDTOs.add(companyUnitDTO);
		}
		return companyUnitDTOs;
	}

	private CompanyUnitClassStructure_DTO getCompanyUnitClassStructure_DTO(CompanyUnitClassStructure compClassStructure) 
	{
		CompanyUnitClassStructure_DTO companyUnitDTO = null;
		companyUnitDTO = new CompanyUnitClassStructure_DTO();
		companyUnitDTO.setCompanySeqNo(compClassStructure.getId().getCompanySeqNo());
		companyUnitDTO.setUnitClassSeqNo(compClassStructure.getId().getUnitClassSeqNo());
		companyUnitDTO.setParUnitClassSeqNo(compClassStructure.getId().getParUnitClassSeqNo());		
		return companyUnitDTO;
	}

	private CompanyUnitClassStructure setCompanyUnitClassStructure(CompanyUnitClassStructure_DTO cDTO) 
	{
		CompanyUnitClassStructurePK companyUnitClassStructurePK = new CompanyUnitClassStructurePK();
		companyUnitClassStructurePK.setCompanySeqNo(cDTO.getCompanySeqNo());
		companyUnitClassStructurePK.setParUnitClassSeqNo(cDTO.getParUnitClassSeqNo());			
		companyUnitClassStructurePK.setUnitClassSeqNo(cDTO.getUnitClassSeqNo());
		CompanyUnitClassStructure cClassStructure = new CompanyUnitClassStructure();		
		cClassStructure.setId(companyUnitClassStructurePK);
		return cClassStructure;
	}
	
}