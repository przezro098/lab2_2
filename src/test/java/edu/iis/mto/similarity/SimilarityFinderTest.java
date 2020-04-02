package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.search.SequenceSearcherExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityFinderTest {

    private SequenceSearcher sequenceSearcher = new SequenceSearcherExample();
    private SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
    private int[] firstSequence;
    private int[] secondSequence;
    private double result;

    @Test
    void CheckingBothEmptySequence() {
        firstSequence = new int[]{};
        secondSequence = new int[]{};

        result = similarityFinder.calculateJackardSimilarity(firstSequence,secondSequence);

        Assertions.assertEquals(1.0, result);
    }

    @Test
    void CheckingBothSingleSameElemenetSequence() {
        firstSequence = new int[]{1};
        secondSequence = new int[]{1};

        result = similarityFinder.calculateJackardSimilarity(firstSequence,secondSequence);

        Assertions.assertEquals(1.0, result);
    }



}
