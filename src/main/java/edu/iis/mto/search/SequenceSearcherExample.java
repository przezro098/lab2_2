package edu.iis.mto.search;

import java.util.HashMap;

public class SequenceSearcherExample implements SequenceSearcher {

    private HashMap<Integer, Integer> seqPositions = new HashMap<>();

    public void setPosition(int [] elem) {
        if (elem == null) return;
        else {
            for (int i = 0; i < elem.length; i++) {
                this.seqPositions.put(elem[i], i);
            }
        }
    }

    @Override
    public SearchResult search(int elem, int[] seq) {

        if (seq == null) {
            throw new NullPointerException();
        }

        SearchResult.Builder builder = SearchResult.builder();
        builder.withFound(false);

        if (this.seqPositions.containsKey(elem)) {
            builder.withFound(true);
            builder.withPosition(this.seqPositions.get(elem));
        }
        return builder.build();
    }
}
