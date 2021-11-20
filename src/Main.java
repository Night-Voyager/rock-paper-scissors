import java.util.*;

public class Main {
    public static void main(String[] args) {
        int round = 1;

        Random random = new Random();
        int pre_state = 0, current_state, machine_state, guess_state = 0; // 0: rock; 1: paper; 2: scissors

        int [][] tpm = new int[3][3]; // TPM: Transition Probability Matrix
        int [][] count = new int[3][3]; // count the amount of the occurrence of each state

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nRound " + round +
                    "\nPlease enter one of the followings as your choice: 0: rock; 1: paper; 2: scissors");

            if (round == 1) {
                machine_state = random.nextInt(3);
            }
            else {
                guess_state = indexOfMaxValue(count[pre_state]);
                machine_state = (guess_state + 1) % 3;
            }

            current_state = scanner.nextInt();
            System.out.println(
                    "You give: " + stateToString(current_state) + "\n" +
                    "The machine gives: " + stateToString(machine_state) + "\n" +
                    "The result is: " + whoWins(current_state, machine_state)
            );

            if (round != 1) {
                System.out.println("The machine guessed that you would give: " + stateToString(guess_state));
                count[pre_state][current_state]++;
            }

            pre_state = current_state;
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

    public static int indexOfMaxValue(int [] array) {
        int i=0, index=i, value=array[0];
        for (; i<array.length; i++) {
            if (array[i] > value) {
                index = i;
                value = array[i];
            }
        }
        return index;
    }

    public static String stateToString(int state) {
        switch (state) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
        }
        return "illegal input";
    }
}
