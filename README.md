#JsonBeans

通过 
    
    mvn clean package 
   
命令打包生成 jar 文件 到 target/JsonBeans; 在 jsonbeans.txt 中配置 json 数据
 
jsonbeans.txt 配置说明:
    
第一行 配置包名和类名
    
    jerry.test AppInfo
    
第二行 开始配置 json 具体数据
        
通过 
       
    java -jar JsonBeans.jar              

执行生成 Java Bean 类    
