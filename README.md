# Mooer Village Knights Cards

## main module of JavaClosingHomework

<h1>

<a href="https://www.oracle.com/java/"><img src="https://img.shields.io/badge/JDK-1.8.0-red"/></a>
<a herf="https://www.microsoft.com/zh-cn/sql-server"><img src="https://img.shields.io/badge/DataBase-MSSQL-yellow"></a>
[![wakatime](https://wakatime.com/badge/github/SaarChaffee/JavaClosingHomework.svg)](https://wakatime.com/badge/github/SaarChaffee/JavaClosingHomework)

</h1>
<h2>

### 要使用本模块请下载Release [gitee](https://gitee.com/saarchaffee/JavaClosingHomework/releases) or [github](https://gitee.com/saarchaffee/JavaClosingHomework/releases) 中的jar包，在IDE中导入包，最后`import main.*`即可食用

### 方法的详细说明请移步[API文档](docs/main/api.md)

### 本模块涉及大量结果集方法，相关说明请移步[ResultRet快速说明](docs/ResultSet.md)

### 完整项目请移步[MooerVillageKnightsCards](https://github.com/SaarChaffee/MooerVillageKnightsCards)

</h2>

```mermaid
graph TD
A(登录界面) --> B(注册)
A(登录界面) --> C(登录)
A(登录界面) --> D(注销)
A(登录界面) --> E(退出)
B -->  F[玩家ID,密码,确认密码,手机]
B -->  G(修改密码)
C -->  H(游戏主界面)
H -->  I(商城)
H -->  J(对战)
H -->  K(个人信息)
H -->  L(好友)
I -->  M[充值,道具购买,抽卡]
J -->  N(搜索用户名对战)
K -->  O[玩家uid,玩家昵称,玩家等级,玩家场次,被举报次数,拥有卡牌数量,点券余额]
L -->  P[查看好友,删除好友,拉黑,举报,发送信息]
M -->  Q(充值界面)
M -->  R(抽卡,判断余额)
R -->  S(余额足够显示抽卡所得)
R -->  T(余额不足跳转充值界面)
    
```