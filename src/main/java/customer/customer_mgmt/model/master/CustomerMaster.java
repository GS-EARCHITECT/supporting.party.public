package customer.customer_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_MASTER")
public class CustomerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQUENCE")
	@SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1)
	@Column(name = "CUSTOMER_SEQ_NO")
	private Long customerSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public CustomerMaster() {
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerSeqNo == null) ? 0 : customerSeqNo.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CustomerMaster other = (CustomerMaster) obj;
		if (customerSeqNo == null) {
			if (other.customerSeqNo != null)
				return false;
		} else if (!customerSeqNo.equals(other.customerSeqNo))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public CustomerMaster(Long customerSeqNo, Long partySeqNo, String remark, String status) {
		super();
		this.customerSeqNo = customerSeqNo;
		this.partySeqNo = partySeqNo;
		this.remark = remark;
		this.status = status;
	}

}