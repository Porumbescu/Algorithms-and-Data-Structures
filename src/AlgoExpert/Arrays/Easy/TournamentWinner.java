package AlgoExpert.Arrays.Easy;

import java.util.*;

// Tournament Winner
// Difficulty: Easy     Category: Arrays

// There's an algorithms' tournament taking place in which teams of programmers
// compete against each other to solve algorithmic problems as fast as possible.
// Teams compete in a round-robin, where each team faces off against all other
// teams. Only two teams compete against each other at a time, and for each
// competition, one team is designated the home team, while the other team is the
// away team. In each competition there's always one winner and one loser; there
// are no ties. A team receives 3 points if it wins and 0 points if it loses. The
// winner of the tournament is the team that receives the most amount of points.

// Given an array of pairs representing the teams that have competed against each
// other and an array containing the results of each competition, write a
// function that returns the winner of the tournament. The input arrays are named
// competitions and results.

public class TournamentWinner {

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> map = new HashMap<>();
        String bestCompetitor = "";
        int maxScore = 0;

        for(int i = 0; i < competitions.size(); i++) {
            String winningCompetitor = "";
            if(results.get(i) == 0) {
                winningCompetitor = competitions.get(i).get(1);
            } else {
                winningCompetitor = competitions.get(i).get(0);
            }

            int oldScore = map.getOrDefault(winningCompetitor, 0);
            int newScore = oldScore + 3;

            if(newScore > maxScore) {
                maxScore = newScore;
                bestCompetitor = winningCompetitor;
            }

            map.put(winningCompetitor, newScore);
        }

        return bestCompetitor;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList("HTML", "Java")),
                        new ArrayList<>(Arrays.asList("Java", "Python")),
                        new ArrayList<>(Arrays.asList("Python", "HTML"))
                )
        );

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 1, 1));

        String winner = tournamentWinner(competitions, results);
        System.out.println("The tournament winner is: " + winner);
    }
}
