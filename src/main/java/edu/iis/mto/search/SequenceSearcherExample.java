package edu.iis.mto.search;

public class SequenceSearcherExample implements SequenceSearcher {

    @Override public SearchResult search(int elem, int[] seq) {
        if (seq == null)
            throw new NullPointerException();

        SearchResult.Builder builder = SearchResult.builder();
        builder.withFound(false);
        builder.withPosition(-1);
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == elem) {
                builder.withFound(true);
                builder.withPosition(i);
                break;
            }

        }

        return builder.build();

    }
}
