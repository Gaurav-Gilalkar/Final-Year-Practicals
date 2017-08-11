
%{
	#include<stdio.h>
	int keyword=0,Identifier=0,number=0,Spec=0,op=0,comm=0,dec=0,wsp=0,hd=0;
%}

%%
"auto"|"break"|"case"|"char"|"const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extern"|"float"|"for"|"goto"|"if"|"int"|"long"|"regiter"|"return"|"short"|"signed"|"sizeof"|"static"|"struct"|"switch"|"typedef"|"union"|"unsigned"|"void"|"volatile"|"while" {printf("Keyword : %s\n",yytext);keyword++;}
[a-z|A-Z][a-z|0-9]* {printf("Identifier : %s\n",yytext);Identifier++;}
[0-9]+ {printf("Number : %s\n",yytext);number++;}
","|"<"|">"|"."|"_"|")"|";"|"("|"$"|":"|"%"|"]"|"["|"#"|"?"|"&"|"}"|"{"|"^"|"!"|"~"|"\\"|"\'"|"\"" {printf("Spec symbol :%s\n",yytext);Spec++;}
"+"|"*"|"-"|"/"|"=" {printf("Operator : %s\n",yytext);op++;}
[/]+[/]*+[a-z|A-Z|0-9|" "]+ {printf("Comment : %s\n",yytext);comm++;}
[0-9]+.[0-9]+ {printf("Float : %s\n",yytext);dec++;}
[" ""	"] {wsp++;}
[#include<a-z.h>]* {printf("Header file : %s\n",yytext);hd++;}
%%
int yywrap()
{
return 1;
}
main()
{
         FILE *fp=fopen("ggccp2b.txt","r");
	 if(!fp)
	 printf("Couldn't open file");
	 yyin=fp;
         yylex();
	 printf("Keywords = %d\nIdentifiers = %d\nNumbers = %d\nSpecial Characters = %d\nComments = %d\nFloat = %d\nWhitespaces = %d\nHeader files = %d",keyword,Identifier,number,Spec,comm,dec,wsp,hd);
	
}