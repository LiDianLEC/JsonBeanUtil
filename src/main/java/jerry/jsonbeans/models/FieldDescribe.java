package jerry.jsonbeans.models;

/**
 * @author Jerry Ou
 * @version 1.0 2016-05-03 14:36
 * @since JDK 1.6
 */
public class FieldDescribe {

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImportype() {
		return importype;
	}
	public void setImportype(String importype) {
		this.importype = importype;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "FieldDescribe [name=" + name + ", type=" + type + ", importype=" + importype + ", value=" + value + "]";
	}
	public String name;
    public String type;
    public String importype;
    public Object value;
}
