package jerry.test;

import java.io.Serializable;
import java.util.List;


//Json2Bean 自动生成
public class AppInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Total total;
	private List<Record> record;

	public void setTotal(Total total) {
		this.total = total;
	}

	public Total getTotal() {
		return total;
	}

	public void setRecord(List<Record> record) {
		this.record = record;
	}

	public List<Record> getRecord() {
		return record;
	}

}