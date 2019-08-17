package jerry.jsonbeans.myutils2.models;

import java.util.List;

public class DataDesc {
	

	private Integer protocolId;
	private Integer pageId;
	private String appid;
	private String version;
	private String pageName;
	private String pageType;
	private String operation;
	private String target;
	private String status;
	private List<ClassDesc> ClassDescList;
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public Integer getProtocolId() {
		return protocolId;
	}
	public void setProtocolId(Integer protocolId) {
		this.protocolId = protocolId;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ClassDesc> getClassDescList() {
		return ClassDescList;
	}
	public void setClassDescList(List<ClassDesc> classDescList) {
		ClassDescList = classDescList;
	}
}
