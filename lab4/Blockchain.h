#ifndef _BLOCKCHAIN_H_INCLUDE_
#define _BLOCKCHAIN_H_INCLUDE_

#include "Block.h"

typedef struct BlockchainObj* Blockchain;

Blockchain newBlockchain();

void freeBlockchain(Blockchain* pB);

int append(Blockchain B, char* data);

int size(Blockchain B);

Block get(Blockchain B, int idx);

int valid(Blockchain B);

void removeLast(Blockchain B);

void printBlockchain(FILE* out, Blockchain B);

#endif
