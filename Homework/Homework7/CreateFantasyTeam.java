package Homework.Homework7;

import Homework.Homework7.model.*;
import Homework.Homework7.service.DefenderService;
import Homework.Homework7.service.ForwardService;
import Homework.Homework7.service.GoalkeeperService;
import Homework.Homework7.service.MidfielderService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CreateFantasyTeam {
    private String path = "";

    public void removeFileInfo() throws IOException {
        System.out.println("What file info do you want remove?");
        Scanner s = new Scanner(System.in);
        path = s.nextLine();
        Files.write(Paths.get(path), "".getBytes());
    }

    public void start() throws IOException {
        creteFile();
        Scanner s = new Scanner(System.in);
        System.out.println("Select tactics");
        System.out.println("1. 4-3-3");
        System.out.println("2. 4-4-2");
        System.out.println("3. 5-3-2");
        System.out.println("4. 3-4-3");
        System.out.println("5. 3-5-2");
        System.out.println("Type any other number to exit");
        switch (s.nextInt()) {
            case 1:
                selectTactics(4, 3, 3);
                break;
            case 2:
                selectTactics(4, 4, 2);
                break;
            case 3:
                selectTactics(5, 3, 2);
                break;
            case 4:
                selectTactics(3, 4, 3);
                break;
            case 5:
                selectTactics(3, 5, 2);
                break;
        }
        sortFootballersByFantasyScore();


    }

    private void selectTactics(int def, int mid, int fwd) throws IOException {
        System.out.println("Fill goalkeeper info");
        Files.write(Paths.get(path), "GK ".getBytes());
        fillFootballerInfo(new GoalKeeper());
        for (int i = 1; i < def + 1; i++) {
            System.out.println("Fill defender " + i + " info");
            Files.write(Paths.get(path), "\nDF ".getBytes(), StandardOpenOption.APPEND);
            fillFootballerInfo(new Defender());
        }
        for (int i = 1; i < mid + 1; i++) {
            System.out.println("Fill  midfielder " + i + " info");
            Files.write(Paths.get(path), "\nMF ".getBytes(), StandardOpenOption.APPEND);
            fillFootballerInfo(new Midfielder());
        }
        for (int i = 1; i < fwd + 1; i++) {
            System.out.println("Fill  forward " + i + " info");
            Files.write(Paths.get(path), "\nFW ".getBytes(), StandardOpenOption.APPEND);
            fillFootballerInfo(new Forward());
        }
    }

    public void creteFile() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter path");
        path = s.nextLine();
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println(path + " File Created");
        } else System.out.println("File " + path + " already exists");
    }

    private void fillFootballerInfo(Footballer footballer) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter footballer firstname");
        footballer.setFirstName(s.nextLine());
        System.out.println("Enter footballer lastname");
        footballer.setLastName(s.nextLine());
        System.out.println("Did footballer appear in the game?true/false");
        footballer.setAppeared(s.nextBoolean());
        if (footballer.isAppeared()) {
            System.out.println("Did footballer play 60+ minutes?true/false");
            footballer.setMinutesPlayed60Plus(s.nextBoolean());
            System.out.println("How many goals scored?");
            footballer.setGoals(s.nextInt());
            System.out.println("How many assists footballer have?");
            footballer.setAssists(s.nextInt());
            System.out.println("How many penalty earned?");
            footballer.setPenaltiesEarned(s.nextInt());
            System.out.println("Have any yellow or red card?");
            System.out.println("1.None of these");
            System.out.println("2.Only ony yellow card");
            System.out.println("3.Only red card without yellow");
            System.out.println("4.Two yellow card(red card)");
            switch (s.nextInt()) {
                case 1:
                    footballer.setYellowCards(false);
                    footballer.setRedCard(false);
                    break;
                case 2:
                    footballer.setYellowCards(true);
                    footballer.setRedCard(false);
                    break;
                case 3:
                    footballer.setYellowCards(false);
                    footballer.setRedCard(true);
                    break;
                case 4:
                    footballer.setYellowCards(true);
                    footballer.setRedCard(true);
                    break;
            }
            System.out.println("How many penalties conceded?");
            footballer.setPenaltiesConceded(s.nextInt());
            System.out.println("How many own goal scored?");
            footballer.setOwnGoal(s.nextInt());
            if (footballer instanceof GoalKeeper) {
                GoalKeeper gk = (GoalKeeper) footballer;
                System.out.println("How many penalty kick saves?");
                gk.setPenaltyKickSaves(s.nextInt());
                System.out.println("How many saves did?");
                gk.setSaves(s.nextInt());
                System.out.println("How many goals conceded?");
                gk.setConcededGoals(s.nextInt());
                if (gk.getConcededGoals() > 0) {
                    gk.setCleanSheet(false);
                }
                writeToFile(gk);
            } else {
                if (footballer instanceof Defender) {
                    Defender df = (Defender) footballer;
                    System.out.println("Did footballer's team concede goal?");
                    df.setCleanSheet(s.nextBoolean());
                    writeToFile(df);
                } else {
                    if (footballer instanceof Forward || footballer instanceof Midfielder) {
                        writeToFile(footballer);
                    }
                }
            }
        } else {
            writeToFile(footballer);
        }
    }

    private void writeToFile(Footballer footballer) throws IOException {
        if (footballer instanceof GoalKeeper) {
            GoalKeeper gk = (GoalKeeper) footballer;
            GoalkeeperService goalkeeperService = new GoalkeeperService();
            countFantasyScore(gk);
            goalkeeperService.writeToFile(path, gk);
        } else {
            if (footballer instanceof Defender) {
                Defender df = (Defender) footballer;
                DefenderService defenderService = new DefenderService();
                countFantasyScore(df);
                defenderService.writeToFile(path, df);
            } else {
                if (footballer instanceof Midfielder) {
                    Midfielder mid = (Midfielder) footballer;
                    MidfielderService midfielderService = new MidfielderService();
                    countFantasyScore(mid);
                    midfielderService.writeToFile(path, mid);
                } else {
                    Forward forward = (Forward) footballer;
                    ForwardService forwardService = new ForwardService();
                    countFantasyScore(forward);
                    forwardService.writeToFile(path, forward);
                }
            }
        }
    }

    public void countFantasyScore(Footballer footballer) {
        if (footballer instanceof GoalKeeper) {
            GoalKeeper goalKeeper = (GoalKeeper) footballer;
            GoalkeeperService goalkeeperService = new GoalkeeperService();
            if (goalKeeper.isAppeared()) {
                goalKeeper.setFantasyScore(goalkeeperService.appearanceScore(goalKeeper.isAppeared()));
                goalKeeper.setFantasyScore(goalkeeperService.minutesPlayed60PlusScore(goalKeeper.isMinutesPlayed60Plus()));
                goalKeeper.setFantasyScore(goalkeeperService.goalsScore(goalKeeper.getGoals()));
                goalKeeper.setFantasyScore(goalkeeperService.assistScore(goalKeeper.getAssists()));
                goalKeeper.setFantasyScore(goalkeeperService.penaltiesEarnedScore(goalKeeper.getPenaltiesEarned()));
                goalKeeper.setFantasyScore(goalkeeperService.yellowCardScore(goalKeeper.hasYellowCard()));
                goalKeeper.setFantasyScore(goalkeeperService.redCardScore(goalKeeper.hasRedCard()));
                goalKeeper.setFantasyScore(goalkeeperService.penaltiesConcededScore(goalKeeper.getPenaltiesConceded()));
                goalKeeper.setFantasyScore(goalkeeperService.ownGoalsScore(goalKeeper.getOwnGoal()));
                goalKeeper.setFantasyScore(goalkeeperService.cleanSheetScore(goalKeeper.wasCleanSheet()));
                goalKeeper.setFantasyScore(goalkeeperService.penaltyKickSavesScore(goalKeeper.getPenaltyKickSaves()));
                goalKeeper.setFantasyScore(goalkeeperService.savesScore(goalKeeper.getSaves()));
                goalKeeper.setFantasyScore(goalkeeperService.concededGoalsScore(goalKeeper.getConcededGoals()));
            }
        }
        if (footballer instanceof Defender) {
            Defender defender = (Defender) footballer;
            DefenderService defenderService = new DefenderService();
            if (defender.isAppeared()) {
                defender.setFantasyScore(defenderService.appearanceScore(defender.isAppeared()));
                defender.setFantasyScore(defenderService.minutesPlayed60PlusScore(defender.isMinutesPlayed60Plus()));
                defender.setFantasyScore(defenderService.goalsScore(defender.getGoals()));
                defender.setFantasyScore(defenderService.assistScore(defender.getAssists()));
                defender.setFantasyScore(defenderService.penaltiesEarnedScore(defender.getPenaltiesEarned()));
                defender.setFantasyScore(defenderService.yellowCardScore(defender.hasYellowCard()));
                defender.setFantasyScore(defenderService.redCardScore(defender.hasRedCard()));
                defender.setFantasyScore(defenderService.penaltiesConcededScore(defender.getPenaltiesConceded()));
                defender.setFantasyScore(defenderService.ownGoalsScore(defender.getOwnGoal()));
                defender.setFantasyScore(defenderService.cleanSheetScore(defender.isCleanSheet()));
            }
        }
        if (footballer instanceof Midfielder) {
            Midfielder midfielder = (Midfielder) footballer;
            MidfielderService midfielderService = new MidfielderService();
            if (midfielder.isAppeared()) {
                midfielder.setFantasyScore(midfielderService.appearanceScore(midfielder.isAppeared()));
                midfielder.setFantasyScore(midfielderService.minutesPlayed60PlusScore(midfielder.isMinutesPlayed60Plus()));
                midfielder.setFantasyScore(midfielderService.goalsScore(midfielder.getGoals()));
                midfielder.setFantasyScore(midfielderService.assistScore(midfielder.getAssists()));
                midfielder.setFantasyScore(midfielderService.penaltiesEarnedScore(midfielder.getPenaltiesEarned()));
                midfielder.setFantasyScore(midfielderService.yellowCardScore(midfielder.hasYellowCard()));
                midfielder.setFantasyScore(midfielderService.redCardScore(midfielder.hasRedCard()));
                midfielder.setFantasyScore(midfielderService.penaltiesConcededScore(midfielder.getPenaltiesConceded()));
                midfielder.setFantasyScore(midfielderService.ownGoalsScore(midfielder.getOwnGoal()));
            }
        }
        if (footballer instanceof Forward) {
            Forward forward = (Forward) footballer;
            ForwardService forwardService = new ForwardService();
            if (forward.isAppeared()) {
                forward.setFantasyScore(forwardService.appearanceScore(forward.isAppeared()));
                forward.setFantasyScore(forwardService.minutesPlayed60PlusScore(forward.isMinutesPlayed60Plus()));
                forward.setFantasyScore(forwardService.goalsScore(forward.getGoals()));
                forward.setFantasyScore(forwardService.assistScore(forward.getAssists()));
                forward.setFantasyScore(forwardService.penaltiesEarnedScore(forward.getPenaltiesEarned()));
                forward.setFantasyScore(forwardService.yellowCardScore(forward.hasYellowCard()));
                forward.setFantasyScore(forwardService.redCardScore(forward.hasRedCard()));
                forward.setFantasyScore(forwardService.penaltiesConcededScore(forward.getPenaltiesConceded()));
                forward.setFantasyScore(forwardService.ownGoalsScore(forward.getOwnGoal()));
            }
        }
    }

    public void sortFootballersByFantasyScore() throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (path.isEmpty()) {
            System.out.println("Enter path");
            path = scanner.nextLine();
        }
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String[] footballersInfo = new String[11];
        String st;
        int i = 0;
        while ((st = br.readLine()) != null) {
            footballersInfo[i++] = st;
        }
        boolean a = true;
        while (a) {
            System.out.println("Do you want print sorted by fantasy score?");
            System.out.println("1.yes by descending order");
            System.out.println("2.yes by ascending order");
            System.out.println("3.Print footballers info and end program");
            System.out.println("Type any other number print footballers info and end program");
            switch (scanner.nextInt()) {
                case 1:
                    descendingOrderBubbleSort(footballersInfo);
                    break;
                case 2:
                    ascendingOrderBubbleSort(footballersInfo);
                    break;
                case 3:
                    a = false;
                    break;
            }
            for (String s : footballersInfo) {
                System.out.println(s);
            }
            System.out.println("------------------------------");
        }
    }

    public void ascendingOrderBubbleSort(String[] a) {
        for (int i = 1; i < a.length; i++) {
            boolean is_sorted = true;

            for (int j = 0; j < a.length - 1; j++) {
                String[] firstArray = a[j].split(" ");
                String[] secondArray = a[j + 1].split(" ");
                if (Integer.parseInt(firstArray[firstArray.length - 1]) > Integer.parseInt(secondArray[secondArray.length - 1])) {
                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sorted = false;
                }
            }

            if (is_sorted) return;
        }
    }

    public void descendingOrderBubbleSort(String[] a) {
        for (int i = 1; i < a.length; i++) {
            boolean is_sorted = true;

            for (int j = 0; j < a.length - 1; j++) {
                String[] firstArray = a[j].split(" ");
                String[] secondArray = a[j + 1].split(" ");
                if (Integer.parseInt(firstArray[firstArray.length - 1]) < Integer.parseInt(secondArray[secondArray.length - 1])) {
                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sorted = false;
                }
            }

            if (is_sorted) return;
        }
    }
}
