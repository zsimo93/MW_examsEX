#include <omp.h>

#define ROWS 5
#define LINES 5
using namespace std;

int main() {
    
    int sum = 0;
    int M[ROWS][LINES] = {{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4}};

    #pragma omp parallel firstprivate(M, numelem, N) num_threads(5)
    {
            for (int j=0; j<LINES; j++){
                if(M[i][j]!= 0)
                    sum++;
            }
        }
    }
