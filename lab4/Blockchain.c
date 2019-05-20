#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Blockchain.h"
#include"Block.h"

#define FIXED_ARRAY_SIZE 100

typedef struct BlockchainObj{
    Block chain[FIXED_ARRAY_SIZE];
    int size;
} BlockchainObj;

Blockchain newBlockchain(){
    Blockchain a = malloc(sizeof(BlockchainObj));
    assert(a!=NULL);
    a->size = 0;
    return(a);
}

void freeBlockchain(Blockchain* pa){
    if( pa!=NULL && *pa!=NULL ){
        free(*pa);
        *pa = NULL;
    }
}

int append(Blockchain a, char* data){
    
    if (a == NULL || data == NULL) {
        return (0);
    }
    
    if(valid(a)==(0)) {
        return (0);
    }
    
    
    long previousHash;
    int id;
    Block b;
    if(a->size == 0){
        previousHash = 0;
    }
    else{
        previousHash = hash(a->chain[a->size-1]);
    }
    id = a->size;
    b = newBlock(data, id, previousHash);
    a->chain[a->size] = b;
    a->size = a->size+1;
    return(a->size);
    
}

int size(Blockchain a){
    return(a->size);
}

Block get(Blockchain a, int idx){
    return (a->chain[idx]);
}

int valid(Blockchain a){
    int index;
    long hash1;
    long hash2;
    Block b;
    
    if (a == NULL) {
        return(0);
    }
    if(size(a)<(2)) {
        return (1);
    }
    
    for (index=0; index < size(a)-1; index++) {
        
        b = get(a, index);
        
        hash1 = hash(b);
        
        b = get(a, index+1);
        hash2 = previousHash(b);
        
        if (hash1 != hash2) {
            return(0);
        }
    }
    return(1);
}


void removeLast(Blockchain a){
    a->size = a->size -1;
}


void printBlockchain(FILE* out, Blockchain a){
    int index;
    if (a == NULL) {
        fprintf(stderr, "Blockchain Error: printBlockchain() called on NULL Block reference\n");
        exit(EXIT_FAILURE);
    }
    fprintf(out, "%d\n", a->size);
    for (index = 0; index < a->size; index++) {
        printBlock(out, a->chain[index]);
    }
    
}
