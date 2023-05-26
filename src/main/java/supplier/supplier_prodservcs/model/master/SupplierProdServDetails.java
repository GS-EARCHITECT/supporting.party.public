package supplier.supplier_prodservcs.model.master;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "SUPPLIER_PRODSERV_DETAILS")
public class SupplierProdServDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_PRODSERV_SEQUENCE")
	@SequenceGenerator(name = "SUPPLIER_PRODSERV_SEQUENCE", sequenceName = "SUPPLIER_PRODSERV_SEQUENCE", allocationSize = 1)
	@Column(name = "SUPP_PRODSERV_SEQ_NO")
	private Long suppProdServSeqNo;

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

	@Column(name = "SUPPLIER_SEQ_NO")
	private Long supplierSeqNo;

	public SupplierProdServDetails() {
	}

	public Long getSuppProdServSeqNo() {
		return suppProdServSeqNo;
	}

	public void setSuppProdServSeqNo(Long suppProdServSeqNo) {
		this.suppProdServSeqNo = suppProdServSeqNo;
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

	public Long getSupplierSeqNo() {
		return supplierSeqNo;
	}

	public void setSupplierSeqNo(Long supplierSeqNo) {
		this.supplierSeqNo = supplierSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((serviceSeqNo == null) ? 0 : serviceSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((suppProdServSeqNo == null) ? 0 : suppProdServSeqNo.hashCode());
		result = prime * result + ((supplierSeqNo == null) ? 0 : supplierSeqNo.hashCode());
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
		SupplierProdServDetails other = (SupplierProdServDetails) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
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
		if (suppProdServSeqNo == null) {
			if (other.suppProdServSeqNo != null)
				return false;
		} else if (!suppProdServSeqNo.equals(other.suppProdServSeqNo))
			return false;
		if (supplierSeqNo == null) {
			if (other.supplierSeqNo != null)
				return false;
		} else if (!supplierSeqNo.equals(other.supplierSeqNo))
			return false;
		return true;
	}

	public SupplierProdServDetails(Long suppProdServSeqNo, Long assetSeqNo, String remark, Long resourceSeqNo,
			Long serviceSeqNo, String status, Long supplierSeqNo) {
		super();
		this.suppProdServSeqNo = suppProdServSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.remark = remark;
		this.resourceSeqNo = resourceSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.status = status;
		this.supplierSeqNo = supplierSeqNo;
	}

}