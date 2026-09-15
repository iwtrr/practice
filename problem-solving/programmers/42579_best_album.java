// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<GenreStats> statsList = getStatsList(genres, plays);

        statsList.sort(
                Comparator.comparingInt((GenreStats stats) -> stats.totalPlays)
                        .reversed()
        );

        List<Integer> answer = new ArrayList<>();

        for (GenreStats stats : statsList) {
            stats.songs.sort(
                    Comparator.comparingInt(Song::plays)
                            .reversed()
                            .thenComparingInt(Song::index)
            );

            answer.add(stats.songs.get(0).index());
            if (stats.songs.size() > 1) {
                answer.add(stats.songs.get(1).index());
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<GenreStats> getStatsList(String[] genres, int[] plays) {
        Map<String, GenreStats> statsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            GenreStats genreStats = statsByGenre.computeIfAbsent(
                    genres[i],
                    GenreStats::new
            );

            genreStats.addSong(new Song(i, plays[i]));
        }

        return new ArrayList<>(statsByGenre.values());
    }

    private static class GenreStats {
        private final String genre;
        private final List<Song> songs = new ArrayList<>();
        private int totalPlays;

        private GenreStats(String genre) {
            this.genre = genre;
        }

        private void addSong(Song song) {
            songs.add(song);
            totalPlays += song.plays();
        }
    }

    private record Song(
            int index,
            int plays) {
    }
}