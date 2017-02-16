#include <omp.h>
#include <iostream>
#include <stdio.h>

#define NUM 10
using namespace std;

int main() {
	
	int dist = 0;
	int arr1[NUM] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	int arr2[NUM] = {1, 1, 1, 4, 1, 1, 1, 1, 1, 0};

	#pragma omp parallel num_threads(5)
	{
		printf("thread num %d\n", omp_get_thread_num());

		#pragma omp for firstprivate(arr1, arr2) reduction(+: dist)
		for (int i=0; i<NUM; i++){
			if (arr1[i]!=arr2[i])
			{
				dist ++;
			} else {}
		}
	}
	printf("num %d --> hamming distance %d\n",omp_get_thread_num(), dist);
}