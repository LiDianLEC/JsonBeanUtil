package jerry.test;

import java.io.Serializable;
import java.math.BigDecimal;


//Json2Bean 自动生成
public class Total implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal amount;
	private BigDecimal astransaction_money;

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAstransaction_money(BigDecimal astransaction_money) {
		this.astransaction_money = astransaction_money;
	}

	public BigDecimal getAstransaction_money() {
		return astransaction_money;
	}

}