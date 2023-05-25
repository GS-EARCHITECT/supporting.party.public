package enterprise.masters.unit.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.masters.unit.model.dto.CompanyUnitMasterDTO;
import enterprise.masters.unit.model.master.CompanyUnitMaster;
import enterprise.masters.unit.model.repo.CompanyUnitMasterRepo;

@Service("roleServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitMasterService implements I_CompanyUnitMasterService 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyUnitMasterService.class);

	@Autowired
	private CompanyUnitMasterRepo roleRepo;

	public CompanyUnitMasterDTO newUnit(CompanyUnitMasterDTO cDTO) {
		if (!roleRepo.existsById(cDTO.getUnitSeqNo())) {
			CompanyUnitMaster roleMaster = roleRepo.save(this.setCompanyUnitMaster(cDTO));
			cDTO = getCompanyUnitMasterDTO(roleMaster);
		}
		return cDTO;
	}

	public ArrayList<CompanyUnitMasterDTO> getAllUnits() {
		ArrayList<CompanyUnitMaster> roleList = (ArrayList<CompanyUnitMaster>) roleRepo.findAll();
		ArrayList<CompanyUnitMasterDTO> cDTOs = new ArrayList<CompanyUnitMasterDTO>();
		cDTOs = roleList != null ? this.getCompanyUnitMasterDtos(roleList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyUnitMasterDTO> getSelectUnits(ArrayList<Long> roleSeqNos) {
		ArrayList<CompanyUnitMasterDTO> cDTOs = new ArrayList<CompanyUnitMasterDTO>();
		CompanyUnitMasterDTO roleMasterDTO = null;
		ArrayList<CompanyUnitMaster> roleMasters = (ArrayList<CompanyUnitMaster>) roleRepo.findAll();
		cDTOs = roleMasters != null ? this.getCompanyUnitMasterDtos(roleMasters) : null;
		return cDTOs;
	}

	public void updUnit(CompanyUnitMasterDTO cDTO) {
		if (roleRepo.existsById(cDTO.getUnitSeqNo())) {
			roleRepo.save(this.setCompanyUnitMaster(cDTO));
		}
		return;
	}

	public void delAllUnits() {
		roleRepo.deleteAll();
	}

	public void delSelectUnits(ArrayList<Long> roleSeqNos) 
	{
		roleRepo.delSelectUnits(roleSeqNos);

	}

	private ArrayList<CompanyUnitMasterDTO> getCompanyUnitMasterDtos(ArrayList<CompanyUnitMaster> cMasters) {
		CompanyUnitMasterDTO cDTO = null;
		ArrayList<CompanyUnitMasterDTO> cDTOs = new ArrayList<CompanyUnitMasterDTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getCompanyUnitMasterDTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyUnitMasterDTO getCompanyUnitMasterDTO(CompanyUnitMaster cMaster) {
		CompanyUnitMasterDTO cDTO = null;
		cDTO = new CompanyUnitMasterDTO();
		cDTO.setUnitSeqNo(cMaster.getUnitSeqNo());
		cDTO.setUnitClassSeqNo(cMaster.getUnitClassSeqNo());
		cDTO.setUnit(cMaster.getUnit());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setStatus(cMaster.getStatus());
		return cDTO;
	}

	private CompanyUnitMaster setCompanyUnitMaster(CompanyUnitMasterDTO cDTO) {
		CompanyUnitMaster cMaster = new CompanyUnitMaster();
		cMaster.setUnit(cDTO.getUnit());
		cMaster.setUnitClassSeqNo(cDTO.getUnitClassSeqNo());
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setStatus(cMaster.getStatus());
		return cMaster;
	}

}