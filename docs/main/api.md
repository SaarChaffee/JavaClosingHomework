# api

## 方法

以下方法均可从`main.DAO.DaoBase`中导入

### `Update()` <Badge text="1.5.0-" type="error"/>

- **参数：** `String`
- **返回：** `int`
- **说明：**
  向数据库注入增删改查语句

### `Search()`

- **参数：** `String`
- **返回：** `ResultSet`
- **说明：**
  向数据库注入查询语句

以下方法均可从`main.DAO.DaoPlus`中导入

### `NewUser()`

- **参数：** `String : 账号, String ： 密码, int : 手机号`
- **返回：** `int : 0,1,2,3`
- **说明：**
  新建用户，初始化用户在数据库中的数据，使用`PreparaedStatement`防止用户进行 SQL 注入攻击。返回`0`时无法新建用户，返回`3`时新建成功，返回`1,2`时数据初始化出错

### `getNewUid()`

- **参数：** `null`
- **返回：** `int : 新的uid`
- **说明：**
  用随机数生成用户 9 位数的 uid

### `getUserUidBtTel()`

- **参数：** `String : 用户手机号码`
- **返回：** `int : 用户uid`
- **说明：**
  向数据库查询用户手机号对应的 uid

### `getPasswordByTel()`

- **参数：** `String : 用户手机号码`
- **返回：** `String : 用户密码`
- **说明：**
  根据用户手机号从数据库查询用户密码，使用`PreparaedStatement`防止用户进行 SQL 注入攻击。

### `getAllUserData()`

- **参数：** `int : 用户uid`
- **返回：** `ResultSet : 该用户所有信息的结果集`
- **说明：**
  向数据库获取该用户所有信息，以`ResultSet`类型存储

### `getAllUserUid()`

- **参数：** `null`
- **返回：** `ResultSet : 所有用户uid的结果集`
- **说明：**
  获取数据库中所有用户 uid，以`ResultSet`类型存储

### `getUserBalance()`

- **参数：** `int ： 用户uid`
- **返回：** `int : 用户账户余额`
- **说明：**
  从`getAllUserData()`中获取用户账户余额

### `getColle()`

- **参数：** `int : 用户uid`
- **返回：** `ResultSet : 拥有卡牌的集合`
- **说明：**
  从数据库中获取用户所有卡牌的拥有状态，用`ResultSet`类型存储

### `getCard()`

- **参数：** `int : 用户uid, String : 卡片名字`
- **返回：** `int : 0,1`
- **说明：**
  向数据库更新用户拥有卡牌的状态，`1`更新成功，`0`更新失败

### `getRedmptionInfo()`

- **参数：** `String : 兑换码`
- **返回：** `ResultSet : 兑换码的面值和使用情况`
- **说明：**
  向数据库查询兑换码的面值及使用状态，以`ResultSet`类型存储

### `getFriend()`

- **参数：** `int : 用户uid`
- **返回：** `ResultSet : 用户所有好友uid结果集`
- **说明：**
  向数据库查询用户好友列表，以`ResultSet`类型存储

以下方法均可从`main.DAO.DaoPro`中导入

### `isFriend()`

- **参数：** `int : 用户uid, int : 好友uid`
- **返回：** `boolean`
- **说明：**
  调用`getFriend()`向数据库查询好友关系，`true : 是好友`，`false : 不是好友`

### `isRedmptionUsed()`

- **参数：** `String : 兑换码`
- **返回：** `boolean`
- **说明：**
  调用`getRedmptionInfo()`向数据库查询兑换码使用状态，`true : 已使用`,`false : 未使用`

### `colles()`

- **参数：** `int : 用户uid`
- **返回：** `boolean[]`
- **说明：**
  在`getColle()`中分离用户拥有的卡牌状态，用`boolean[]`储存，从`1`开始`60`结束，`true`为拥有，`false`为未拥有

### `recharge()`

- **参数：** `int : 用户uid, String 兑换码`
- **返回：** `int : 0,1,2`
- **说明：**
  用户使用兑换码，返回`0`为使用失败，返回`2`使用成功，返回`1`数据更新错误

### `getWin()`

- **参数：** `int : 用户uid`
- **返回：** `int : 用户胜利场数`
- **说明：**
  调用`getAllUserData()`向数据库查询用户胜利场数

### `getLost()`

- **参数：** `int : 用户uid`
- **返回：** `int : 用户战败场数`
- **说明：**
  调用`getAllUserData()`向数据库查询用户战败场数

### `getReport()`

- **参数：** `int : 用户uid`
- **返回：** `int : 用户被举报次数`
- **说明：**
  调用`getAllUserData()`向数据库查询用户举报次数

以下方法均可从`main.DAO.DaoUltra`中导入

### `addFriend()`

- **参数：** `int : 用户uid, int : 好友uid`
- **返回：** `int : 0,1`
- **说明：**
  向数据库好友表中添加好友，自动排序 uid，返回`0`添加失败，返回`1`添加成功

### `deleteFriend()`

- **参数：** `int : 用户uid, int : 好友uid`
- **返回：** `int : 0,1`
- **说明：**
  向数据库好友表中删除好友，自动排序 uid，返回`0`删除失败，返回`1`删除成功

### `userWin()`

- **参数：** `int : 用户uid`
- **返回：** `int : 0,1`
- **说明：**
  向数据库改变用户胜利场数，返回`0`改变失败，返回`1`改变成功

### `userLost()`

- **参数：** `int : 用户uid`
- **返回：** `int : 0,1`
- **说明：**
  向数据库改变用户战败场数，返回`0`改变失败，返回`1`改变成功

### `reported()`

- **参数：** `int : 用户uid`
- **返回：** `int : 0,1`
- **说明：**
  向数据库改变用户被举报次数，返回`0`改变失败，返回`1`改变成功
