# �ݶ���׼

## ȫ�ֱ���

```
Golbal{
    public static Cards [] cardsList;//��ʿ�������飨��60�ţ���1��60��
}
```

## ��ʿ��Ƭ��

```
Cards{
    String type;//���� ��ˮ�� ���� ��ľ��
    int var;//��ֵ
   String skill;//���⼼�ܣ�������
   ImageIcon image;//ͼƬ
   Cards(){}
   Cards(String type,int var,ImageIcon image, String skill){
        this.image=image;
        this.skill=skill;
        this.type=type;
        this.var=var;
    }
}
```

## ��ʿ���ƴ�����

```
CardsCreat
ֱ�������乹�췽�����ɴ�������ʿ�������飨Ŀǰֻ�����ԡ�ͼƬ����ֵ����1-60 ���� ˮ ľ �� ������1-20

```

## ����ǩ��ͼƬ��

```
Changelmg
```

### ��ͼƬ����

```
public static void changelmg(JLabel jlabel,int i)
jlabel:��ǩ����
i:������ʿ����������ĵ��׼���ͼƬ
```