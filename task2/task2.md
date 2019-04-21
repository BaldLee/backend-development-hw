# Task2
## 无请求
### CPU 占用
启动时占用稍高(0.6)，稳定后均值为0.15左右。  
cpu占用有几次起伏，分别对应（误）启动vs（第一峰），启动acrobat（第二峰），启动任务管理器（第三峰）  
...看来actuator监视的是机器cpu占用率...  
![](https://pt.sjtu.edu.cn/picbucket/142226_155586082486.png)
### 内存占用
内存稳定增长，泄露了...  
![](https://pt.sjtu.edu.cn/picbucket/142226_155586110373.png)
## 500条请求
### CPU占用
cpu占用上升到0.56。但请求也是本机在发，cpu占用不准确  
![](https://pt.sjtu.edu.cn/picbucket/142226_155586143698.png)
### 内存占用
内存占用激增100M，然后heap被清除，进入新一轮的泄露。  
![](https://pt.sjtu.edu.cn/picbucket/142226_155586155026.png)
## 2000条请求
### CPU占用
上升到0.6后缓缓下降，性能短板应该是在内存那边。  
![](https://pt.sjtu.edu.cn/picbucket/142226_155586215995.png)
### 内存占用
暴涨250M后内存被清除，再次暴涨300M后才完成2000条请求。  
![](https://pt.sjtu.edu.cn/picbucket/142226_155586203266.png)