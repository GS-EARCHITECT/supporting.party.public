package supplier.supplier_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import supplier.supplier_mgmt.model.dto.SupplierMasterDTO;
import supplier.supplier_mgmt.model.master.SupplierMaster;
import supplier.supplier_mgmt.model.repo.SupplierMasterRepo;

@Service("supplierMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class SupplierMasterService implements I_SupplierMasterService {

	@Autowired
	private SupplierMasterRepo supplierMasterRepo;

	public SupplierMasterDTO newSupplier(SupplierMasterDTO lMasters) {
		if (!supplierMasterRepo.existsById(lMasters.getSupplierSeqNo())) {
			lMasters = getSupplierMasterDTO(supplierMasterRepo.save(this.setSupplierMaster(lMasters)));
		}
		return lMasters;
	}

	public ArrayList<SupplierMasterDTO> getAllSuppliers() {
		ArrayList<SupplierMaster> supplierList = (ArrayList<SupplierMaster>) supplierMasterRepo.findAll();
		ArrayList<SupplierMasterDTO> lMasterss = new ArrayList<SupplierMasterDTO>();
		lMasterss = supplierList != null ? this.getSupplierMasterDTOs(supplierList) : null;
		return lMasterss;
	}

	public ArrayList<SupplierMasterDTO> getSelectSuppliers(ArrayList<Long> ids) {
		ArrayList<SupplierMaster> lMasters = supplierMasterRepo.getSelectSuppliers(ids);
		ArrayList<SupplierMasterDTO> supplierMasterDTOs = lMasters != null ? this.getSupplierMasterDTOs(lMasters)
				: null;
		return supplierMasterDTOs;
	}

	public void updSupplier(SupplierMasterDTO lMaster) {
		SupplierMaster supplierMaster = this.setSupplierMaster(lMaster);

		if (supplierMasterRepo.existsById(lMaster.getSupplierSeqNo())) {
			supplierMaster.setSupplierSeqNo(lMaster.getSupplierSeqNo());
			supplierMasterRepo.save(supplierMaster);
		}
		return;
	}

	public void delSelectSuppliers(ArrayList<Long> ids) {
		supplierMasterRepo.delSelectSuppliers(ids);
		return;
	}

	public void delAllSuppliers() {
		supplierMasterRepo.deleteAll();
	}

	private ArrayList<SupplierMasterDTO> getSupplierMasterDTOs(ArrayList<SupplierMaster> lMasters) {
		SupplierMasterDTO lDTO = null;
		ArrayList<SupplierMasterDTO> lMasterDTOs = new ArrayList<SupplierMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getSupplierMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private SupplierMasterDTO getSupplierMasterDTO(SupplierMaster lMaster) {
		SupplierMasterDTO lDTO = new SupplierMasterDTO();
		lDTO.setCompanySeqNo(lMaster.getCompanySeqNo());
		lDTO.setPersonSeqNo(lMaster.getPersonSeqNo());
		lDTO.setRemark(lMaster.getRemark());
		lDTO.setSupplierSeqNo(lMaster.getSupplierSeqNo());
		lDTO.setStatus(lMaster.getStatus());
		return lDTO;
	}

	private SupplierMaster setSupplierMaster(SupplierMasterDTO lDTO) {
		SupplierMaster lMaster = new SupplierMaster();
		lMaster.setCompanySeqNo(lDTO.getCompanySeqNo());
		lMaster.setPersonSeqNo(lDTO.getPersonSeqNo());
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setStatus(lDTO.getStatus());
		return lMaster;
	}
}