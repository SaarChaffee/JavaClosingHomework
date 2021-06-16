#include<bits/stdc++.h>

using namespace std;

/*
卡牌顺序1-60  按照水木火的属性，每种属性从1排到20(数值越大越稀有)

点数

1-5 小概率   14%

6-10  超大概率   40%

11-15 中概率     30%

16-18 小概率    14%

19-20 极低概率  2%

*/

int result() {
	int re;
	int ran;
	ran=rand()%100 +1;
	if(ran>=1&&ran<=14) {
		re=rand()%5 +1 + (rand()%3)*20;
	}
	if(ran>14&&ran<=54) {
		re=rand()%5 +6 + (rand()%3)*20;
	}
	if(ran>54&&ran<=84) {
		re=rand()%5 +11 + (rand()%3)*20;
	}
	if(ran>84&&ran<=98) {
		re=rand()%3 +16 + (rand()%3)*20;
	}
	if(ran>98&&ran<=100) {
		re=rand()%2 +19 + (rand()%3)*20;
	}
	return re;
}


int main() {
	srand((unsigned)time(NULL));
	freopen("result.txt","w",stdout);
	int n=10000;
	while(n--) {
		int a=result();
		cout<<a<<endl;
	}
	return 0;
}

