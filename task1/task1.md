# 上海交通大学主页加载性能分析

## 概览

 >交大官网performance截图
 >![](https://pt.sjtu.edu.cn/picbucket/142226_155402233680.png)
 >交大FMP: 2286.1ms
 >

 >友校performance截图
 >![](https://pt.sjtu.edu.cn/picbucket/142226_155402261996.png)
 >友校FMP: 237.5ms
 >

## 瓶颈分析

### 1.多次重构界面
 >![](https://pt.sjtu.edu.cn/picbucket/142226_155402333497.png)
 >界面重构了五十多次，消耗了大量时间

 原因推测：html body中没有界面内容，整个界面是通过js document.writeln()写入的，导致界面多次重构。

### 2.读取多个js文件
 >![](https://pt.sjtu.edu.cn/picbucket/142226_155402385972.png) 
 >总共有十多个js文件，读取消耗了不少时间

 参考友校除去内核只有一个js文件

### 3.css响应过长
 >![](https://pt.sjtu.edu.cn/picbucket/142226_155402416384.png)
 >几个css文件网络进程占用了900多ms，此时界面停止渲染

 原因不明，network中显示css文件的访问到下载只花费了不到100ms的时间。
 参考友校的css加载都不到1ms，可能与交大主页缺失index.html有关。

## 优化建议
1. 舍弃document.write,写一个index.html.
2. 减少js数量，把功能统一起来

