//Narcissistic or Armstrong number upto a given range
//Armstrong numbers/Narcissistic numbers' digits are to be raised to the total number of digits and added to obtain the original number

#include <stdio.h>
#include<math.h>
int main(){
    int a,temp;
    printf("Enter the range for armstrong/narcissistic number");
    scanf("%d",&a);
    
    for(int i=1;i<=a;i++){
        temp=i;
        int sum=0;
        while (temp){
            sum+= round(pow(temp%10,floor(log10(i))+1));// Raising digits to the power of total number of digits in the given number
           temp/=10;    }
        if (sum==i) printf("%d\n",i);
    }
    return 0;
}
