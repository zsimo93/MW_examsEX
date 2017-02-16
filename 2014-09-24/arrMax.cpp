#include <omp.h>
#include <iostream>
#include <stdio.h>

#define NUM 11
using namespace std;

int main() {
	
	float arr[NUM] = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	int maxTotal = arr[0];
	

	#pragma omp parallel shared(maxTotal, arr) num_threads(5)
	{
		int max = arr[0];

		#pragma omp for firstprivate(arr)
		for (int i=0; i<NUM; i++){
			max = (arr[i]>max) ? arr[i] : max;
		}

		#pragma omp critical
		{
			maxTotal = (max > maxTotal) ? max : maxTotal;
		}

		#pragma omp barrier
		#pragma omp single
		{
			printf("%d\n",maxTotal);		
		}

		#pragma omp for
		for (int i=0; i<NUM; i++){
			arr[i] = arr[i]/maxTotal;
		}

	}

	for (int i=0; i<NUM; i++){
			printf("%f\t",arr[i]);
		}
	printf("\n");
	return 0;
}