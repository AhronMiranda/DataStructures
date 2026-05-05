import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class QuizApp {

    // TYPE DESIGN
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String BLUE = "\033[0;34m";
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String RESET = "\033[0m";

    public static Scanner sc = new Scanner(System.in);
    public static int correctAnswer = 0;
    public static List<User> users = new ArrayList<>();
    public static User currentUser;

    public QuizApp() {
        runQuiz();
    }

    public static void runQuiz() {
        load();

        while (true) {

            correctAnswer = 0;
            currentUser = null;

            switch (menu()) {
                case 1:

                    switch (menuRegister()) {
                        case 1:
                            System.out.println("""
                                    +-----------------------------+
                                    |            LOGIN            |
                                    +-----------------------------+

                                    """);
                            login();
                            break;

                        case 2:
                            System.out.println("""
                                    +-----------------------------+
                                    |        REGISTER USER        |
                                    +-----------------------------+

                                    """);
                            register();
                            break;

                        default:
                            System.out.println("Back");
                            continue;
                    }
                    break;

                case 2:
                    System.out.println("Playing");
                    break;

                case 3:
                    editMultipleChoice();
                    continue;

                case 4:
                    editIdentification();
                    continue;

                case 5:
                    displayLeaderboard();
                    continue;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            initializeMultipleChoice();
            initializeIdentification();

            if (currentUser != null) {
                System.out.println(currentUser.getUsername() + " | TOTAL SCORE: " + correctAnswer);
                currentUser.setScore(correctAnswer);
                save();
            } else {
                System.out.println("GUEST | TOTAL SCORE: " + correctAnswer);
            }

            save();
        }
    }

    // MENUS LOGIN AND REGISTER METHODS

    public static int menu() {
        System.out.println(RED + """
                +--------------------------------+
                |       PINOY TRIVIA QUIZ        |
                +--------------------------------+

                """ + RESET);
        System.out.println("""
                [1] REGISTER AND PLAY
                [2] PLAY AS GUEST
                [3] EDIT MULTIPLE CHOICE
                [4] EDIT IDENTIFICATION
                [5] DISPLAY LEADERBOARD
                [0] EXIT
                """);
        System.out.print("user>>");
        return intInput();
    }

    public static int menuRegister() {
        System.out.println("""
                [1] LOGIN
                [2] NEW PLAYER
                [0] BACK
                """);
        System.out.print("user>>");
        return intInput();
    }

    public static void login() {
        while (true) {

            System.out.println("ENTER YOUR USERNAME");
            System.out.print("user>>");
            String username = strInput();

            boolean found = false;

            for (User i : users) {
                if (i.getUsername().equals(username)) {

                    System.out.println("ENTER YOUR PASSCODE");
                    System.out.print("user>>");
                    int passcode = intInput();

                    if (i.getPasscode() == passcode) {
                        currentUser = i;
                        System.out.println("Login successful!");
                        return;
                    } else {
                        System.out.println("Incorrect password.");
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Username not found.");
            }
        }
    }

    public static void register() {
        System.out.println("ENTER YOUR USERNAME");
        System.out.print("user>>");
        String username = strInput();

        for (User i : users) {
            if (i.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        System.out.println("ENTER YOUR PASSCODE");
        System.out.print("user>>");
        int passcode = intInput();

        currentUser = new User(username, passcode);
        users.add(currentUser);

        System.out.println("Registration successful!");
    }

    public static String strInput() {
        while (true) {
            try {
                String temp = sc.nextLine();

                if (temp.isEmpty()) {
                    System.out.println(RED + "[NO INPUT]" + RESET);
                    continue;
                }
                return temp;
            } catch (InputMismatchException e) {
                System.out.println(RED + "[INVALID INPUT]" + RESET);
            }
        }
    }

    public static int intInput() {
        while (true) {
            try {
                int temp = sc.nextInt();
                sc.nextLine();
                return temp;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(RED + "[INVALID INPUT]" + RESET);
            }
        }
    }

    public static void editMultipleChoice() {
        try {
            File file = new File("MultipleChoice.txt");
            Scanner FR = new Scanner(file);
            ArrayList<String[]> questions = new ArrayList<>();

            while (FR.hasNextLine()) {
                String[] block = new String[5];
                for (int i = 0; i < 5; i++) {
                    block[i] = FR.nextLine();
                }
                questions.add(block);
            }

            for (int i = 0; i < questions.size(); i++) {
                String[] q = questions.get(i);
                System.out.println("INDEX [" + i + "]");
                for (String line : q) {
                    System.out.println(line);
                }
                System.out.println();
            }

            System.out.println("Enter question index to edit:");
            System.out.print("user>>");
            int index = intInput();

            String[] edited = new String[5];
            System.out.println("NEW QUESTION:");
            edited[0] = strInput();
            edited[1] = strInput();
            edited[2] = strInput();
            edited[3] = strInput();
            edited[4] = strInput();

            questions.set(index, edited);

            FileWriter FW = new FileWriter(file);
            for (String[] q : questions) {
                for (String line : q) {
                    FW.write(line + "\n");
                }
            }

            FW.close();
            FR.close();

            System.out.println("MULTIPLE CHOICE UPDATED.");

        } catch (IOException e) {
            System.out.println("File error.");
        }
    }

    public static void editIdentification() {
        try {
            File file = new File("Identification.txt");
            Scanner FR = new Scanner(file);
            ArrayList<String[]> questions = new ArrayList<>();

            while (FR.hasNextLine()) {
                String[] block = new String[2];
                block[0] = FR.nextLine();
                block[1] = FR.nextLine();
                questions.add(block);
            }

            for (int i = 0; i < questions.size(); i++) {
                String[] q = questions.get(i);
                System.out.println("INDEX [" + i + "]");
                System.out.println(q[0]);
                System.out.println(q[1]);
                System.out.println();
            }

            System.out.println("Enter question index to edit:");
            System.out.print("user>>");
            int index = intInput();

            String[] edited = new String[2];
            System.out.println("NEW QUESTION:");
            edited[0] = strInput();
            edited[1] = strInput();

            questions.set(index, edited);

            FileWriter FW = new FileWriter(file);
            for (String[] q : questions) {
                FW.write(q[0] + "\n");
                FW.write(q[1] + "\n");
            }

            FW.close();
            FR.close();

            System.out.println("IDENTIFICATION UPDATED.");

        } catch (IOException e) {
            System.out.println("File error.");
        }
    }

    // INITIALIZE QUIZ QUESTIONS

    public static void initializeMultipleChoice() {

        System.out.println("""
                --- I. MULTIPLE CHOICE (A/B/C, NEXT, BACK)
                +------------------------------------------------------------------------+
                """);

        try {
            File file = new File("MultipleChoice.txt");
            Scanner FR = new Scanner(file);

            String[] q = new String[50];
            String[] a = new String[50];
            String[] b = new String[50];
            String[] c = new String[50];
            String[] correct = new String[50];

            int ctr = 0;

            while (FR.hasNextLine()) {
                q[ctr] = FR.nextLine();
                a[ctr] = FR.nextLine();
                b[ctr] = FR.nextLine();
                c[ctr] = FR.nextLine();
                correct[ctr] = FR.nextLine();
                ctr++;
            }

            ArrayList<Integer> questions = new ArrayList<>();
            while (questions.size() < 10) {
                int r = (int) (Math.random() * ctr);
                if (!questions.contains(r))
                    questions.add(r);
            }

            Stack<Integer> history = new Stack<>();
            String[] userAnswers = new String[10];
            boolean[] answered = new boolean[10];
            boolean[] isCorrect = new boolean[10];

            int index = 0;
            int score = 0;

            while (index < 10) {

                int qi = questions.get(index);

                System.out.printf("""
                        --- Question %d
                        %s

                        > %s
                        > %s
                        > %s

                        (A/B/C, NEXT, BACK)
                        """,
                        index + 1, q[qi], a[qi], b[qi], c[qi]);

                String input = strInput().toUpperCase();

                if (input.equals("BACK")) {
                    if (index > 0) {
                        index--;
                    } else {
                        System.out.println("Already first question.");
                    }
                    continue;
                }

                if (input.equals("NEXT")) {
                    history.push(qi);
                    index++;
                    continue;
                }

                if (!input.matches("[ABC]")) {
                    System.out.println("Invalid input.");
                    continue;
                }

                userAnswers[index] = input;

                char correctAns = correct[qi].trim().charAt(correct[qi].length() - 2);
                boolean newCorrect = (input.charAt(0) == correctAns);

                if (!answered[index]) {
                    answered[index] = true;
                    isCorrect[index] = newCorrect;

                    if (newCorrect) {
                        score++;
                        correctAnswer++;
                        System.out.println(GREEN + "Correct!" + RESET);
                    } else {
                        System.out.println(RED + "Wrong!" + RESET);
                    }

                } else {

                    if (isCorrect[index] && !newCorrect) {
                        score--;
                        correctAnswer--;
                    } else if (!isCorrect[index] && newCorrect) {
                        score++;
                        correctAnswer++;
                    }

                    isCorrect[index] = newCorrect;
                }

                index++;
            }

            System.out.println("MULTIPLE CHOICE SCORE: " + score);

            FR.close();

        } catch (IOException e) {
            System.out.println("File error.");
        }
    }

    public static void initializeIdentification() {

        System.out.println("""
                --- II. IDENTIFICATION (Answer / NEXT / BACK)
                +------------------------------------------------------------------------+
                """);

        try {
            File file = new File("Identification.txt");
            Scanner FR = new Scanner(file);

            String[] q = new String[50];
            String[] correct = new String[50];

            int ctr = 0;

            while (FR.hasNextLine()) {
                q[ctr] = FR.nextLine();
                correct[ctr] = FR.nextLine();
                ctr++;
            }

            ArrayList<Integer> questions = new ArrayList<>();
            while (questions.size() < 10) {
                int r = (int) (Math.random() * ctr);
                if (!questions.contains(r))
                    questions.add(r);
            }

            String[] userAnswers = new String[10];
            boolean[] answered = new boolean[10];
            boolean[] isCorrect = new boolean[10];

            int index = 0;
            int score = 0;

            while (index < 10) {

                int qi = questions.get(index);

                System.out.printf("""
                        --- Question %d
                        %s

                        """,
                        index + 1, q[qi]);

                String input = strInput();

                if (input.equalsIgnoreCase("BACK")) {
                    if (index > 0)
                        index--;
                    else
                        System.out.println("Already first question.");
                    continue;
                }

                if (input.equalsIgnoreCase("NEXT")) {
                    index++;
                    continue;
                }

                userAnswers[index] = input;

                boolean newCorrect = input.equalsIgnoreCase(correct[qi]);

                if (!answered[index]) {
                    answered[index] = true;
                    isCorrect[index] = newCorrect;

                    if (newCorrect) {
                        score++;
                        correctAnswer++;
                        System.out.println(GREEN + "Correct!" + RESET);
                    } else {
                        System.out.println(RED + "Wrong!" + RESET);
                    }

                } else {
                    if (isCorrect[index] && !newCorrect) {
                        score--;
                        correctAnswer--;
                    } else if (!isCorrect[index] && newCorrect) {
                        score++;
                        correctAnswer++;
                    }

                    isCorrect[index] = newCorrect;
                }

                index++;
            }

            System.out.println("IDENTIFICATION SCORE: " + score);

            FR.close();

        } catch (IOException e) {
            System.out.println("File error.");
        }
    }

    public static void displayLeaderboard() {
        ArrayList<User> leaderboard = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {

            String username;

            while ((username = reader.readLine()) != null) {
                String passcodeLine = reader.readLine(); // skipped
                String scoreLine = reader.readLine();

                if (passcodeLine == null || scoreLine == null) {
                    System.out.println("Corrupted user data.");
                    return;
                }

                User user = new User();
                user.setUsername(username.trim());
                user.setPasscode(Integer.parseInt(passcodeLine.trim()));
                user.setScore(Integer.parseInt(scoreLine.trim()));

                leaderboard.add(user);
            }

            // Sort descending by score
            leaderboard.sort((u1, u2) -> Integer.compare(u2.getScore(), u1.getScore()));

            System.out.println("""
                    +--------------------------------+
                    |          LEADERBOARD           |
                    +--------------------------------+
                    """);

            for (int i = 0; i < leaderboard.size(); i++) {
                User user = leaderboard.get(i);
                System.out.printf("[%d] %-15s SCORE: %d%n",
                        i + 1,
                        user.getUsername(),
                        user.getScore());
            }

            System.out.println("+--------------------------------+");

        } catch (IOException e) {
            System.out.println("Error reading leaderboard.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid score format.");
        }
    }

    // LOAD AND SAVE METHODS

    public static void save() {
        try (FileWriter saveWriter = new FileWriter("Users.txt")) {

            for (User i : users) {
                saveWriter.write(i.getUsername() + "\n");
                saveWriter.write(i.getPasscode() + "\n");
                saveWriter.write(i.getScore() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try (BufferedReader loadReader = new BufferedReader(new FileReader("Users.txt"))) {

            String username;

            while ((username = loadReader.readLine()) != null) {
                String passwordLine = loadReader.readLine();
                String scoreLine = loadReader.readLine();

                if (passwordLine == null) {
                    System.out.println("Missing password for user: " + username);
                    break;
                }
                if (scoreLine == null) {
                    System.out.println("Missing score for user: " + username);
                    break;
                }

                User i = new User();
                i.setUsername(username.trim());
                i.setPasscode(Integer.parseInt(passwordLine.trim()));
                i.setScore(Integer.parseInt(scoreLine.trim()));

                users.add(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file.");
        }
    }

}
