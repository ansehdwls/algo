#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)
int** A;
int numMax(int n){
    int max;
    max = (A[n][0] + A[n][1] + A[n][2])%10;
    for(int i = 0 ; i < 5 ; i++)
        for(int j = i+1 ; j < 5 ; j++)
            for(int k = j+1 ; k < 5 ; k++)
                if(max < (A[n][i] + A[n][j] + A[n][k])%10)
                {
                    max = (A[n][i] + A[n][j] + A[n][k])%10;
                }
    return max;
}
int main(void){
    int n;
    scanf("%d",&n);
    int max = 0;
    A = (int**)malloc( sizeof(int*) * n );
    for(int i = 0 ; i < n ; i++)
    {
        A[i] =(int*)malloc(sizeof(int)*5);
        for(int j = 0 ; j < 5 ;j++)
        {
            scanf("%d",&A[i][j]);
        }
    }

    for(int i = 1 ; i < n ; i++)
    {
        if(numMax(i) >= numMax(max)){
            max = i;
        }
    }

    printf("%d",max+1);
    free(A);

    return 0;
}