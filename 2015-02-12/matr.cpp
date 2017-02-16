#include <omp.h>
#include <iostream>
#include <stdio.h>

#define ROWS 5
#define LINES 5
using namespace std;

int main() {
	
	int numelem = ROWS * LINES;
	int sum = 0;
	double avgM = 0;
	int M[ROWS][LINES] = {{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4}};
	int N[ROWS][LINES];

	#pragma omp parallel firstprivate(M, numelem, N) num_threads(5)
	{
		printf("thread num %d\n", omp_get_thread_num());

		#pragma omp for reduction(+: sum)
		for (int i=0; i<ROWS; i++){
			for (int j=0; j<LINES; j++){
				sum = sum + M[i][j];
			}
		}
	}
		
	avgM = sum / numelem;
	printf("avg is %f\n", avgM);
		

	#pragma omp parallel for firstprivate(M) shared(numelem, N, sum) num_threads(5)
	for (int i=0; i<ROWS; i++){
		for (int j=0; j<LINES; j++){
			N[i][j] = M[i][j]-avgM;
		}
	}

	for (int i=0; i<ROWS; i++){
		for (int j=0; j<LINES; j++){
			printf("%d\t", N[i][j]);
		}
	printf("\n");
	}
}