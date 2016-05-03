package jerry.test;

import java.io.Serializable;
import java.math.BigDecimal;


//Json2Bean 自动生成
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String bank_id;
	private String bank_num;
	private String transaction_time;
	private String sn;
	private BigDecimal transaction_money;
	private String confirm_date;
	private BigDecimal ratio;
	private long status;
	private BigDecimal trade_amount;
	private long audit_status;
	private long carrier_id;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}

	public String getBank_num() {
		return bank_num;
	}

	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}

	public String getTransaction_time() {
		return transaction_time;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSn() {
		return sn;
	}

	public void setTransaction_money(BigDecimal transaction_money) {
		this.transaction_money = transaction_money;
	}

	public BigDecimal getTransaction_money() {
		return transaction_money;
	}

	public void setConfirm_date(String confirm_date) {
		this.confirm_date = confirm_date;
	}

	public String getConfirm_date() {
		return confirm_date;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getStatus() {
		return status;
	}

	public void setTrade_amount(BigDecimal trade_amount) {
		this.trade_amount = trade_amount;
	}

	public BigDecimal getTrade_amount() {
		return trade_amount;
	}

	public void setAudit_status(long audit_status) {
		this.audit_status = audit_status;
	}

	public long getAudit_status() {
		return audit_status;
	}

	public void setCarrier_id(long carrier_id) {
		this.carrier_id = carrier_id;
	}

	public long getCarrier_id() {
		return carrier_id;
	}

}