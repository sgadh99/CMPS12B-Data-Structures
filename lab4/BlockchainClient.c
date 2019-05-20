#include<stdio.h>
#include<stdlib.h>
#include "Blockchain.h"

int main(int argc, char* argv[]){
  Blockchain chain = newBlockchain();
  
  char hackable[] = "one";
  printf("%d\n", append(chain, hackable));
  printf("%d\n", append(chain, "two"));
  printf("%d\n", append(chain, "three"));
  printf("valid = %d\n", valid(chain));
  
  for (int i = 0; i < size(chain); i++) {
    printBlock(stdout,get(chain, i));
  }
  removeLast(chain);
  printBlockchain(stdout, chain);


  Block b = get(chain, 0);
  char* value =  data(b);
  *value = (*value)+1; 
  printf("valid = %d\n", valid(chain));

  printf("%d\n", append(chain, "five"));

  freeBlockchain(&chain);
  return 0;
}
