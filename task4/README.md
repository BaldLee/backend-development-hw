# 消费者&生产者容器
## 运行
target目录下有一个打包的demo: paccontainer-1.0-SNAPSHOT.jar  
可用以下命令行运行
```
java -jar paccontainer-1.0-SNAPSHOT.jar
```
该demo会先生产60个产品。  
之后消费者线程每100ms向容器请求一个产品，生产者线程每120ms向容器提供一个产品。  
总共提供300个产品且请求300个产品后demo停止。  
客户端和容器的行为会打印在控制台上。 
## 容器工作
当容器中的产品数不大于50时，容器按照queue工作。  
当容器中的产品数大于50时，容器按照stack工作。  
产品在容器中存在超过5秒将会被销毁。  