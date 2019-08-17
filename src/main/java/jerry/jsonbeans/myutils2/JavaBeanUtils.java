package jerry.jsonbeans.myutils2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import jerry.jsonbeans.myutils2.models.ClassDesc;
import jerry.jsonbeans.myutils2.models.DataDesc;
import jerry.jsonbeans.myutils2.models.FieldDesc;
import jerry.jsonbeans.myutils2.models.JsonDesc;
import jerry.jsonbeans.myutils2.models.PageInfo;

public class JavaBeanUtils {
	/**
{
	"message": "",
	"subCode": 0,
	"data": [{
		"protocolId": 1,
		"pageId": 1,
		"appid": "test",
		"version": "1.0.1",
		"pageName": "778",
		"pageType": "主页",
		"operation": "getUserInfo",
		"request": {
			"openId": {
				"_type": "string",
				"optional": false,
				"defaultValue": null,
				"note": "用户标识"
			},
			"name": {
				"_type": "string",
				"optional": false,
				"defaultValue": null,
				"note": "用户名称"
			},
			"age": {
				"_type": "integer",
				"optional": false,
				"defaultValue": null,
				"note": "年龄"
			}
		},
		"response": {
			"pageSize": {
				"_type": "integer",
				"optional": true,
				"defaultValue": 10,
				"note": "每页条数"
			},
			"page": {
				"_type": "integer",
				"optional": true,
				"defaultValue": 0,
				"note": "当前页码"
			},
			"total": {
				"_type": "integer",
				"optional": true,
				"defaultValue": null,
				"note": "总数"
			},
			"content": {
				"_type": "list",
				"optional": false,
				"inner": {
					"openId": {
						"_type": "string",
						"optional": false,
						"defaultValue": null,
						"note": "用户标识"
					},
					"name": {
						"_type": "string",
						"optional": false,
						"defaultValue": null,
						"note": "用户名称"
					},
					"age": {
						"_type": "integer",
						"optional": false,
						"defaultValue": null,
						"note": "年龄"
					},
					"sex": {
						"_type": "integer",
						"optional": false,
						"defaultValue": 0,
						"note": "性别0-男，1-女"
					},
					"location": {
						"_type": "string",
						"optional": false,
						"defaultValue": "中国",
						"note": "位置信息"
					}
				},
				"defaultValue": [],
				"note": "信息详情"
			}
		},
		"target": null,
		"status": "Update"
	}],
	"pageInfo": {
		"page": 0,
		"size": 10,
		"total": 1,
		"numberOfElements": 1
	}
} */
	public static void genFile(String jsonString) {
		JsonDesc jsonDesc = new JsonDesc();
		// toJsonDesc
		toJsonDesc(jsonString, jsonDesc);
		
		
	}

	private static <E> void toJsonDesc(String jsonString, JsonDesc jsonDesc) {
		JSONObject jsonObject = JSON.parseObject(jsonString);
		Set<String> keySet = jsonObject.keySet();
		for (String key : keySet) {
			if ("message".equals(key)) {
				jsonDesc.setMessage(jsonObject.getString(key));
			}else if ("subCode".equals(key)) {
				jsonDesc.setSubCode(jsonObject.getInteger(key));
			}else if ("pageInfo".equals(key)) {
				jsonDesc.setPageInfo(jsonObject.getObject(key, PageInfo.class));
			}else if ("data".equals(key)) {
				List<DataDesc> dataDescList = new ArrayList();
				
				JSONArray jsonArray = jsonObject.getJSONArray(key);
				for (int i = 0; i < jsonArray.size(); i++) {
					DataDesc dataDesc = new DataDesc();
					// toDataDesc
					toDataDesc(jsonArray, i, dataDesc);
					dataDescList.add(dataDesc);
				}
				
				jsonDesc.setDataDescList(dataDescList);
			}else {
				throw new RuntimeException("传入参数错误");
			}
		}
		
		System.out.println("结束了");
		
	}

