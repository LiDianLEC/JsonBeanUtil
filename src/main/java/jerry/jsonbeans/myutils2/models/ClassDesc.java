package jerry.jsonbeans.myutils2.models;

import java.util.List;

public class ClassDesc {

	private String packeName;
	private String className;
	private List<FieldDesc> FieldDescList;
	private List<ClassDesc> classDescList;

	public String getPackeName() {
		return packeName;
	}

	public void setPackeName(String packeName) {
		this.packeName = packeName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<FieldDesc> getFieldDescList() {
		return FieldDescList;
	}

	public void setFieldDescList(List<FieldDesc> fieldDescList) {
		FieldDescList = fieldDescList;
	}

	public List<ClassDesc> getClassDescList() {
		return classDescList;
	}

	public void setClassDescList(List<ClassDesc> classDescList) {
		this.classDescList = classDescList;
	}
}
