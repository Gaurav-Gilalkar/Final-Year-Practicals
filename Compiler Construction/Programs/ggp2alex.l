
%{
	#include<stdio.h>
%}

%%
"if"|"else"|"while"|"do"|"switch"|"case"|"int" {printf("Keyword");}
[a-z|A-Z][a-z|0-9]* {printf("Identifier");}
[0-9]* {printf("Number");}
"!"|"@"|"*"|"&"|"^"|"%"|"$"|"#"|";" {printf("Special Character");}
%%
int yywrap()
{
 return 1;
 }
main()
{
	printf("Enter a string of data\n");
	yylex();
}