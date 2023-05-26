package customer.customer_prodservcs.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the CUSTOMER_PRODSERV database table.
 * 
 */
@Entity
@Table(name = "CUSTOMER_PRODSERV_DETAILS")
public class CustomerProdServDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_PRODSERV_SEQUENCE")
	@SequenceGenerator(name = "CUSTOMER_PRODSERV_SEQUENCE", sequenceName = "CUSTOMER_PRODSERV_SEQUENCE", allocationSize = 1)
	@Column(name = "CUST_PRODSERV_SEQ_NO")
	private long custProdServSeqNo;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "SERVICE_SEQ_NO")
	private Long serviceSeqNo;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CUSTOMER_SEQ_NO")
	private Long customerSeqNo;

	public CustomerProdServDetails() {
	}

	public long getCustProdServSeqNo() {
		return this.custProdServSeqNo;
	}

	public void setCustProdServSeqNo(long custProdServSeqNo) {
		this.custProdServSeqNo = custProdServSeqNo;
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getServiceSeqNo() {
		return this.serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerSeqNo() {
		return this.customerSeqNo;
	}

	public void setCustomerSeqNo(Long customerSeqNo) {
		this.customerSeqNo = customerSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + (int) (custProdServSeqNo ^ (custProdServSeqNo >>> 32));
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((serviceSeqNo == null) ? 0 : serviceSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((customerSeqNo == null) ? 0 : customerSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerProdServDetails other = (CustomerProdServDetails) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (custProdServSeqNo != other.custProdServSeqNo)
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		if (serviceSeqNo == null) {
			if (other.serviceSeqNo != null)
				return false;
		} else if (!serviceSeqNo.equals(other.serviceSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (customerSeqNo == null) {
			if (other.customerSeqNo != null)
				return false;
		} else if (!customerSeqNo.equals(other.customerSeqNo))
			return false;
		return true;
	}

	public CustomerProdServDetails(long custProdServSeqNo, Long assetSeqNo, String remark, Long resourceSeqNo,
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

}