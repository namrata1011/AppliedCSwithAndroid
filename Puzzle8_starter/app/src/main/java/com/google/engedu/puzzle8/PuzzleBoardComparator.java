package com.google.engedu.puzzle8;

/**
 * Created by welcome on 03-Jun-17.
 */

class PuzzleBoardComparator implements java.util.Comparator<PuzzleBoard> {
    @Override
    public int compare(PuzzleBoard x, PuzzleBoard y) {
        return x.priority() - y.priority();
    }
}
