package jerry.jsonbeans.myutils2.models;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class PageInfo {
	
	private Integer page;
	private Integer size;
	private Integer total;
	private Integer numberOfElements;
//	private Timestamp timestamp = new Timestamp(1520L);
	private List list = JSON.parseArray("[]", List.class);
//	private Map map = JSON.parseObject("{}", Map.class);
	private Map<Object, Object> map = JSON.parseObject("{}", Map.class);
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
}
