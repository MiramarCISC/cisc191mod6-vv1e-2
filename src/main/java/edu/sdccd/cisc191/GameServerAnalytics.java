package edu.sdccd.cisc191;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameServerAnalytics {

    public static List<String> findTopNUsernamesByRating(Collection<PlayerAccount> players, int n) {
        // TODO: use a stream pipeline
        return List.of();
    }

    public static Map<String, Double> averageRatingByRegion(Collection<PlayerAccount> players) {
        // TODO: use groupingBy + averagingInt
        return Map.of();
    }

    public static Set<String> findDuplicateUsernames(Collection<PlayerAccount> players) {
        // TODO: use collections and/or streams
        return Set.of();
    }

    public static Map<String, List<String>> groupUsernamesByTier(Collection<PlayerAccount> players) {
        // TODO: use groupingBy and mapping
        return Map.of();
    }

    public static Map<String, List<String>> buildRecentMatchSummariesByPlayer(Collection<MatchRecord> matches) {
        // TODO: use a Map + collection logic or a stream-based approach
        return Map.of();
    }

    public static <T> T pickHigherRated(T first, T second, Comparator<T> comparator) {
        // TODO: implement using the comparator
        return null;
    }

    public static String tierFor(PlayerAccount player) {
        if (player.rating() < 1000) return "Bronze";
        if (player.rating() < 1400) return "Silver";
        return "Gold";
    }
}
