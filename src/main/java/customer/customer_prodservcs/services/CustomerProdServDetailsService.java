package customer.customer_prodservcs.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import customer.customer_prodservcs.model.dto.CustomerProdServDetailsDTO;
import customer.customer_prodservcs.model.master.CustomerProdServDetails;
import customer.customer_prodservcs.model.repo.CustomerProdServDetailsRepo;

@Service("customerProdServDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CustomerProdServDetailsService implements I_CustomerProdServDetailsService {

	@Autowired
	private CustomerProdServDetailsRepo customerProdServDetailsRepo;

	public CustomerProdServDetailsDTO newCustomerProdServDetail(CustomerProdServDetailsDTO lProdServDetailss) {
		if (!customerProdServDetailsRepo.existsById(lProdServDetailss.getCustomerSeqNo())) {
			lProdServDetailss = getCustomerProdServDetailsDTO(
					customerProdServDetailsRepo.save(this.setCustomerProdServDetails(lProdServDetailss)));
		}
		return lProdServDetailss;
	}

	public ArrayList<CustomerProdServDetailsDTO> getAllCustomerProdServDetails() {
		ArrayList<CustomerProdServDetails> customerList = (ArrayList<CustomerProdServDetails>) customerProdServDetailsRepo
				.findAll();
		ArrayList<CustomerProdServDetailsDTO> lProdServDetailsss = new ArrayList<CustomerProdServDetailsDTO>();
		lProdServDetailsss = customerList != null ? this.getCustomerProdServDetailsDTOs(customerList) : null;
		return lProdServDetailsss;
	}

	public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerProdServDetails(ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetails> lProdServDetailss = customerProdServDetailsRepo
				.getSelectCustomerProdServDetails(ids);
		ArrayList<CustomerProdServDetailsDTO> customerProdServDetailsDTOs = lProdServDetailss != null
				? this.getCustomerProdServDetailsDTOs(lProdServDetailss)
				: null;
		return customerProdServDetailsDTOs;
	}

	public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerAssets(ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetails> lProdServDetailss = customerProdServDetailsRepo.getSelectCustomerAssets(ids);
		ArrayList<CustomerProdServDetailsDTO> customerProdServDetailsDTOs = lProdServDetailss != null
				? this.getCustomerProdServDetailsDTOs(lProdServDetailss)
				: null;
		return customerProdServDetailsDTOs;
	}

	public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerResources(ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetails> lProdServDetailss = customerProdServDetailsRepo
				.getSelectCustomerResources(ids);
		ArrayList<CustomerProdServDetailsDTO> customerProdServDetailsDTOs = lProdServDetailss != null
				? this.getCustomerProdServDetailsDTOs(lProdServDetailss)
				: null;
		return customerProdServDetailsDTOs;
	}

	public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerServices(ArrayList<Long> ids) {
		ArrayList<CustomerProdServDetails> lProdServDetailss = customerProdServDetailsRepo
				.getSelectCustomerServices(ids);
		ArrayList<CustomerProdServDetailsDTO> customerProdServDetailsDTOs = lProdServDetailss != null
				? this.getCustomerProdServDetailsDTOs(lProdServDetailss)
				: null;
		return customerProdServDetailsDTOs;
	}

	public void updCustomerProdServDetail(CustomerProdServDetailsDTO lProdServDetails) {
		CustomerProdServDetails customerProdServDetails = this.setCustomerProdServDetails(lProdServDetails);

		if (customerProdServDetailsRepo.existsById(lProdServDetails.getCustomerSeqNo())) {
			customerProdServDetails.setCustomerSeqNo(lProdServDetails.getCustomerSeqNo());
			customerProdServDetailsRepo.save(customerProdServDetails);
		}
		return;
	}

	public void delSelectCustomerProdServDetails(ArrayList<Long> ids) {
		customerProdServDetailsRepo.delSelectCustomerProdServDetails(ids);
		return;
	}

	public void delSelectCustomerAssets(ArrayList<Long> ids) {
		customerProdServDetailsRepo.delSelectCustomerAssets(ids);
		return;
	}

	public void delSelectCustomerResources(ArrayList<Long> ids) {
		customerProdServDetailsRepo.delSelectCustomerResources(ids);
		return;
	}

	public void delSelectCustomerServices(ArrayList<Long> ids) {
		customerProdServDetailsRepo.delSelectCustomerServices(ids);
		return;
	}

	public void delAllCustomerProdServDetails() {
		customerProdServDetailsRepo.deleteAll();
	}

	private ArrayList<CustomerProdServDetailsDTO> getCustomerProdServDetailsDTOs(
			ArrayList<CustomerProdServDetails> lProdServDetailss) {
		CustomerProdServDetailsDTO lDTO = null;
		ArrayList<CustomerProdServDetailsDTO> lProdServDetailsDTOs = new ArrayList<CustomerProdServDetailsDTO>();
		for (int i = 0; i < lProdServDetailss.size(); i++) {
			lDTO = getCustomerProdServDetailsDTO(lProdServDetailss.get(i));
			lProdServDetailsDTOs.add(lDTO);
		}
		return lProdServDetailsDTOs;
	}

	private CustomerProdServDetailsDTO getCustomerProdServDetailsDTO(CustomerProdServDetails lProdServDetails) {
		CustomerProdServDetailsDTO lDTO = new CustomerProdServDetailsDTO();
		lDTO.setAssetSeqNo(lProdServDetails.getAssetSeqNo());
		lDTO.setResourceSeqNo(lProdServDetails.getResourceSeqNo());
		lDTO.setServiceSeqNo(lProdServDetails.getServiceSeqNo());
		lDTO.setCustomerSeqNo(lProdServDetails.getCustomerSeqNo());
		lDTO.setRemark(lProdServDetails.getRemark());
		lDTO.setCustProdServSeqNo(lProdServDetails.getCustProdServSeqNo());
		lDTO.setStatus(lProdServDetails.getStatus());
		return lDTO;
	}

	private CustomerProdServDetails setCustomerProdServDetails(CustomerProdServDetailsDTO lDTO) {
		CustomerProdServDetails lProdServDetails = new CustomerProdServDetails();
		lProdServDetails.setAssetSeqNo(lDTO.getAssetSeqNo());
		lProdServDetails.setResourceSeqNo(lDTO.getResourceSeqNo());
		lProdServDetails.setServiceSeqNo(lDTO.getServiceSeqNo());
		lProdServDetails.setCustomerSeqNo(lDTO.getCustomerSeqNo());
		lProdServDetails.setRemark(lDTO.getRemark());
		lProdServDetails.setStatus(lDTO.getStatus());
		return lProdServDetails;
	}
}