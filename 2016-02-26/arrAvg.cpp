#include <omp.h>
#include <iostream>
#include <stdio.h>

#define NUM 11
using namespace std;

int main() {
	
	double sum = 0;
	double arr[NUM] = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	double avg = 0;
	

	#pragma omp parallel shared(arr, avg, sum) num_threads(5)
	{
		printf("thread num %d\n", omp_get_thread_num());

		#pragma omp for firstprivate(arr) reduction(+: sum)
		for (int i=0; i<NUM; i++){
			sum = sum + arr[i];
		}

		#pragma omp single
		{
			avg = sum / NUM;
		}

		#pragma omp for firstprivate(avg, sum)
		for (int i=0; i<NUM; i++){
			arr[i] = arr[i]/avg;
		}

	}

	printf("avg %f sum %f\n",avg, sum);
	for (int i=0; i<NUM; i++){
			printf("%f\t",arr[i]);
		}
	printf("\n");
}