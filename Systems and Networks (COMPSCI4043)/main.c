/**
    This file implements the high level language algorithm of the SIGMA16 assessed exercise.

    Author: Yu-Sung Hsu
    Email: 2540296H@student.gla.ac.uk
    Student ID: 2540296H
    COMPSCI4043 Systems and Networks Assessed Exercise
*/

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // This program uses `short` to simulate 16-bit behaviour.
    short possum, negcount, oddcount, overflow, i;
    
    // Normal testcase
    short n = 12;
    short X[] = {3,-6,27,101,50,0,-20,-21,19,6,4,-10};
    
    // Overflow testcase
    //short n = 2;
    //short X[] = {32766, 2};

    // The following code is included in the SIGMA16 file.
    possum = 0;
    negcount = 0;
    oddcount = 0;
    overflow = 0;  // false
    for (i = 0; i < n; i++) {
         if (X[i] < 0) {
              negcount++;
         } else if (X[i] != 0) {
              possum += X[i];
              if (possum < 0) {
                   overflow = 1;  // true
              }
              if ((X[i] & 1) == 1) {
                   oddcount++;
              }
         }
    }

    // Tests
    // Tests for normal testcase
    printf("%d\n", possum == 210);
    printf("%d\n", oddcount == 4);
    printf("%d\n", negcount == 4);

    // Tests for overflow testcase 
    // printf("%d\n", overflow == 1);

    return 0;
}
