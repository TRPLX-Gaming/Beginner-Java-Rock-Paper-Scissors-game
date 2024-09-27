import java.util.*;

public class RPSGame {
    
    static String[] opts = {"rock","paper","scissors"};
    static Scanner interact = new Scanner(System.in);
    static Scanner chooseRound = new Scanner(System.in);
    static int playerPoints = 0;
    static int computerPoints = 0;
    static int numOfRounds;
    static int roundCheck;
    static String playerInput;
    static String computerInput;
    static Random any = new Random();
    
    public static void main(String[] args) {
        
        startGame();
        
    }
    
    static void startGame() {
        playerPoints = 0;
        computerPoints = 0;
        roundCheck = 0;
        System.out.println("Welcome to RPS");
        System.out.println("Choose the number of rounds between 3-10");
        numOfRounds = chooseRound.nextInt();
        System.out.println("Game starts with "+numOfRounds+" rounds");
        game();
    }
    
    static void game() {
        if(roundCheck < numOfRounds) {
            roundCheck++;
            while(true) {
                System.out.println("Choose either Rock/Paper/Scissors");
                String playerOption = interact.nextLine();
                String computerOption = getRandomArrayValue(opts);
                String winner = analysis(playerOption,computerOption);
                if(winner.equals("player") || winner.equals("computer")) {
                    System.out.println("The round winner is "+winner+" so the scores are "+playerPoints+"-"+computerPoints);
                } else if(winner.equals("draw")) {
                    System.out.println("The round is a draw and the scores are "+playerPoints+"-"+computerPoints);
                } else if(winner.equals("invalid")) {
                    System.out.println("Wrong Input so null round");
                } else {
                    System.out.println("Game Over!");
                    if(playerPoints > computerPoints) {
                        System.out.println("The winner is the PLAYER!");
                    } else {
                        System.out.println("The winner is the COMPUTER");
                    }
                    break;
                }
            }
        } else {
            System.out.println("Game Over!");
        }
    }
    
    static String getRandomArrayValue(String[] arr) {
        int randomIndex = any.nextInt(arr.length);
        return arr[randomIndex];
    }
    
    static String analysis(String pInput, String cInput) {
        String playerInput = pInput.trim().toLowerCase();
        String computerInput = cInput.trim().toLowerCase();
        
        if(playerPoints >= numOfRounds && computerPoints <= numOfRounds) {
            return "end";
        }
        
        if(playerInput.equals(computerInput)) {
            playerPoints++;
            computerPoints++;
            return "draw";
        } else if(playerInput.equals("rock")) {
            if(computerInput.equals("paper")) {
                computerPoints++;
                return "computer";
            } else {
                playerPoints++;
                return "player";
            }
        } else if(playerInput.equals("paper")) {
            if(computerInput.equals("scissors")) {
                computerPoints++;
                return "computer";
            } else {
                playerPoints++;
                return "player";
            }
        } else if(playerInput.equals("scissors")) {
            if(computerInput.equals("rock")) {
                computerPoints++;
                return "computer";
            } else {
                playerPoints++;
                return "player";
            }
        } else {
            return "Invalid";
        }
        
    }
    
}
