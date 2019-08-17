package jerry.jsonbeans.myutils2.models;

import java.util.List;

public class JsonDesc {
	
	private String message;
	private Integer subCode;
	private PageInfo pageInfo;
	private List<DataDesc> dataDescList;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getSubCode() {
		return subCode;
	}
	public void setSubCode(Integer subCode) {
		this.subCode = subCode;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public List<DataDesc> getDataDescList() {
		return dataDescList;
	}
	public void setDataDescList(List<DataDesc> dataDescList) {
		this.dataDescList = dataDescList;
	}

	
}
