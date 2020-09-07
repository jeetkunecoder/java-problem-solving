package com.theory.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Functional interfaces are interfaces that only
 * have one abstract method and any number of default
 * implementations
 */

public class FunctionalInterfaces {

  public static List<Team> getQualifyingTeams(List<Team> teams, Qualifier qualifier) {
    List<Team> qualifiedTeams = new ArrayList<>();
    for (Team team : teams) {
      if (qualifier.isWorldCupQualifier(team)) {
        qualifiedTeams.add(team);
      }
    }
    return qualifiedTeams;
  }

  public static List<Team> nativeGetQualifyingTeams(List<Team> teams, Predicate<Team> qualifier) {
    List<Team> qualifiedTeams = new ArrayList<>();
    for (Team team: teams) {
      if (qualifier.test(team)) {
        qualifiedTeams.add(team);
      }
    }
    return qualifiedTeams;
  }

  public static void main(String[] args) {
    List<Team> teams = Arrays.asList(
      new Team("France", 2),
      new Team("Germany", 3),
      new Team("Tunisia", 60)
    );

    // Here, we implement the only abstract method
    // in the Qualifier interface using an anonymous class
    List<Team> qualifiedTeams = getQualifyingTeams(teams,
      new Qualifier() {
        public boolean isWorldCupQualifier(Team team) {
          return team.getWorldRank() < 10;
        }
      });

    // In this second case, we are using a Predicate interface
    // from the java.util.function package
    List<Team> qualifiedTeamsWithPredicate = nativeGetQualifyingTeams(
        teams,
        (Team team) -> team.getWorldRank() < 10
    );

    for (Team t : qualifiedTeamsWithPredicate) {
      System.out.println(t);
    }
  }
}

class Team {
  private String name;
  private Integer worldRank;

  public Team(String name, Integer worldRank) {
    this.name = name;
    this.worldRank = worldRank;
  }

  public String getName() { return name; }
  public Integer getWorldRank() { return worldRank; }
}

interface Qualifier {
  boolean isWorldCupQualifier(Team team);
}

@FunctionalInterface
interface FunctionalQualifier {
  boolean isWorldCupQualifier(Team team);
}