	private static void toDataDesc(JSONArray jsonArray, int i, DataDesc dataDesc) {
		JSONObject jsonObject2 = jsonArray.getJSONObject(i);
		Set<String> keySet2 = jsonObject2.keySet();
		for (String key2 : keySet2) {
			if ("protocolId".equals(key2)) {
				dataDesc.setProtocolId(jsonObject2.getObject(key2, Integer.class));
			}else if ("pageId".equals(key2)) {
				dataDesc.setPageId(jsonObject2.getObject(key2, Integer.class));
			}else if ("appid".equals(key2)) {
				dataDesc.setAppid(jsonObject2.getObject(key2, String.class));
			}else if ("version".equals(key2)) {
				dataDesc.setVersion(jsonObject2.getObject(key2, String.class));
			}else if ("pageName".equals(key2)) {
				dataDesc.setPageName(jsonObject2.getObject(key2, String.class));
			}else if ("pageType".equals(key2)) {
				dataDesc.setPageType(jsonObject2.getObject(key2, String.class));
			}else if ("operation".equals(key2)) {
				dataDesc.setOperation(jsonObject2.getObject(key2, String.class));
			}else if ("target".equals(key2)) {
				dataDesc.setTarget(jsonObject2.getObject(key2, String.class));
			}else if ("status".equals(key2)) {
				dataDesc.setStatus(jsonObject2.getObject(key2, String.class));
			}else if ("request".equals(key2) || "response".equals(key2)) {
				//TODO
				
				List<ClassDesc> classDescList = new ArrayList();
				// toClassDesc
				ClassDesc classDesc = new ClassDesc();
//				
//				classDesc.setPackeName(key2);
//				classDesc.setClassName(key2);
//				
				List<FieldDesc> fieldDescList = new ArrayList();
				
				
				JSONObject jsonObject3 = jsonObject2.getJSONObject(key2);
				Set<String> keySet3 = jsonObject3.keySet();
				
				for (String key3 : keySet3) {
					FieldDesc fieldDesc = new FieldDesc();
					JSONObject jsonObject4 = jsonObject3.getJSONObject(key3);
					String fieldType = jsonObject4.getObject("_type", String.class);
					if ("string".equals(fieldType) || "integer".equals(fieldType) || "long".equals(fieldType) || "double".equals(fieldType) || "float".equals(fieldType) ) {
						fieldDesc.setFieldType(fieldType);
						fieldDesc.setOptional(jsonObject4.getObject("optional", Boolean.class));
						fieldDesc.setDefaultValue(jsonObject4.get("defaultValue"));
						fieldDesc.setNote(jsonObject4.getObject("note", String.class));
						fieldDesc.setFieldName(key3);
						fieldDesc.setImportType("xxx");
						fieldDescList.add(fieldDesc);
						
						
						
					}else if ("list".equals(fieldType)) {
						
					}else if ("timestamp".equals(fieldType)) {
						
					}else if ("date".equals(fieldType)) {
						
					}else if ("map".equals(fieldType)) {
						
					}else if ("any".equals(fieldType)) {
						
					}else {
						throw new RuntimeException("传入参数错误");
					}
					
				}
				
				
				dataDesc.setClassDescList(classDescList);
				
				/**
"request": {
			"openId": {
				"_type": "string",
				"optional": false,
				"defaultValue": null,
				"note": "用户标识"
			},
			"name": {
				"_type": "string",
				"optional": false,
				"defaultValue": null,
				"note": "用户名称"
			},
			"age": {
				"_type": "integer",
				"optional": false,
				"defaultValue": null,
				"note": "年龄"
			}
		},
		"response": {
			"pageSize": {
				"_type": "integer",
				"optional": true,
				"defaultValue": 10,
				"note": "每页条数"
			},
			"page": {
				"_type": "integer",
				"optional": true,
				"defaultValue": 0,
				"note": "当前页码"
			},
			"total": {
				"_type": "integer",
				"optional": true,
				"defaultValue": null,
				"note": "总数"
			},
			"content": {
				"_type": "list",
				"optional": false,
				"inner": {
					"openId": {
						"_type": "string",
						"optional": false,
						"defaultValue": null,
						"note": "用户标识"
					},
					"name": {
						"_type": "string",
						"optional": false,
						"defaultValue": null,
						"note": "用户名称"
					},
					"age": {
						"_type": "integer",
						"optional": false,
						"defaultValue": null,
						"note": "年龄"
					},
					"sex": {
						"_type": "integer",
						"optional": false,
						"defaultValue": 0,
						"note": "性别0-男，1-女"
					},
					"location": {
						"_type": "string",
						"optional": false,
						"defaultValue": "中国",
						"note": "位置信息"
					}
				},
				"defaultValue": [],
				"note": "信息详情"
			}
		}
				 */
			}else {
				throw new RuntimeException("传入参数错误");
			}
		}
	}

}
