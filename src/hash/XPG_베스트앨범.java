package hash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


/**
 * 요구조건
 * - 가장 많이 재생된 노래를 두 개씩 모아
 * - 장르 먼저 수록, 많이 재생, 고유번호가 낮은 순
 * <p>
 * 필요한것
 * - 재생횟수를 기준으로 장르를 내림차순 정렬
 * - 각 장르별로 2곡씩 선정하기
 * <p>
 * HashMap
 * - 장르: (고유번호, 재생횟수)  | for 장르 내 가장많이 재생, 고유 번호 낮은 순
 * - 장르: 재생횟수 |for 총 재생횟수
 */
public class XPG_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 : (고유번호, 재생횟수)
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        // 장르: 총 재생횟수
        HashMap<String, Integer> playMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        // 총 재생횟수 많은 장르부터 내림차순
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream().sorted((o1, o2) -> Integer.compare(o2[1], o1[1])).limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 1. HashMap<ArrayList int[]>접근법 자체가 어려웠다.
 * 2. Stream 을 사용해서 정렬하고, 뽑는게 아직 익숙치 않다.
 * 3. 고유번호가 낮은 순 정렬도 stream 에서 익숙치 않음.
 */