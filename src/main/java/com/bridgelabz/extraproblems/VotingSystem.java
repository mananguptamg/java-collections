package com.bridgelabz.extraproblems;

import java.util.*;

class VoteManager {

    private Map<String, Integer> voteMap = new HashMap<>();                // Candidate -> Votes
    private LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>();  // Maintain voting order
    private TreeMap<String, Integer> sortedByCandidate = new TreeMap<>();   // Sorted by candidate name

    // Cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteMap.get(candidate));
        sortedByCandidate.put(candidate, voteMap.get(candidate));
    }

    // Display vote results in insertion order (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("\n--- Votes in Order of Casting ---");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.printf("%s -> %d votes\n", entry.getKey(), entry.getValue());
        }
    }

    // Display results sorted by candidate name (TreeMap)
    public void displayVotesByCandidate() {
        System.out.println("\n--- Results Sorted by Candidate Name ---");
        for (Map.Entry<String, Integer> entry : sortedByCandidate.entrySet()) {
            System.out.printf("%s -> %d votes\n", entry.getKey(), entry.getValue());
        }
    }

    // Display results sorted by vote count (using List sorting)
    public void displayVotesByCount() {
        System.out.println("\n--- Results Sorted by Vote Count ---");
        List<Map.Entry<String, Integer>> voteList = new ArrayList<>(voteMap.entrySet());

        voteList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : voteList) {
            System.out.printf("%s -> %d votes\n", entry.getKey(), entry.getValue());
        }
    }
}

public class VotingSystem {
    public static void main(String[] args) {

        VoteManager manager = new VoteManager();

        // Simulating voting process
        manager.castVote("Amit");
        manager.castVote("Arun");
        manager.castVote("Yash");
        manager.castVote("Rahul");
        manager.castVote("Mohit");
        manager.castVote("Abhinav");
        manager.castVote("Aman");
        manager.castVote("Raman");
        manager.castVote("Naman");

        // Displaying results
        manager.displayVotesInOrder();
        manager.displayVotesByCandidate();
        manager.displayVotesByCount();
    }
}