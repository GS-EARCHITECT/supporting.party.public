package supplier.supplier_prodservcs.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import supplier.supplier_prodservcs.model.dto.SupplierProdServDetailsDTO;
import supplier.supplier_prodservcs.model.master.SupplierProdServDetails;
import supplier.supplier_prodservcs.model.repo.SupplierProdServDetailsRepo;

@Service("supplierProdServDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class SupplierProdServDetailsService implements I_SupplierProdServDetailsService {

	@Autowired
	private SupplierProdServDetailsRepo supplierProdServDetailsRepo;

	public SupplierProdServDetailsDTO newSupplierProdServDetail(SupplierProdServDetailsDTO lProdServDetailss) {
		if (!supplierProdServDetailsRepo.existsById(lProdServDetailss.getSupplierSeqNo())) {
			lProdServDetailss = getSupplierProdServDetailsDTO(
					supplierProdServDetailsRepo.save(this.setSupplierProdServDetails(lProdServDetailss)));
		}
		return lProdServDetailss;
	}

	public ArrayList<SupplierProdServDetailsDTO> getAllSupplierProdServDetails() {
		ArrayList<SupplierProdServDetails> supplierList = (ArrayList<SupplierProdServDetails>) supplierProdServDetailsRepo
				.findAll();
		ArrayList<SupplierProdServDetailsDTO> lProdServDetailsss = new ArrayList<SupplierProdServDetailsDTO>();
		lProdServDetailsss = supplierList != null ? this.getSupplierProdServDetailsDTOs(supplierList) : null;
		return lProdServDetailsss;
	}

	public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierProdServDetails(ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetails> lProdServDetailss = supplierProdServDetailsRepo
				.getSelectSupplierProdServDetails(ids);
		ArrayList<SupplierProdServDetailsDTO> supplierProdServDetailsDTOs = lProdServDetailss != null
				? this.getSupplierProdServDetailsDTOs(lProdServDetailss)
				: null;
		return supplierProdServDetailsDTOs;
	}

	public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierAssets(ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetails> lProdServDetailss = supplierProdServDetailsRepo.getSelectSupplierAssets(ids);
		ArrayList<SupplierProdServDetailsDTO> supplierProdServDetailsDTOs = lProdServDetailss != null
				? this.getSupplierProdServDetailsDTOs(lProdServDetailss)
				: null;
		return supplierProdServDetailsDTOs;
	}

	public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierResources(ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetails> lProdServDetailss = supplierProdServDetailsRepo
				.getSelectSupplierResources(ids);
		ArrayList<SupplierProdServDetailsDTO> supplierProdServDetailsDTOs = lProdServDetailss != null
				? this.getSupplierProdServDetailsDTOs(lProdServDetailss)
				: null;
		return supplierProdServDetailsDTOs;
	}

	public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierServices(ArrayList<Long> ids) {
		ArrayList<SupplierProdServDetails> lProdServDetailss = supplierProdServDetailsRepo
				.getSelectSupplierServices(ids);
		ArrayList<SupplierProdServDetailsDTO> supplierProdServDetailsDTOs = lProdServDetailss != null
				? this.getSupplierProdServDetailsDTOs(lProdServDetailss)
				: null;
		return supplierProdServDetailsDTOs;
	}

	public void updSupplierProdServDetail(SupplierProdServDetailsDTO lProdServDetails) {
		SupplierProdServDetails supplierProdServDetails = this.setSupplierProdServDetails(lProdServDetails);

		if (supplierProdServDetailsRepo.existsById(lProdServDetails.getSupplierSeqNo())) {
			supplierProdServDetails.setSupplierSeqNo(lProdServDetails.getSupplierSeqNo());
			supplierProdServDetailsRepo.save(supplierProdServDetails);
		}
		return;
	}

	public void delSelectSupplierProdServDetails(ArrayList<Long> ids) {
		supplierProdServDetailsRepo.delSelectSupplierProdServDetails(ids);
		return;
	}

	public void delSelectSupplierAssets(ArrayList<Long> ids) {
		supplierProdServDetailsRepo.delSelectSupplierAssets(ids);
		return;
	}

	public void delSelectSupplierResources(ArrayList<Long> ids) {
		supplierProdServDetailsRepo.delSelectSupplierResources(ids);
		return;
	}

	public void delSelectSupplierServices(ArrayList<Long> ids) {
		supplierProdServDetailsRepo.delSelectSupplierServices(ids);
		return;
	}

	public void delAllSupplierProdServDetails() {
		supplierProdServDetailsRepo.deleteAll();
	}

	private ArrayList<SupplierProdServDetailsDTO> getSupplierProdServDetailsDTOs(
			ArrayList<SupplierProdServDetails> lProdServDetailss) {
		SupplierProdServDetailsDTO lDTO = null;
		ArrayList<SupplierProdServDetailsDTO> lProdServDetailsDTOs = new ArrayList<SupplierProdServDetailsDTO>();
		for (int i = 0; i < lProdServDetailss.size(); i++) {
			lDTO = getSupplierProdServDetailsDTO(lProdServDetailss.get(i));
			lProdServDetailsDTOs.add(lDTO);
		}
		return lProdServDetailsDTOs;
	}

	private SupplierProdServDetailsDTO getSupplierProdServDetailsDTO(SupplierProdServDetails lProdServDetails) {
		SupplierProdServDetailsDTO lDTO = new SupplierProdServDetailsDTO();
		lDTO.setAssetSeqNo(lProdServDetails.getAssetSeqNo());
		lDTO.setResourceSeqNo(lProdServDetails.getResourceSeqNo());
		lDTO.setServiceSeqNo(lProdServDetails.getServiceSeqNo());
		lDTO.setSupplierSeqNo(lProdServDetails.getSupplierSeqNo());
		lDTO.setRemark(lProdServDetails.getRemark());
		lDTO.setSuppProdservSeqNo(lProdServDetails.getSuppProdServSeqNo());
		lDTO.setStatus(lProdServDetails.getStatus());
		return lDTO;
	}

	private SupplierProdServDetails setSupplierProdServDetails(SupplierProdServDetailsDTO lDTO) {
		SupplierProdServDetails lProdServDetails = new SupplierProdServDetails();
		lProdServDetails.setAssetSeqNo(lDTO.getAssetSeqNo());
		lProdServDetails.setResourceSeqNo(lDTO.getResourceSeqNo());
		lProdServDetails.setServiceSeqNo(lDTO.getServiceSeqNo());
		lProdServDetails.setSupplierSeqNo(lDTO.getSupplierSeqNo());
		lProdServDetails.setRemark(lDTO.getRemark());
		lProdServDetails.setStatus(lDTO.getStatus());
		return lProdServDetails;
	}
}