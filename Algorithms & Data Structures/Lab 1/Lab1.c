#include <stdio.h>
#include <stdlib.h>
//Andy Tran 1001885635
//Compile Command gcc Lab1.c 
int binSearchLast(int *a, int n, int key){
    int low,high,mid;
    low = 0;
    high=n-1;

    while(low<=high){
        mid = (low+high)/2;
        if(a[mid]<=key)
            low=mid+1;
        else
            high=mid-1;
    }
    return high;
}
int binSearchFirst(int *a,int n,int key)
{
  int low,high,mid;
  low=0;
  high=n-1;

  while (low<=high)
  {
    mid=(low+high)/2;
    if (a[mid]<key)
      low=mid+1;
    else
      high=mid-1;
  }
  return low;
}
int main(void) {
    int n,choice;
    choice = 0;

    
    scanf("%d\n",&n);
    int* count = (int*)calloc(n,sizeof(int));
    int* index = (int*)calloc(n,sizeof(int));
    int* map = (int*)calloc(n,sizeof(int));
    

    for(int i = 0; i < n; i++){
        count[i] = 0;
        index[i] = i;
        map[i] = i;
    }
        
        scanf("%d\n",&choice);

    while(choice != 0) {

        switch (choice)
        {
            case 1:
            {
                printf("Print By Ascending Index\n");
                for(int i = 0; i < n; i++){
                    printf("%d %d\n", i, count[map[i]]);
                }
                printf("\n");
                break;
            }
            case 2:
            {
                printf("Print By Ascending Counter\n");
                for(int i = 0; i < n; i++){
                    printf("%d %d\n", index[i], count[i]);
                }
                printf("\n");
                break;
            }
            case 3:
            {
                int counter;
                int x;
                scanf("%d\n",&counter);
                x = binSearchLast(count,n,count[map[counter]]);
                int mapT = map[index[x]];
                map[index[x]] = map[counter];                
                map[counter] = mapT;

                int indexT = index[x];
                index[x] = index[map[counter]];
                index[map[counter]] = indexT;
                
                count[x]++;
            
                break;
            }
            case 4: 
            {
                int placement;
                scanf("%d", &placement); 
                int y = binSearchFirst(count, n, count[ map[placement]]);
                int tempindex = index[y];
                int tempmap = map[index[y]];

                map[index[y]] = map[placement];
                index[y] = index[ map[placement]];
                index[map[placement]] = tempindex;
                map[placement] = tempmap;

                count[y]--;
            
                break;
            }
            case 5: 
            {
                int value1;
                int value2;
                scanf("%d", &value1);
                scanf("%d", &value2);

                int j = binSearchLast(count, n,value2);
                int i = binSearchFirst(count,n,value1);

                printf("%d counters valued between %d and %d\n", j-i + 1,value1, value2 );

                break;
            }
            default:
                break;
        }
        
        scanf("%d",&choice);
    }      
}