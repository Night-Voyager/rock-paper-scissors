import java.util.*;

public class Main {
    public static void main(String[] args) {
        int round = 1;

        Random random = new Random();
        int pre_state, current_state, machine_state; // 0: rock; 1: paper; 2: scissors

        int [][] tpm = new int[3][3]; // TPM: Transition Probability Matrix
        int [][] count = new int[3][3]; // count the amount of the occurrence of each state

        machine_state = random.nextInt(3);
//        System.out.println(machine_state);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nRound " + round +
                    "\nPlease enter one of the followings as your choice: 0: rock; 1: paper; 2: scissors");
            current_state = scanner.nextInt();
            machine_state = random.nextInt(3);
            System.out.println("The machine gives: " + machine_state + "\n" +
                    "The result is: " + whoWins(current_state, machine_state));

            round++;
        }
    }

    public static String whoWins(int human_state, int machine_state) {
        Set<Integer> legal_inputs = new HashSet<>();
        legal_inputs.add(0);
        legal_inputs.add(1);
        legal_inputs.add(2);

        if (!legal_inputs.contains(human_state)) return "illegal input";

        if (human_state == machine_state) return "tie";

        if (human_state - machine_state == 1 || human_state - machine_state == -2) return "you win";

        return "machine wins";
    }
}
