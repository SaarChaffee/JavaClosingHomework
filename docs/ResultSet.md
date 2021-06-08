# ResultSet

> ### 结果集(ResultSet)是数据中查询结果返回的一种对象，可以说结果集是一个存储查询结果的对象，但是结果集并不仅仅具有存储的功能，他同时还具有操纵数据的功能，可能完成对数据的更新等.
>
>### 结果集读取数据的方法主要是getXXX()，他的参数可以是整型表示第几列（是从1开始的），还可以是列名。返回的是对应的XXX类型的值。如果对应那列 是空值，XXX是对象的话返回XXX型的空值，如果XXX是数字类型，如Float等则返回0,boolean返回false.使用getString()可以返回所有的列的值，不过返回的都是字符串类型的。XXX可以代表的类型有: 基本的数据类型如整型(int)，布尔型(Boolean)，浮点型(Float,Double)等，比特型(byte)，还包括一些特殊的类型，如：日 期类型（java.sql.Date），时间类型(java.sql.Time)，时间戳类型(java.sql.Timestamp)，大数型 (BigDecimal和BigInteger等)等。还可以使用getArray(intcolindex/String columnname)，通过这个方法获得当前行中，colindex所在列的元素组成的对象的数组。使用 getAsciiStream(intcolindex/String colname)可以获得该列对应的当前行的ascii流。也就是说所有的getXXX方法都是对当前行进行操作。
>
>### 结果集从其使用的特点上 可以分为四类，这四类的结果集的所具备的特点都是和Statement语句的创建有关，因为结果集是通过Statement语句执行后产生的，所以可以 说，结果集具备何种特点，完全决定于Statement，当然我是说下面要将的四个特点，在Statement创建时包括三种类型。首先是无参数类型的， 它对应的就是下面要介绍的基本的ResultSet对应的Statement。下面的代码中用到的Connection并没有对其初始化，变量conn代 表的就是Connection对应的对象。SqlStr代表的是响应的SQL语句.

## 快速食用

### `ResultSet result = null;`

- **说明：** 新建一个结果集对象`result`，以下所有方法均使用`.`操作来食用

### `next()`

- **说明：** 将光标（指针）移动到下一个结果集。
- **注意：** 拿到一个结果集后，初始指针指向第一个结果集的前面，即当第一个结果集下标为`1`的话，初始指针指向的是`0`，这时候我们要用`.next()`
  来讲光标移动到第一个结果集。所以当我们要遍历结果集的时候，请放心的用`while(result.next()){ }`。

### `getXXX(i)`

- **说明：** 取得结果集中的内容，以XXX数据类型返回。`i`处可以使用键`String`来取得对应键的值，也可以使用`int`来取得第几个位置的值
- **注意：** `ResultSet`不是很intelligence，`getXXX()`并不是只返回XXX类型的值，而是将值以`XXX`类型返回。

### `close()`

- **说明：** 释放`ResultSet`
- **注意：** 此操作会让JVM自动回收产生结果集的`Statement`以及`Connection`
