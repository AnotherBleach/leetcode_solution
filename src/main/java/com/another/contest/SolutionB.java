package com.another.contest;

import java.util.*;

public class SolutionB {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        Set<Integer> persons = new HashSet<>();

        for (int i = 0; i < matches.length; i++) {

            persons.add(matches[i][0]);
            persons.add(matches[i][1]);
            if (data.containsKey(matches[i][1])) {
                List<Integer> nb = data.get(matches[i][1]);
                nb.add(matches[i][0]);
            } else {
                List<Integer> nb = new ArrayList<>();
                nb.add(matches[i][0]);
                data.put(matches[i][1], nb);
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> zeroList = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();


        for (Integer p : persons) {
            if (!data.containsKey(p)) {
                zeroList.add(p);
            }
        }

        data.forEach((me, whoNBThanMe) -> {


            if (whoNBThanMe.size() == 1) {
                oneList.add(me);
            }


        });

        Collections.sort(zeroList);
        Collections.sort(oneList);
        result.add(zeroList);
        result.add(oneList);

        return result;
    }
}
