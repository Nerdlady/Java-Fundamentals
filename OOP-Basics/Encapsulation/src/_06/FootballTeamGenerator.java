package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class FootballTeamGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandExecutor executor = new CommandExecutor();
        while (true){
            String line = reader.readLine();
            if(line.equals("END")){
                break;
            }

            String[] info = line.split(";");
            try {
                switch (info[0]){
                    case "Team":
                        executor.team(info[1]);
                        break;
                    case "Add":
                        String teamName = info[1];
                        String playerName = info[2];
                        int endurance = Integer.parseInt(info[3]);
                        int sprint= Integer.parseInt(info[4]);
                        int dribble= Integer.parseInt(info[5]);
                        int passing= Integer.parseInt(info[6]);
                        ;int shooting = Integer.parseInt(info[7]);
                        executor.add(teamName,playerName,endurance,sprint,dribble,passing,shooting);
                        break;
                    case "Remove":
                        executor.remove(info[1],info[2]);
                        break;
                    case "Rating":
                        executor.raiting(info[1]);
                        break;

                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
    }
}


class CommandExecutor{
    private LinkedHashMap<String,Team> teams;

    public CommandExecutor() {
        this.teams = new LinkedHashMap<>();
    }

    public void team(String teamName){
        teams.put(teamName,new Team(teamName));
    }

    public void add(String teamName,String playerName, int endurance, int sprint, int dribble, int passing, int shooting){
        if (!teams.containsKey(teamName)){
            throw new IllegalArgumentException(String.format("Team %s does not exist.",teamName));
        }

        Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
        teams.get(teamName).addPlayer(player);
    }

    public void remove(String teamName,String playerName){
        if (!teams.containsKey(teamName)){
            throw new IllegalArgumentException(String.format("Team %s does not exist.",teamName));
        }

        teams.get(teamName).removePlayer(new Player(playerName));
    }

    public void raiting(String teamName){
        if (!teams.containsKey(teamName)){
            throw new IllegalArgumentException(String.format("Team %s does not exist.",teamName));
        }
        System.out.printf("%s - %.0f%n",teamName,teams.get(teamName).stats());
    }
}

class Team {
    private String name;
    private LinkedHashMap<String,Player> players;

    public Team(String name) {
        setName(name);
        this.players = new LinkedHashMap<>();
    }

    public void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.put(player.getName(),player);
    }

    public void removePlayer(Player player) {
        if (!players.containsKey(player.getName())) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player.getName(), this.name));
        }

        players.remove(player.getName());
    }

    public double stats(){
        double sum = 0.0;
        for (Player player : players.values()) {
            sum += player.avarege();
        }

        return Math.round(sum/ this.players.size());
    }
}

class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double avarege() {
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint) / 5d;
    }
}
