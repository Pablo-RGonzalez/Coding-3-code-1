package pack;
/*
public class GreatCommission {
	public static void main(String[] args) {
		long totalDisciples = 13;
		int disciplesTrainedPerCycle = 2;
		int trainingCycleYears = 3;
		long targetPopulation = 7_700_000_000L;
		int years = 0;

		while (totalDisciples < targetPopulation) {
			totalDisciples *= disciplesTrainedPerCycle;
			years += trainingCycleYears;
		}

		System.out.println("It would take approximately " + years + " years to convert all humans to disciples of Christ.");
	}
}
*/
public class GreatCommission {
    public static void main(String[] args) {
        int initialDisciples = 13;
        int trainingCycleYears = 3;
        long totalDisciples = initialDisciples;
        int years = 0;

        while (years < 50) {
            initialDisciples *= 2;
            totalDisciples += initialDisciples;
            years += trainingCycleYears;
        }

        System.out.println("To achieve the goal in 50 years, " + initialDisciples + " disciples should be trained together at a time.");
    }
}
