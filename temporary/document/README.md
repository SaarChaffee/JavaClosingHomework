# 暂定标准

## 全局变量

```
Golbal{
    public static Cards [] cardsList;//骑士卡牌数组（共60张，从1—60）
}
```

## 骑士卡片类

```
Cards{
    String type;//属性 “水” “火” “木”
    int var;//数值
   String skill;//特殊技能（待定）
   ImageIcon image;//图片
   Cards(){}
   Cards(String type,int var,ImageIcon image, String skill){
        this.image=image;
        this.skill=skill;
        this.type=type;
        this.var=var;
    }
}
```

## 骑士卡牌创建类

```
CardsCreat
直接运行其构造方法即可创建好骑士卡牌数组（目前只有属性、图片、数值）从1-60 属性 水 木 火 点数从1-20

```

## 给标签换图片类

```
Changelmg
```

### 换图片方法

```
public static void changelmg(JLabel jlabel,int i)
jlabel:标签名字
i:换成骑士卡牌数组里的到底几张图片
```