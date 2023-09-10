package salesman.java;

public class HelloWorld{

    public static void main(String[] args) {
        Salesman sales[] = new Salesman[10];
        sales[0] = new Salesman("hunter", 1000);
        sales[1] = new Salesman("john", 2500);
        sales[2] = new Salesman("smith", 7000);
        sales[3] = new Salesman("jane", 2000);
        sales[4] = new Salesman("tim", 12000);
        sales[5] = new Salesman("hannah", 8000);
        sales[6] = new Salesman("peter", 25000);
        sales[7] = new Salesman("mike", 30000);
        sales[8] = new Salesman("amy", 40000);
        sales[9] = new Salesman("harry", 15000);
        Salesman result[] = Salesman.GetTopFive(sales);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(sales[i]);
        }
        System.out.println("The top five salesmen are: ");
        for (int i = 0; i < 5; i++) {
        	System.out.println(result[i]);
        }

    }

    public static int FindMax(int[] array) {
        int tempMax = -1;
        for(int i = 0; i < array.length; i++) {
            if (tempMax < array[i]) {
                tempMax = array[i];
            }
        }

        return tempMax;
    }
}