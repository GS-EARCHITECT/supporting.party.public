package customer.customer_prodservcs.model.dto;

import java.io.Serializable;

public class CustomerProdServDetailsDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2946828400239408920L;
	private Long custProdServSeqNo;
	private Long assetSeqNo;
	private String remark;
	private Long resourceSeqNo;
	private Long serviceSeqNo;
	private String status;
	private Long customerSeqNo;

	public Long getCustProdServSeqNo() {
		return custProdServSeqNo;
	}

	public void setCustProdServSeqNo(Long custProdServSeqNo) {
		this.custProdServSeqNo = custProdServSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerSeqNo() {
		return customerSeqNo;
	}

	public void setCustomerSeqNo(Long customerSeqNo) {
		this.customerSeqNo = customerSeqNo;
	}

	public CustomerProdServDetailsDTO(Long custProdServSeqNo, Long assetSeqNo, String remark, Long resourceSeqNo,
			Long serviceSeqNo, String status, Long customerSeqNo) {
		super();
		this.custProdServSeqNo = custProdServSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.remark = remark;
		this.resourceSeqNo = resourceSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.status = status;
		this.customerSeqNo = customerSeqNo;
	}

	public CustomerProdServDetailsDTO() {
		super();
	}

}