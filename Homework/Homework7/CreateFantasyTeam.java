package Homework.Homework7;

import Homework.Homework7.model.*;
import Homework.Homework7.service.GoalkeeperService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CreateFantasyTeam {
    public String path ;
    public int teamScore=0;
    public void freeToFile() throws IOException {
        Files.write(Paths.get(path),"".getBytes());
    }
    public void fillFootballersInfo() throws IOException {
        creteFile();
        Scanner s = new Scanner(System.in);
        System.out.println("Select tactics");
        System.out.println("1. 4-3-3");
        System.out.println("2. 4-4-2");
        System.out.println("3. 5-3-2");
        System.out.println("4. 3-4-3");
        System.out.println("5. 3-5-2");
        System.out.println("Type any number to exit");
        switch (s.nextInt()){
            case 1:
                fourThreeThree();
                break;
            case 2:
                fourFourTwo();
                break;
            case 3:
                fiveThreeTwo();
                break;
            case 4:
                threeFourThree();
                break;
            case 5:
                threeFiveTwo();
                break;
        }
    }
    public void fourThreeThree() throws IOException {
        System.out.println("Fill goalkeeper info");
        fillGoalKeeperInfo(new GoalKeeper());
        System.out.println("Fill first defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill second defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill third defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill fourth defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill first midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill second midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill third midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill first forward info");
        fillForwardInfo(new Forward());
        System.out.println("Fill second forward info");
        fillForwardInfo(new Forward());
        System.out.println("Fill third forward info");
        fillForwardInfo(new Forward());
    }
    public void fourFourTwo() throws  IOException{

        System.out.println("Fill goalkeeper info");
        fillGoalKeeperInfo(new GoalKeeper());
        System.out.println("Fill first defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill second defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill third defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill fourth defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill first midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill second midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill third midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill fourth midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill first forward info");
        fillForwardInfo(new Forward());
        System.out.println("Fill second forward info");
        fillForwardInfo(new Forward());
    }
    public void fiveThreeTwo() throws IOException {
        System.out.println("Fill goalkeeper info");
        fillGoalKeeperInfo(new GoalKeeper());
        System.out.println("Fill first defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill second defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill third defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill fourth defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill fifth defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill first midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill second midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill third midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill first forward info");
        fillForwardInfo(new Forward());
        System.out.println("Fill second forward info");
        fillForwardInfo(new Forward());
    }
    public void threeFourThree() throws IOException {
        System.out.println("Fill goalkeeper info");
        fillGoalKeeperInfo(new GoalKeeper());
        System.out.println("Fill first defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill second defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill third defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill first midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill second midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill third midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill fourth midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill first forward info");
        fillForwardInfo(new Forward());
        System.out.println("Fill second forward info");
        fillForwardInfo(new Forward());
        System.out.println("Fill third forward info");
        fillForwardInfo(new Forward());
    }
    public void threeFiveTwo() throws IOException {
        System.out.println("Fill goalkeeper info");
        fillGoalKeeperInfo(new GoalKeeper());
        System.out.println("Fill first defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill second defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill third defender info");
        fillDefenderInfo(new Defender());
        System.out.println("Fill first midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill second midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill third midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill fourth midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill fifth midfielder info");
        fillMidfielderInfo(new Midfielder());
        System.out.println("Fill first forward info");
        fillForwardInfo(new Forward());
        System.out.println("Fill second forward info");
        fillForwardInfo(new Forward());
    }
    public void creteFile() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter path");
        path = s.nextLine();
        File file = new File(path);
        if(file.createNewFile()){
            System.out.println(path +" File Created");
        }else System.out.println("File "+ path +" already exists");
    }
    public  void fillGoalKeeperInfo(GoalKeeper footballer) throws IOException {
        GoalkeeperService goalkeeperService =new GoalkeeperService();
        Scanner s = new Scanner(System.in);
        Files.write(Paths.get(path),"GK ".getBytes(), StandardOpenOption.APPEND);
        System.out.println("Enter footballer firstname");
        footballer.setFirstName(s.nextLine());
        System.out.println("Enter footballer lastname");
        footballer.setLastName(s.nextLine());
        System.out.println("Did footballer appear in the game?true/false");
        footballer.setAppeared(s.nextBoolean());
        footballer.setFantasyScore(goalkeeperService.appearanceScore(footballer.isAppeared()));
        if (footballer.isAppeared()) {
            System.out.println("Did footballer play 60+ minutes?true/false");
            footballer.setMinutesPlayed60Plus(s.nextBoolean());
            footballer.setFantasyScore(goalkeeperService.minutesPlayed60PlusScore(footballer.isMinutesPlayed60Plus()));
            System.out.println("How many goals scored?");
            footballer.setGoals(s.nextInt());
            footballer.setFantasyScore(goalkeeperService.goalsScore(footballer.getGoals()));
            System.out.println("How many assists footballer have?");
            footballer.setAssists(s.nextInt());
            footballer.setFantasyScore(goalkeeperService.assistScore(footballer.getAssists()));
            System.out.println("How many penalty earned?");
            footballer.setPenaltiesEarned(s.nextInt());
            footballer.setFantasyScore(goalkeeperService.penaltiesEarnedScore(footballer.getPenaltiesEarned()));
            System.out.println("Have any yellow or red card?");
            System.out.println("1.None of this");
            System.out.println("2.Only ony yellow card");
            System.out.println("3.Only red card without yellow");
            System.out.println("4.Two yellow card(red card)");
            switch (s.nextInt()){
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
            footballer.setFantasyScore(goalkeeperService.redCardScore(footballer.hasRedCard()));
            footballer.setFantasyScore(goalkeeperService.yellowCardScore(footballer.hasYellowCard()));
            System.out.println("How many penalties conceded?");
            footballer.setPenaltiesConceded(s.nextInt());
            footballer.setFantasyScore(goalkeeperService.penaltiesConcededScore(footballer.getPenaltiesConceded()));
            System.out.println("How many own goal scored?");
            footballer.setOwnGoal(s.nextInt());
            System.out.println("How many penalty kick saves?");
            footballer.setPenaltyKickSaves(s.nextInt());
            System.out.println("How many saves did?");
            footballer.setSaves(s.nextInt());
            System.out.println("How many goals conceded?");
            footballer.setConcededGoals(s.nextInt());
            if(footballer.getConcededGoals()>0){
                footballer.setCleanSheet(false);
            }
        }
        Files.write(Paths.get(path),(footballer.getFirstName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getLastName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isAppeared()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isMinutesPlayed60Plus()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getGoals()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getAssists()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesEarned()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasYellowCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasRedCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesConceded()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getOwnGoal()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isCleanSheet()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltyKickSaves()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getSaves()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getConcededGoals()+"").getBytes(), StandardOpenOption.APPEND);
    }

    private void fillDefenderInfo(Defender footballer) throws IOException {


        Scanner s = new Scanner(System.in);
        Files.write(Paths.get(path),"\nDF ".getBytes(), StandardOpenOption.APPEND);
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
            System.out.println("1.None of this");
            System.out.println("2.Only ony yellow card");
            System.out.println("3.Only red card without yellow");
            System.out.println("4.Two yellow card(red card)");
            switch (s.nextInt()){
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
            System.out.println("Clean sheet?");
            footballer.setCleanSheet(s.nextBoolean());
        }
        Files.write(Paths.get(path),(footballer.getFirstName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getLastName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isAppeared()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isMinutesPlayed60Plus()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getGoals()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getAssists()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesEarned()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasYellowCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasRedCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesConceded()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getOwnGoal()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isCleanSheet()+"").getBytes(), StandardOpenOption.APPEND);
    }

    private void fillMidfielderInfo(Midfielder footballer) throws IOException {


        Scanner s = new Scanner(System.in);
        Files.write(Paths.get(path),"\nMF ".getBytes(), StandardOpenOption.APPEND);
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
            System.out.println("1.None of this");
            System.out.println("2.Only ony yellow card");
            System.out.println("3.Only red card without yellow");
            System.out.println("4.Two yellow card(red card)");
            switch (s.nextInt()){
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
        }
        Files.write(Paths.get(path),(footballer.getFirstName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getLastName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isAppeared()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isMinutesPlayed60Plus()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getGoals()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getAssists()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesEarned()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasYellowCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasRedCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesConceded()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getOwnGoal()+"").getBytes(), StandardOpenOption.APPEND);
    }

    private void fillForwardInfo(Forward footballer) throws IOException {


        Scanner s = new Scanner(System.in);
        Files.write(Paths.get(path),"\nFW ".getBytes(), StandardOpenOption.APPEND);
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
            System.out.println("1.None of this");
            System.out.println("2.Only ony yellow card");
            System.out.println("3.Only red card without yellow");
            System.out.println("4.Two yellow card(red card)");
            switch (s.nextInt()){
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
        }
        Files.write(Paths.get(path),(footballer.getFirstName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getLastName()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isAppeared()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.isMinutesPlayed60Plus()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getGoals()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getAssists()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesEarned()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasYellowCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.hasRedCard()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getPenaltiesConceded()+" ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path),(footballer.getOwnGoal()+"").getBytes(), StandardOpenOption.APPEND);
    }
}
