package enterprise.company_unit_roles.master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_roles.master.model.dto.CompanyUnitRoleDTO;
import enterprise.company_unit_roles.master.model.master.CompanyUnitRole;
import enterprise.company_unit_roles.master.model.repo.CompanyUnitRolesRepo;

@Service("companyUnitRolesServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitRolesService implements I_CompanyUnitRolesService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitRoleService.class);
	
	@Autowired
    private CompanyUnitRolesRepo companyUnitRolesRepo;
		
	public CompanyUnitRoleDTO newCompanyUnitRole(CompanyUnitRoleDTO companyRoleDTO) 
	{
		if(!companyUnitRolesRepo.existsById(companyRoleDTO.getCompanyRoleSeqNo()))
		{
		CompanyUnitRole companyUnitRole = companyUnitRolesRepo.save(this.setCompanyUnitRole(companyRoleDTO));
		companyRoleDTO = getCompanyUnitRoleDTO(companyUnitRole);
		}
		return companyRoleDTO;
	}

	public ArrayList<CompanyUnitRoleDTO> getAllCompanyUnitRoles() 
	{
		ArrayList<CompanyUnitRole> companyList = (ArrayList<CompanyUnitRole>) companyUnitRolesRepo.findAll();
		ArrayList<CompanyUnitRoleDTO> companyDTOs = new ArrayList<CompanyUnitRoleDTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitRoleDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyUnitRoleDTO> getSelectCompanyUnitRoles(ArrayList<Long> companySeqNos) 
	{
		ArrayList<CompanyUnitRole> companyList = companyUnitRolesRepo.getSelectCompanyUnitRoles(companySeqNos);
		ArrayList<CompanyUnitRoleDTO> companyDTOs = new ArrayList<CompanyUnitRoleDTO>();		
		companyDTOs = companyList != null ? this.getCompanyUnitRoleDtos(companyList) : null;		
		return companyDTOs;
	}

	public ArrayList<CompanyUnitRoleDTO> getSelectCompanyUnitRolesForUnits(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitRole> companyList = companyUnitRolesRepo.getSelectCompanyUnitRolesForCompanyUnits(ids);
		ArrayList<CompanyUnitRoleDTO> companyDTOs = new ArrayList<CompanyUnitRoleDTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitRoleDtos(companyList) : null;		
		return companyDTOs;
	}
	

	public void updCompanyUnitRole(CompanyUnitRoleDTO companyUnitRoleDTO)
	{

		CompanyUnitRole companyUnitRole = this.setCompanyUnitRole(companyUnitRoleDTO);
		if (companyUnitRolesRepo.existsById(companyUnitRoleDTO.getCompanyRoleSeqNo())) {
			companyUnitRole.setCompanyRoleSeqNo(companyUnitRoleDTO.getCompanyRoleSeqNo());
			companyUnitRolesRepo.save(companyUnitRole);
		}
	}

	public void delCompanyUnitRole(Long companySeqNo) {
		if (companyUnitRolesRepo.existsById(companySeqNo)) {
			companyUnitRolesRepo.deleteById(companySeqNo);
		}
	}
	
	public void delAllCompanyUnitRoles() {
		companyUnitRolesRepo.deleteAll();
	}

	public void delSelectCompanyUnitRoles(ArrayList<Long> companySeqNos) 
	{
	companyUnitRolesRepo.delSelectCompanyUnitRoles(companySeqNos);		
	}
	
	public void delSelectCompanyUnitRolesForUnits(ArrayList<Long> ids) 
	{
	companyUnitRolesRepo.delSelectCompanyUnitRolesForCompanyUnits(ids);		
	}

	private ArrayList<CompanyUnitRoleDTO> getCompanyUnitRoleDtos(ArrayList<CompanyUnitRole> compUnits) {
		CompanyUnitRoleDTO companyDTO = null;
		ArrayList<CompanyUnitRoleDTO> companyDTOs = new ArrayList<CompanyUnitRoleDTO>();

		for (int i = 0; i < compUnits.size(); i++) {
			companyDTO = this.getCompanyUnitRoleDTO(compUnits.get(i));			
			companyDTOs.add(companyDTO);
		}
		return companyDTOs;
	}

	private CompanyUnitRoleDTO getCompanyUnitRoleDTO(CompanyUnitRole compUnitRole) 
	{
		CompanyUnitRoleDTO companyDTO = null;
		companyDTO = new CompanyUnitRoleDTO();
		companyDTO.setCompanyRoleSeqNo(compUnitRole.getCompanyRoleSeqNo());
		companyDTO.setCompanyUnitSeqNo(compUnitRole.getCompanyUnitSeqNo());
		companyDTO.setRoleSeqNo(compUnitRole.getRoleSeqNo());
		companyDTO.setRoleId(compUnitRole.getRoleId());
		companyDTO.setRemark(compUnitRole.getRemark());
		companyDTO.setStatus(compUnitRole.getStatus());		
		return companyDTO;
	}

	private CompanyUnitRole setCompanyUnitRole(CompanyUnitRoleDTO cDTO)
	{
		CompanyUnitRole cUnit = new CompanyUnitRole();
		cUnit.setCompanyUnitSeqNo(cDTO.getCompanyUnitSeqNo());
		cUnit.setRoleSeqNo(cDTO.getRoleSeqNo());
		cUnit.setRoleId(cDTO.getRoleId());
		cUnit.setRemark(cDTO.getRemark());
		cUnit.setStatus(cDTO.getStatus());	
		return cUnit;
	}
	
}