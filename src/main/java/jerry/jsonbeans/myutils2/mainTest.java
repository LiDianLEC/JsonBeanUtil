package jerry.jsonbeans.myutils2;

public class mainTest {
	
	public static void main(String[] args) {
		
		String jsonString ="{\r\n" + 
				"	\"message\": \"\",\r\n" + 
				"	\"subCode\": 0,\r\n" + 
				"	\"data\": [{\r\n" + 
				"		\"protocolId\": 1,\r\n" + 
				"		\"pageId\": 1,\r\n" + 
				"		\"appid\": \"test\",\r\n" + 
				"		\"version\": \"1.0.1\",\r\n" + 
				"		\"pageName\": \"778\",\r\n" + 
				"		\"pageType\": \"主页\",\r\n" + 
				"		\"operation\": \"getUserInfo\",\r\n" + 
				"		\"request\": {\r\n" + 
				"			\"openId\": {\r\n" + 
				"				\"_type\": \"string\",\r\n" + 
				"				\"optional\": false,\r\n" + 
				"				\"defaultValue\": null,\r\n" + 
				"				\"note\": \"用户标识\"\r\n" + 
				"			},\r\n" + 
				"			\"name\": {\r\n" + 
				"				\"_type\": \"string\",\r\n" + 
				"				\"optional\": false,\r\n" + 
				"				\"defaultValue\": null,\r\n" + 
				"				\"note\": \"用户名称\"\r\n" + 
				"			},\r\n" + 
				"			\"age\": {\r\n" + 
				"				\"_type\": \"integer\",\r\n" + 
				"				\"optional\": false,\r\n" + 
				"				\"defaultValue\": null,\r\n" + 
				"				\"note\": \"年龄\"\r\n" + 
				"			},\r\n" + 
				"			\"people\":{\r\n" + 
				"				\"_type\":\"any\",\r\n" + 
				"				\"optional\":false,\r\n" + 
				"				\"defaultValue\":null,\r\n" + 
				"				\"note\":null,\r\n" + 
				"				\"inner\":{\r\n" + 
				"					\"age\": {\r\n" + 
				"						\"_type\": \"integer\",\r\n" + 
				"						\"optional\": false,\r\n" + 
				"						\"defaultValue\": null,\r\n" + 
				"						\"note\": \"年龄\"\r\n" + 
				"					},\r\n" + 
				"					\"sex\":{\r\n" + 
				"						\"_type\": \"string\",\r\n" + 
				"						\"optional\": true,\r\n" + 
				"						\"defaultValue\": \"男\",\r\n" + 
				"						\"note\": \"性别\"\r\n" + 
				"					}\r\n" + 
				"				}\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"		},\r\n" + 
				"\r\n" + 
				"		\"response\": {\r\n" + 
				"			\"pageSize\": {\r\n" + 
				"				\"_type\": \"integer\",\r\n" + 
				"				\"optional\": true,\r\n" + 
				"				\"defaultValue\": 10,\r\n" + 
				"				\"note\": \"每页条数\"\r\n" + 
				"			},\r\n" + 
				"			\"page\": {\r\n" + 
				"				\"_type\": \"integer\",\r\n" + 
				"				\"optional\": true,\r\n" + 
				"				\"defaultValue\": 0,\r\n" + 
				"				\"note\": \"当前页码\"\r\n" + 
				"			},\r\n" + 
				"			\"total\": {\r\n" + 
				"				\"_type\": \"integer\",\r\n" + 
				"				\"optional\": true,\r\n" + 
				"				\"defaultValue\": null,\r\n" + 
				"				\"note\": \"总数\"\r\n" + 
				"			},\r\n" + 
				"			\"content\": {\r\n" + 
				"				\"_type\": \"list\",\r\n" + 
				"				\"optional\": false,\r\n" + 
				"				\"inner\": {\r\n" + 
				"					\"openId\": {\r\n" + 
				"						\"_type\": \"string\",\r\n" + 
				"						\"optional\": false,\r\n" + 
				"						\"defaultValue\": null,\r\n" + 
				"						\"note\": \"用户标识\"\r\n" + 
				"					},\r\n" + 
				"					\"name\": {\r\n" + 
				"						\"_type\": \"string\",\r\n" + 
				"						\"optional\": false,\r\n" + 
				"						\"defaultValue\": null,\r\n" + 
				"						\"note\": \"用户名称\"\r\n" + 
				"					},\r\n" + 
				"					\"age\": {\r\n" + 
				"						\"_type\": \"integer\",\r\n" + 
				"						\"optional\": false,\r\n" + 
				"						\"defaultValue\": null,\r\n" + 
				"						\"note\": \"年龄\"\r\n" + 
				"					},\r\n" + 
				"					\"sex\": {\r\n" + 
				"						\"_type\": \"integer\",\r\n" + 
				"						\"optional\": false,\r\n" + 
				"						\"defaultValue\": 0,\r\n" + 
				"						\"note\": \"性别0-男，1-女\"\r\n" + 
				"					},\r\n" + 
				"					\"location\": {\r\n" + 
				"						\"_type\": \"string\",\r\n" + 
				"						\"optional\": false,\r\n" + 
				"						\"defaultValue\": \"中国\",\r\n" + 
				"						\"note\": \"位置信息\"\r\n" + 
				"					},\r\n" + 
				"					\"date\":{\r\n" + 
				"					    \"_type\": \"timestamp\",\r\n" + 
				"                        \"optional\": false,\r\n" + 
				"                        \"defaultValue\": \"2019-7-1\",\r\n" + 
				"                        \"note\": \"时间信息\"\r\n" + 
				"					}\r\n" + 
				"				},\r\n" + 
				"				\"defaultValue\": [],\r\n" + 
				"				\"note\": \"信息详情\"\r\n" + 
				"			}\r\n" + 
				"		},\r\n" + 
				"		\"target\": null,\r\n" + 
				"		\"status\": \"Update\"\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"    		\"protocolId\": 1,\r\n" + 
				"    		\"pageId\": 1,\r\n" + 
				"    		\"appid\": \"test\",\r\n" + 
				"    		\"version\": \"1.0.1\",\r\n" + 
				"    		\"pageName\": \"778\",\r\n" + 
				"    		\"pageType\": \"主页\",\r\n" + 
				"    		\"operation\": \"getHello\",\r\n" + 
				"    		\"request\": {\r\n" + 
				"    			\"openId\": {\r\n" + 
				"    				\"_type\": \"string\",\r\n" + 
				"    				\"optional\": false,\r\n" + 
				"    				\"defaultValue\": null,\r\n" + 
				"    				\"note\": \"用户标识\"\r\n" + 
				"    			},\r\n" + 
				"    			\"name\": {\r\n" + 
				"    				\"_type\": \"string\",\r\n" + 
				"    				\"optional\": false,\r\n" + 
				"    				\"defaultValue\": null,\r\n" + 
				"    				\"note\": \"用户名称\"\r\n" + 
				"    			},\r\n" + 
				"    			\"age\": {\r\n" + 
				"    				\"_type\": \"integer\",\r\n" + 
				"    				\"optional\": false,\r\n" + 
				"    				\"defaultValue\": null,\r\n" + 
				"    				\"note\": \"年龄\"\r\n" + 
				"    			},\r\n" + 
				"    			\"people\":{\r\n" + 
				"    				\"_type\":\"any\",\r\n" + 
				"    				\"optional\":false,\r\n" + 
				"    				\"note\":null,\r\n" + 
				"    				\"inner\":{\r\n" + 
				"    					\"age\": {\r\n" + 
				"    						\"_type\": \"integer\",\r\n" + 
				"    						\"optional\": false,\r\n" + 
				"    						\"defaultValue\": null,\r\n" + 
				"    						\"note\": \"年龄\"\r\n" + 
				"    					},\r\n" + 
				"    					\"sex\":{\r\n" + 
				"    						\"_type\": \"string\",\r\n" + 
				"    						\"optional\": true,\r\n" + 
				"    						\"defaultValue\": \"男\",\r\n" + 
				"    						\"note\": \"性别\"\r\n" + 
				"    					}\r\n" + 
				"    				}\r\n" + 
				"    			}\r\n" + 
				"\r\n" + 
				"    		},\r\n" + 
				"\r\n" + 
				"    		\"response\": {\r\n" + 
				"    			\"pageSize\": {\r\n" + 
				"    				\"_type\": \"integer\",\r\n" + 
				"    				\"optional\": true,\r\n" + 
				"    				\"defaultValue\": 10,\r\n" + 
				"    				\"note\": \"每页条数\"\r\n" + 
				"    			},\r\n" + 
				"    			\"page\": {\r\n" + 
				"    				\"_type\": \"integer\",\r\n" + 
				"    				\"optional\": true,\r\n" + 
				"    				\"defaultValue\": 0,\r\n" + 
				"    				\"note\": \"当前页码\"\r\n" + 
				"    			},\r\n" + 
				"    			\"total\": {\r\n" + 
				"    				\"_type\": \"integer\",\r\n" + 
				"    				\"optional\": true,\r\n" + 
				"    				\"defaultValue\": null,\r\n" + 
				"    				\"note\": \"总数\"\r\n" + 
				"    			},\r\n" + 
				"    			\"content\": {\r\n" + 
				"    				\"_type\": \"list\",\r\n" + 
				"    				\"optional\": false,\r\n" + 
				"    				\"inner\": {\r\n" + 
				"    					\"openId\": {\r\n" + 
				"    						\"_type\": \"string\",\r\n" + 
				"    						\"optional\": false,\r\n" + 
				"    						\"defaultValue\": null,\r\n" + 
				"    						\"note\": \"用户标识\"\r\n" + 
				"    					},\r\n" + 
				"    					\"name\": {\r\n" + 
				"    						\"_type\": \"string\",\r\n" + 
				"    						\"optional\": false,\r\n" + 
				"    						\"defaultValue\": null,\r\n" + 
				"    						\"note\": \"用户名称\"\r\n" + 
				"    					},\r\n" + 
				"    					\"age\": {\r\n" + 
				"    						\"_type\": \"integer\",\r\n" + 
				"    						\"optional\": false,\r\n" + 
				"    						\"defaultValue\": null,\r\n" + 
				"    						\"note\": \"年龄\"\r\n" + 
				"    					},\r\n" + 
				"    					\"sex\": {\r\n" + 
				"    						\"_type\": \"integer\",\r\n" + 
				"    						\"optional\": false,\r\n" + 
				"    						\"defaultValue\": 0,\r\n" + 
				"    						\"note\": \"性别0-男，1-女\"\r\n" + 
				"    					},\r\n" + 
				"    					\"location\": {\r\n" + 
				"    						\"_type\": \"string\",\r\n" + 
				"    						\"optional\": false,\r\n" + 
				"    						\"defaultValue\": \"中国\",\r\n" + 
				"    						\"note\": \"位置信息\"\r\n" + 
				"    					}\r\n" + 
				"    				},\r\n" + 
				"    				\"defaultValue\": [],\r\n" + 
				"    				\"note\": \"信息详情\"\r\n" + 
				"    			}\r\n" + 
				"    		},\r\n" + 
				"    		\"target\": null,\r\n" + 
				"    		\"status\": \"Update\"\r\n" + 
				"    	}],\r\n" + 
				"	\"pageInfo\": {\r\n" + 
				"		\"page\": 0,\r\n" + 
				"		\"size\": 10,\r\n" + 
				"		\"total\": 1,\r\n" + 
				"		\"numberOfElements\": 1\r\n" + 
				"	}\r\n" + 
				"}";
		
		JavaBeanUtils.genFile(jsonString);
	}

}
