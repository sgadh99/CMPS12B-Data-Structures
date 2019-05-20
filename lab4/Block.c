#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "Block.h"

typedef struct BlockObj{
    char* data;
    long hash;
    int id;
}BlockObj;


Block newBlock(char* data, int id, long hash){
    Block A = (Block)malloc(sizeof(BlockObj));
    assert(B!=NULL);
    A -> data = data;
    A -> hash = hash;
    return A;
}


void freeBlock(Block* pA){
    free(*pA);
    *pA = NULL;
}

char* data(Block A)
{
    if(A==NULL){
        fprintf(stderr, "Block Error: data() called on NULL Block reference\n");
        exit(EXIT_FAILURE);
    }
    return A-> data;
}

long previousHash(Block A){
    if(A==NULL){
        fprintf(stderr, "Block Error: calling pop() on NULL Stack referencec\n");
        exit(EXIT_FAILURE);
    }
    return A->hash;
}
long hash(Block A){
    int i;
    long hash=0;
    if(A==NULL){
        fprintf(stderr, "Block Error: calling hash() on NULL Block reference\n");
        exit(EXIT_FAILURE);
    }
    for(i=0; i <strlen(A-> data); i++){
        hash+=A->data[i];
    }
    hash = hash + A->id;
    hash = hash + A->hash;
    return hash;
}


void printBlock(FILE* out, Block A){
    if(A==NULL){
        fprintf(stderr, "Block Error: calling printBlock() on NULL Block reference\n");
        exit(EXIT_FAILURE);
    }
    fprintf(out, "%d:%s\n", A-> id, A->data);
}

