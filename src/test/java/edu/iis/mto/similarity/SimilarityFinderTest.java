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

    @Test void CheckingBothEmptySequence() {
        firstSequence = new int[] {};
        secondSequence = new int[] {};

        result = similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assertions.assertEquals(1.0, result);
    }

    @Test void CheckingBothSingleSameElemenetSequence() {
        firstSequence = new int[] {1};
        secondSequence = new int[] {1};

        result = similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assertions.assertEquals(1.0, result);
    }

    @Test void CheckingSingleDifferentElementSequence() {
        firstSequence = new int[] {1};
        secondSequence = new int[] {2};

        result = similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assertions.assertEquals(0.0, result);
    }

    @Test void CheckingNullSequences() {
        firstSequence = null;
        secondSequence = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence));
    }

    @Test void CheckingHalfSimilarSequence() {
        firstSequence = new int[] {1, 2, 3};
        secondSequence = new int[] {2, 3, 4};

        result = similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assertions.assertEquals(0.5, result);
    }

    @Test void CheckingSingleNullSequences() {
        firstSequence = new int[] {1, 2, 3};
        ;
        secondSequence = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence));
    }

    @Test void CheckingCountOfCallSearchMethod() {
        firstSequence = new int[] {1, 2, 3};
        secondSequence = new int[] {2, 3, 4};

        result = similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assertions.assertTrue(similarityFinder.searcherCallCount == 3);
    }

}
