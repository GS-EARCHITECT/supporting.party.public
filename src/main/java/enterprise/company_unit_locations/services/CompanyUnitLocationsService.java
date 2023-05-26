package enterprise.company_unit_locations.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_locations.model.dto.CompanyUnitLocationDTO;
import enterprise.company_unit_locations.model.master.CompanyUnitLocation;
import enterprise.company_unit_locations.model.repo.CompanyUnitLocationsRepo;

@Service("companyUnitLocationsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitLocationsService implements I_CompanyUnitLocationsService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitLocationService.class);
	
	@Autowired
    private CompanyUnitLocationsRepo companyUnitLocationsRepo;
		
	public CompanyUnitLocationDTO newCompanyUnitLocation(CompanyUnitLocationDTO companyLocationDTO) 
	{
		if(!companyUnitLocationsRepo.existsById(companyLocationDTO.getCompanyLocationSeqNo()))
		{
		CompanyUnitLocation companyUnitLocation = companyUnitLocationsRepo.save(this.setCompanyUnitLocation(companyLocationDTO));
		companyLocationDTO = getCompanyUnitLocationDTO(companyUnitLocation);
		}
		return companyLocationDTO;
	}

	public ArrayList<CompanyUnitLocationDTO> getAllCompanyUnitLocations() 
	{
		ArrayList<CompanyUnitLocation> companyList = (ArrayList<CompanyUnitLocation>) companyUnitLocationsRepo.findAll();
		ArrayList<CompanyUnitLocationDTO> companyDTOs = new ArrayList<CompanyUnitLocationDTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitLocationDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyUnitLocationDTO> getSelectCompanyUnitLocations(ArrayList<Long> companySeqNos) 
	{
		ArrayList<CompanyUnitLocation> companyList = companyUnitLocationsRepo.getSelectCompanyUnitLocations(companySeqNos);
		ArrayList<CompanyUnitLocationDTO> companyDTOs = new ArrayList<CompanyUnitLocationDTO>();		
		companyDTOs = companyList != null ? this.getCompanyUnitLocationDtos(companyList) : null;		
		return companyDTOs;
	}

	public ArrayList<CompanyUnitLocationDTO> getSelectCompanyUnitLocationsForUnits(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitLocation> companyList = companyUnitLocationsRepo.getSelectCompanyUnitLocationsForCompanyUnits(ids);
		ArrayList<CompanyUnitLocationDTO> companyDTOs = new ArrayList<CompanyUnitLocationDTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitLocationDtos(companyList) : null;		
		return companyDTOs;
	}
	

	public void updCompanyUnitLocation(CompanyUnitLocationDTO companyUnitLocationDTO)
	{

		CompanyUnitLocation companyUnitLocation = this.setCompanyUnitLocation(companyUnitLocationDTO);
		if (companyUnitLocationsRepo.existsById(companyUnitLocationDTO.getCompanyLocationSeqNo())) {
			companyUnitLocation.setCompanyLocationSeqNo(companyUnitLocationDTO.getCompanyLocationSeqNo());
			companyUnitLocationsRepo.save(companyUnitLocation);
		}
	}

	public void delCompanyUnitLocation(Long companySeqNo) {
		if (companyUnitLocationsRepo.existsById(companySeqNo)) {
			companyUnitLocationsRepo.deleteById(companySeqNo);
		}
	}
	
	public void delAllCompanyUnitLocations() {
		companyUnitLocationsRepo.deleteAll();
	}

	public void delSelectCompanyUnitLocations(ArrayList<Long> companySeqNos) 
	{
	companyUnitLocationsRepo.delSelectCompanyUnitLocations(companySeqNos);		
	}
	
	public void delSelectCompanyUnitLocationsForUnits(ArrayList<Long> ids) 
	{
	companyUnitLocationsRepo.delSelectCompanyUnitLocationsForCompanyUnits(ids);		
	}

	private ArrayList<CompanyUnitLocationDTO> getCompanyUnitLocationDtos(ArrayList<CompanyUnitLocation> compUnits) {
		CompanyUnitLocationDTO companyDTO = null;
		ArrayList<CompanyUnitLocationDTO> companyDTOs = new ArrayList<CompanyUnitLocationDTO>();

		for (int i = 0; i < compUnits.size(); i++) {
			companyDTO = this.getCompanyUnitLocationDTO(compUnits.get(i));			
			companyDTOs.add(companyDTO);
		}
		return companyDTOs;
	}

	private CompanyUnitLocationDTO getCompanyUnitLocationDTO(CompanyUnitLocation compUnitLocation) 
	{
		CompanyUnitLocationDTO companyDTO = null;
		companyDTO = new CompanyUnitLocationDTO();
		companyDTO.setCompanyLocationSeqNo(compUnitLocation.getCompanyLocationSeqNo());
		companyDTO.setCompanyUnitSeqNo(compUnitLocation.getCompanyUnitSeqNo());
		companyDTO.setLocationSeqNo(compUnitLocation.getLocationSeqNo());		
		companyDTO.setRemark(compUnitLocation.getRemark());
		companyDTO.setStatus(compUnitLocation.getStatus());		
		return companyDTO;
	}

	private CompanyUnitLocation setCompanyUnitLocation(CompanyUnitLocationDTO cDTO)
	{
		CompanyUnitLocation cUnit = new CompanyUnitLocation();		
		cUnit.setLocationSeqNo(cDTO.getLocationSeqNo());		
		cUnit.setRemark(cDTO.getRemark());
		cUnit.setStatus(cDTO.getStatus());	
		return cUnit;
	}
	
}