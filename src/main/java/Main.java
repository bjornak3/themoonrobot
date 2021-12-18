import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Deimos: ");
        System.out.print("- Risetime ");
        String deimosRiseTimeInput = sc.nextLine();
        System.out.print("- Downtime ");
        String deimosDownTimeInput = sc.nextLine();

        System.out.println("Phobos: ");
        System.out.print("- Risetime ");
        String phobosRiseTimeInput = sc.nextLine();
        System.out.print("- Downtime ");
        String phobosDownTimeInput = sc.nextLine();

        Moon deimos = new Moon();
        Moon phobos = new Moon();

        try {
            deimos.riseTimestamp = MarsTime.parseFromString(deimosRiseTimeInput);
            deimos.downTimestamp = MarsTime.parseFromString(deimosDownTimeInput);

            phobos.riseTimestamp = MarsTime.parseFromString(phobosRiseTimeInput);
            phobos.downTimestamp = MarsTime.parseFromString(phobosDownTimeInput);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        int overlap = OverlapCalculator.calculateOverlap(deimos, phobos);

        System.out.println("overlap: " + overlap);
    }
}
