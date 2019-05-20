#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "Dictionary.h"

const int tableSize = 109;


typedef struct NodeObj {
   char* key;
   char* value;
   struct NodeObj* next;
} NodeObj;

typedef NodeObj* Node;

Node newNode(char* k, char* v) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->key = k;
   N->value = v;
   N->next = NULL;
   return(N);
}


void freeNode(Node* pN) {
   if (pN != NULL && *pN != NULL) {
      free(*pN);
      *pN = NULL;
   }
}

typedef struct DictionaryObj {
   Node *Dict;
   int numItems;
} DictionaryObj;


Dictionary newDictionary() {
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D!=NULL);
   D->Dict = calloc(tableSize,sizeof(Node));
   assert(D->Dict !=NULL);
   D->numItems = 0;
   return D;
}

 
void freeDictionary(Dictionary* pD) {
   if (pD != NULL && *pD != NULL) {
      makeEmpty(*pD);
      free((*pD)->Dict);
      free(*pD);
      *pD = NULL;
   }
}


unsigned int rotate_left(unsigned int value, int shift) {
 int sizeInBits = 8*sizeof(unsigned int);
 shift = shift & (sizeInBits - 1);
 if ( shift == 0 )
 return value;
 return (value << shift) | (value >> (sizeInBits - shift));
}

unsigned int pre_hash(char* input) {
 unsigned int result = 0xBAE86554;
 while (*input) {
 result ^= *input++;
 result = rotate_left(result, 5);
 }
 return result;
}

int hash(char* key){
 return pre_hash(key)%tableSize;
}


int isEmpty(Dictionary D){
   if( D==NULL){
      fprintf(stderr, "NULL Dictionary reference on calling isEmpty()\n");
      exit(EXIT_FAILURE);
   }
   if(D->numItems>0)  return 0;
   return 1;
}
 
int size(Dictionary D){
   return D->numItems;
}


char* lookup(Dictionary D, char* k){
   if( D == NULL ){
      fprintf(stderr, "lookup() called on NULL Dictionary\n");
      exit(EXIT_FAILURE);
   }
   Node N=D->Dict[hash(k)];
   while(N!=NULL){
   if(strcmp(N->key,k) == 0)
      return N->value;
   N=N->next;

}
return NULL;
}


 
void insert(Dictionary D, char* k, char* v){
   if(D == NULL){
      fprintf(stderr, "insert() called on NULL Dictionary\n");
      exit(EXIT_FAILURE);
   }
   if( lookup(D, k) != NULL){
      fprintf(stderr, "insert() called on a pre-existing key\n");
      exit(EXIT_FAILURE);
   } 
    Node N=newNode(k,v);
   int i = hash(k);
   if(D->Dict[i] == NULL){
      D->Dict[i]  = N;
      D->numItems++; 
   }else{
      N->next = D->Dict[i];
      D->Dict[i] = N;
      D->numItems++;
   }
}


void makeEmpty(Dictionary D){
   for(int a = 0; a<tableSize; a++){
      while(D->Dict[a] != NULL){
         Node N;
         N = D-> Dict[a];
         D->Dict[a]=N->next;
         freeNode(&N);
         N = NULL;
      }
   }D->numItems = 0; 

}

 
void delete(Dictionary D, char* k){
if(lookup(D,k)==NULL){
fprintf(stderr,"Delete() called on a non- existent key\n");
exit(EXIT_FAILURE);
}
 int i = hash(k);
        Node temp = D->Dict[i];
        Node tempNode = NULL;
                if (temp->key == k) {
                        tempNode = temp;
                        D->Dict[i] = temp->next;
			freeNode(&tempNode);
                }
                else{
                        while(temp->next->key != k) {
                                temp = temp->next;
                        }
                        tempNode = temp->next;
                        temp->next = tempNode->next;
			freeNode(&tempNode);
                }
                D->numItems--;
        
}

 
void printDictionary(FILE* out, Dictionary D){
    if( D==NULL ){
      fprintf(stderr, "printDictionary() called on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   Node N;
   for(int a = 0; a < tableSize; a++){
      N = D->Dict[a];
      while(N != NULL){
         fprintf(out, "%s %s \n" , N->key, N->value);
         N = N->next;
      }
   } 
}
