# 使用

！[详细说明](https://www.nothinghere.cn/java/java-brook-tutorial/)

pom中加入依赖:
```
<dependency>
  <groupId>cn.nothinghere</groupId>
  <artifactId>brook</artifactId>
  <version>${lastVersion}</version>
</dependency>
```

最新版本见：![v](https://img.shields.io/maven-central/v/cn.nothinghere/brook)

## 身份证号码生成

### 身份证百科

居民身份证号码，正确、正式的称谓应该是“公民身份号码”。
根据〖中华人民共和国国家标准 GB 11643-1999〗中有关公民身份号码的规定，
公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
中华人民共和国居民身份证是国家法定的证明公民个人身份的有效证件。

### 号码生成使用方法

初始化builder

```
IdCardBuilder idCardBuilder = DataFactory.idCardBuilder();
```

- 随机生成

```
String idCardNo = idCardBuilder.build();
```

- 指定省/市/区

因为省市区的数据是通过淘宝的接口拿到的，所以直辖市和非直辖市并没有分开。也就是说如果想要获取北京/上海/天津/重庆的数据，需要通过指定省-北京，市-北京市，再指定具体的区域

传入的省/市，尽可能的通过枚举类来取。

- 指定省

```
String idCardNo = idCardBuilder
        .withProvince(Province.ANHUI)
        .build();
```
- 指定省/市

```
String idCardNo = idCardBuilder
        .withProvince(Province.BEIJING)
        .withCity(City.BEIJING)
        .build();
```

- 指定省/市/区

区并没有给定义成枚举类，因为区的数据量实在是太大

```
String idCardNo = idCardBuilder
     .withProvince(Province.GUANGDONG)
     .withCity(City.GUANGZHOU)
     .withDistrict("天河区")
     .build();
```

- 固定年龄

```
String idCardNo = idCardBuilder
        .withAge(20)
        .build();
```

- 指定年龄范围

左边界包括，右边界不包括

```
String idCardNo = idCardBuilder
        .withAge(25, 34)
        .build();
```

- 指定性别

分别获取男性或者女性的证件号码

```
// 男性
String idCardNo = idCardBuilder
        .withGender(Gender.MALE)
        .build();
```

```
// 女性
String idCardNo = idCardBuilder
        .withGender(Gender.FEMALE)
        .build();
```

- 指定生日

必须符合yyyyMMdd的格式

```
String idCardNo = idCardBuilder
        .withBirthday("19880123")
        .build();
```

## 手机号码生成

- 中国移动
- 中国联通
- 中国电信

### 数据生成

初始化builder

```
PhoneBuilder builder = DataFactory.phoneBuilder();
```

- 随机生成
```
String phoneNo = builder.build();
```
- 根据运营商生成

移动
```
String phoneNo = builder.withOperator(Operator.CMCC).build();
```
联通
```
String phoneNo = builder.withOperator(Operator.CUCC).build();
```
电信
```
String phoneNo = builder.withOperator(Operator.CTCC).build();
```

## 姓名生成

姓名，由姓和名组成，也称名字。人的姓名，是人类为区分个体，给每个个体给定的特定名称符号，是通过语言文字信息区别人群个体差异的标志。由于有了姓名，人类才能正常有序地交往，因此每个人都有一个属于自己的名字。人名是在语言产生以后才出现的。各个民族对人的命名都有很多习惯。这种习惯受到历史、社会、民族等很多文化因素的制约，一个人的名字通常都有一定的含义。

### 特别说明

姓氏取至[wiki](https://zh.wikipedia.org/wiki/%E4%B8%AD%E5%9B%BD%E5%A7%93%E6%B0%8F%E6%8E%92%E5%90%8D#2013%E5%B9%B44%E6%9C%88)
姓氏里面“于”姓重复了，把第二个给删掉了。
名字取至：[Chinese-Names-Corpus](https://github.com/wainshine/Chinese-Names-Corpus)，在120万条数据中，涉及到不同性别，去掉姓氏只取名，各取6000条，取太多会影响性能。

### 数据生成

初始化builder

```
NameBuilder builder = DataFactory.nameBuilder()
```

- 随机生成全名

```
String fullName = builder.build();
```

- 根据性别生成

```
String name = builder
           .withGender(Gender.FEMALE)
           .build();
```

- 根据长度生成

姓名长度限制为 2~4
```
String name = builder.withLength(length)
           .build();
```
