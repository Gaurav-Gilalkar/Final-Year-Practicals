#include<ctype.h>
#include<stdio.h>
#define MAX 100
int transit(int,char);
int main()
{
	int cstate=0,n,i;
	static char *inp,input[MAX];
	printf("enter the string and its length\n");
	scanf("%s %d",&input,&n);
	//n=sizeof(input);
	inp=input;
	for(i=0;i<n;i++)
	{
		cstate=transit(cstate,*inp);
		printf("%d\n",cstate);
		inp++;	
	}
	if(cstate==1||cstate==4||cstate==6)
	printf("string is accepted\n");
	else
	printf("string is not accepted\n");
return 0;		
}
int transit(int r,char ch)
{
	int transtab[8][5]={{1,7,7,7,7},
			    {1,7,2,3,7},
			    {4,7,7,7,7},
	         	    {7,5,7,7,7},
			    {4,7,7,3,7},
			    {6,7,7,7,7},
			    {6,7,7,7,7},
			    {7,7,7,7,7}},col;
	if(isdigit(ch))
	{
		col=0;
	}
	else
	{	if(ch=='.')
		col=2;
		else
		{
			if(ch=='E')
			col=3;
			else
			{
				if(ch=='+' || ch=='-')
				col=1;
				else
				{
					col=4;
				}
			}
		}
	}
	return transtab[r][col];	
}
