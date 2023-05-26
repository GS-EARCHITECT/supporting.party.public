package customer.customer_mgmt.model.dto;

import java.io.Serializable;

public class CustomerMasterDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1432564608735456433L;
	private Long customerSeqNo;
	private Long partySeqNo;
	private String remark;
	private String status;

	public Long getCustomerSeqNo() {
		return customerSeqNo;
	}

	public void setCustomerSeqNo(Long customerSeqNo) {
		this.customerSeqNo = customerSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerMasterDTO(Long customerSeqNo, Long partySeqNo, String remark, String status) {
		super();
		this.customerSeqNo = customerSeqNo;
		this.partySeqNo = partySeqNo;
		this.remark = remark;
		this.status = status;
	}

	public CustomerMasterDTO() {
		super();
	}

}