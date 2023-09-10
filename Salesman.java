package salesman.java;

public class Salesman {
    public String Name;
    public float TotalSales;

    public Salesman(String Name, float TotalSales) {
        this.Name = Name;
        this.TotalSales = TotalSales;

    }

    public static Salesman[] GetTopFive(Salesman[] sales) {
        Salesman top5[] = new Salesman[5];
        for (int i = 0; i < sales.length; i++) {
            int counter = 0;
            while (counter < 5 && (top5[counter] == null || top5[counter].TotalSales < sales[i].TotalSales)) {
                if(counter == 0) {
                    top5[counter] = sales[i];
                } else {
                    Salesman temp = null;
                    temp = top5[counter];
                    top5[counter] = sales[i];
                    top5[counter - 1] = temp;
                }
                counter++;
            }
        }
        return top5;
    }

    @Override 
    public String toString(){
        return "Salesman: " + this.Name + " has yearly total sales at $" + this.TotalSales;
    }
}