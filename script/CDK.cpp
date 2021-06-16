#include<bits/stdc++.h>

using namespace std;

int main(){
	srand((unsigned)time(NULL));
	freopen("¶Ò»»ÂëCDK.txt","w",stdout);
	string CDK="Mooer_";
	char charbiao[62];
	for(int i=0;i<10;i++){
		charbiao[i]=i+48;
	}
	for(int i=10;i<36;i++){
		charbiao[i]=i+87;
	}
	for(int i=36;i<62;i++){
		charbiao[i]=i+65-36;
	}
	int n=100;
	while(n--){
		cout<<CDK;
		for(int i=1;i<=12;i++) cout<<charbiao[rand()%62];
		cout<<endl;
	}
	return 0;
} 
