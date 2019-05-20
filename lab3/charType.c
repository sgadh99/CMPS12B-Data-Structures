#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#include<assert.h>
#define MAX_STRING_LENGTH 100
void extract_chars(char* s, char* a, char* d, char* p, char* w)
{
int i=0, b=0, e=0, q=0, x=0;
while(s[i]!='\0')
{
	if(isalpha((int)s[i]))
	{
		a[b]=s[i];
		b++;
		i++;
	}
	else if(isalnum((int)s[i]))
	{	
		d[e]=s[i];
		e++;
		i++;
	}
	else if(ispunct((int)s[i]))
	{
		p[q]=s[i];
		q++;
		i++;
	}
	else
	{
		w[x]=s[i];
		x++;
		i++;
	}
}
a[b]='\0';
d[e]='\0';
p[q]='\0';
w[x]='\0';	
}
int main(int argc, char* argv[])
{
	FILE* in; 
	FILE* out;
	char* line; /*arry that stores the the character read in from a file*/
	char* word; /*stores alph chars*/
	char* num;  /*stores number chars*/
	char* punc; /*stores punctuation chars*/
	char* whitespace; /*stores whitespce*/
	int n=1; /* count the number of lines in the file*/

	if(argc!=3){
		printf("Usage: %s input-file outputfile \n", argv[0]);
		exit(EXIT_FAILURE);

	}
	/*throws an error if the input file is null*/
	in = fopen(argv[1], "r");
	if(in ==  NULL){
		printf("Unable to read input file \n ");
		exit(EXIT_FAILURE);
	}
        /*throws an error if the output file is null*/
	out = fopen(argv[2],"w");
	if(out == NULL){
		printf("Unable to write to output file \n");
		exit(EXIT_FAILURE);
	}
	/*allocates heap memory for the char arrays*/
	line = calloc(MAX_STRING_LENGTH+1, sizeof(char));
	word = calloc(MAX_STRING_LENGTH+1, sizeof(char));
	num = calloc(MAX_STRING_LENGTH+1, sizeof(char));
	punc = calloc(MAX_STRING_LENGTH+1, sizeof(char));
	whitespace = calloc(MAX_STRING_LENGTH+1, sizeof(char));
	assert(line!=NULL && word!=NULL && num!=NULL && punc!=NULL && whitespace!=NULL);
	
	/*reads the input file into the line array and prints out the array in specified catagory*/ 
	while( fgets(line, MAX_STRING_LENGTH, in) != NULL){
		extract_chars(line,word,num,punc,whitespace);/*places the character in the right catagory*/
		fprintf(out,"line %d contains: \n",n);
		if(strlen(word)>1){/*all if statements check if the are multiple characters in the catogory*/
                	fprintf(out,"%d alphabetic characters: %s\n",(int)strlen(word),word);
		}
		else{
			fprintf(out,"%d alphabetic character: %s\n",(int)strlen(word),word);
		}
		if(strlen(num)>1){
			fprintf(out,"%d numeric characters: %s\n",(int)strlen(num),num);
		}
		else{
			fprintf(out,"%d numeric character: %s\n",(int)strlen(num),num);
		}
		if(strlen(punc)>1){
			fprintf(out,"%d punctuation characters: %s\n",(int)strlen(punc),punc);
		}
		else{
			fprintf(out,"%d punctuation character: %s\n",(int)strlen(punc),punc);
		}
		if(strlen(whitespace)>1){
			fprintf(out,"%d whitespace characters: %s\n",(int)strlen(whitespace),whitespace);
		}
		else{
			fprintf(out,"%d whitespace character: %s\n",(int)strlen(whitespace),whitespace);
		} 
		n++;/*increments the line number*/
	}
	/*free's the heap memory after while loop execution*/
	free(line);
	free(word);
	free(num);
	free(punc);
	free(whitespace);
	/*closes the file*/
	fclose(in);
	fclose(out);

	return EXIT_SUCCESS;
}

