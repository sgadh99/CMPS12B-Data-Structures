#include <stdio.h>
#include <stdlib.h>
#ifndef _BLOCK_H_INCLUDE_
#define _BLOCK_H_INCLUDE_

typedef struct BlockObj* Block;

Block newBlock(char* data, int id, long hash);

void freeBlock(Block* pB);

char* data(Block B);

long previousHash(Block B);

long hash(Block B);

void printBlock(FILE* out, Block B);

#endif
