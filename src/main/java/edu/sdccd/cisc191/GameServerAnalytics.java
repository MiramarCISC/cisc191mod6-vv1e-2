package edu.sdccd.cisc191;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameServerAnalytics {

    public static List<String> findTopNUsernamesByRating(Collection<PlayerAccount> players, int n) {
        Comparator<PlayerAccount> comparator = Comparator
            .comparingDouble(PlayerAccount::rating).reversed()
            .thenComparing(PlayerAccount::username); // Sorting by username makes result more consistent

        return players.stream()
            .sorted(comparator)
            .limit(n)
            .map(PlayerAccount::username)
            .toList();
    }

    public static Map<String, Double> averageRatingByRegion(Collection<PlayerAccount> players) {
        return players.stream()
            .collect(Collectors.groupingBy(
                PlayerAccount::region,
                Collectors.averagingDouble(PlayerAccount::rating)
            ));
    }

    public static Set<String> findDuplicateUsernames(Collection<PlayerAccount> players) {
        return players.stream()
            .collect(Collectors.groupingBy(
                PlayerAccount::username, Collectors.counting()) // Count individual instances of a username
            ).entrySet().stream() // Convert to set and stream
            .filter(e -> e.getValue() > 1) // Filter usernames that repeat more than once
            .map(Map.Entry::getKey) // Get the key
            .collect(Collectors.toSet());
    }

    public static Map<String, List<String>> groupUsernamesByTier(Collection<PlayerAccount> players) {
        return players.stream()
            .sorted(Comparator.comparing(PlayerAccount::username))
            .collect(Collectors.groupingBy(
                GameServerAnalytics::tierFor,
                Collectors.mapping(PlayerAccount::username, Collectors.toList())
            ));
    }

    public static Map<String, List<String>> buildRecentMatchSummariesByPlayer(Collection<MatchRecord> matches) {
        return matches.stream()
            .flatMap(match -> Stream.of( // Add two map entries into a single stream
                new AbstractMap.SimpleEntry<>(match.playerOne().username(), match.summary()),
                new AbstractMap.SimpleEntry<>(match.playerTwo().username(), match.summary())
            )).collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
            ));
    }

    public static <T> T pickHigherRated(T first, T second, Comparator<T> comparator) {
        return comparator.compare(first, second) >= 0 ? first : second;
    }

    public static String tierFor(PlayerAccount player) {
        if (player.rating() < 1000) return "Bronze";
        if (player.rating() < 1400) return "Silver";
        return "Gold";
    }
}
