package customer.customer_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import customer.customer_mgmt.model.dto.CustomerMasterDTO;
import customer.customer_mgmt.model.master.CustomerMaster;
import customer.customer_mgmt.model.repo.CustomerMasterRepo;

@Service("customerMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CustomerMasterService implements I_CustomerMasterService {

	@Autowired
	private CustomerMasterRepo customerMasterRepo;

	public CustomerMasterDTO newCustomer(CustomerMasterDTO lMasters) {
		if (!customerMasterRepo.existsById(lMasters.getCustomerSeqNo())) {
			lMasters = getCustomerMasterDTO(customerMasterRepo.save(this.setCustomerMaster(lMasters)));
		}
		return lMasters;
	}

	public ArrayList<CustomerMasterDTO> getAllCustomers() {
		ArrayList<CustomerMaster> customerList = (ArrayList<CustomerMaster>) customerMasterRepo.findAll();
		ArrayList<CustomerMasterDTO> lMasterss = new ArrayList<CustomerMasterDTO>();
		lMasterss = customerList != null ? this.getCustomerMasterDTOs(customerList) : null;
		return lMasterss;
	}

	public ArrayList<CustomerMasterDTO> getSelectCustomers(ArrayList<Long> ids) {
		ArrayList<CustomerMaster> lMasters = customerMasterRepo.getSelectCustomers(ids);
		ArrayList<CustomerMasterDTO> customerMasterDTOs = lMasters != null ? this.getCustomerMasterDTOs(lMasters)
				: null;
		return customerMasterDTOs;
	}

	public void updCustomer(CustomerMasterDTO lMaster) {
		CustomerMaster customerMaster = this.setCustomerMaster(lMaster);

		if (customerMasterRepo.existsById(lMaster.getCustomerSeqNo())) {
			customerMaster.setCustomerSeqNo(lMaster.getCustomerSeqNo());
			customerMasterRepo.save(customerMaster);
		}
		return;
	}

	public void delSelectCustomers(ArrayList<Long> ids) {
		customerMasterRepo.delSelectCustomers(ids);
		return;
	}

	public void delAllCustomers() {
		customerMasterRepo.deleteAll();
	}

	private ArrayList<CustomerMasterDTO> getCustomerMasterDTOs(ArrayList<CustomerMaster> lMasters) {
		CustomerMasterDTO lDTO = null;
		ArrayList<CustomerMasterDTO> lMasterDTOs = new ArrayList<CustomerMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getCustomerMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private CustomerMasterDTO getCustomerMasterDTO(CustomerMaster lMaster) {
		CustomerMasterDTO lDTO = new CustomerMasterDTO();
		lDTO.setPartySeqNo(lMaster.getPartySeqNo());		
		lDTO.setRemark(lMaster.getRemark());
		lDTO.setCustomerSeqNo(lMaster.getCustomerSeqNo());
		lDTO.setStatus(lMaster.getStatus());
		return lDTO;
	}

	private CustomerMaster setCustomerMaster(CustomerMasterDTO lDTO) 
	{
		CustomerMaster lMaster = new CustomerMaster();
		lMaster.setPartySeqNo(lDTO.getPartySeqNo());
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setStatus(lDTO.getStatus());
		return lMaster;
	}
}