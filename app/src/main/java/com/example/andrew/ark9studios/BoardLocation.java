package com.example.andrew.ark9studios;

import android.graphics.Rect;

/**
 * Created by Andrew and Karl on 21/04/2017.
 *
 * Objects of this class will be created holding details of each location on the playing board.
 */

public class BoardLocation {

    //variables to aid process of changing locations.
    public static final int CARD_WIDTH = 110;
    public static final int CARD_HEIGHT = 150;
    public static final int ZOOMCARD_WIDTH = 330;
    public static final int ZOOMCARD_HEIGHT= 450;
    private static final int ZOOMCARD_PADDING= 250;
    private static final int HAND_PADDING = 75;
    private static final int BENCH_PADDING = 425;

    //hand locations
    private static final int hand1 = 105;
    private static final int hand2 = 280;
    private static final int hand3 = 455;
    private static final int hand4 = 630;
    private static final int hand5 = 805;
    private static final int hand6 = 980;

    private static final int zoomCard= 10;

    private static final int bench1 = 367;
    private static final int bench2 = 542;
    private static final int bench3 = 717;

    private final int SCREEN_HEIGHT = 1920;
    private final int SCREEN_WIDTH = 1200;

    private int p1HandTop = SCREEN_HEIGHT - (CARD_HEIGHT * 2) - HAND_PADDING;
    private int p1HandBottom = SCREEN_HEIGHT - HAND_PADDING - CARD_HEIGHT;
    private int p2HandTop = HAND_PADDING;
    private int p2HandBottom = CARD_HEIGHT + HAND_PADDING;

    private int p1BenchTop = SCREEN_HEIGHT - (CARD_HEIGHT * 2) - BENCH_PADDING;
    private int p1BenchBottom = SCREEN_HEIGHT - CARD_HEIGHT - BENCH_PADDING;
    private int p2BenchTop = BENCH_PADDING;
    private int p2BenchBottom = BENCH_PADDING + CARD_HEIGHT;

    private int zoomCardTop= ZOOMCARD_PADDING;
    private int zoomCardBottom=ZOOMCARD_PADDING+ZOOMCARD_HEIGHT;

    /////////////////////////////////////////////////////////////////////////
    //Player 1 Hand Locations
    /////////////////////////////////////////////////////////////////////////


    private Rect p1Hand1Location = new Rect(hand1, p1HandTop
            , hand1 + CARD_WIDTH, p1HandBottom);

    private Rect p1Hand2Location = new Rect(hand2, p1HandTop
            , hand2 + CARD_WIDTH, p1HandBottom);

    private Rect p1Hand3Location = new Rect(hand3, p1HandTop
            , hand3 + CARD_WIDTH, p1HandBottom);

    private Rect p1Hand4Location = new Rect(hand4, p1HandTop
            , hand4 + CARD_WIDTH, p1HandBottom);

    private Rect p1Hand5Location = new Rect(hand5, p1HandTop
            , hand5 + CARD_WIDTH, p1HandBottom);

    private Rect p1Hand6Location = new Rect(hand6, p1HandTop
            , hand6 + CARD_WIDTH, p1HandBottom);


    /////////////////////////////////////////////////////////////////////////
    //Player 2 Hand Locations
    /////////////////////////////////////////////////////////////////////////

    private Rect p2Hand1Location = new Rect(hand1, p2HandTop
            , hand1 + CARD_WIDTH, p2HandBottom);

    private Rect p2Hand2Location = new Rect(hand2, p2HandTop
            , hand2 + CARD_WIDTH, p2HandBottom);

    private Rect p2Hand3Location = new Rect(hand3, p2HandTop
            , hand3 + CARD_WIDTH, p2HandBottom);

    private Rect p2Hand4Location = new Rect(hand4, p2HandTop
            , hand4 + CARD_WIDTH, p2HandBottom);

    private Rect p2Hand5Location = new Rect(hand5, p2HandTop
            , hand5 + CARD_WIDTH, p2HandBottom);

    private Rect p2Hand6Location = new Rect(hand6, p2HandTop
            , hand6 + CARD_WIDTH, p2HandBottom);


    /////////////////////////////////////////////////////////////////////
    // Player 1 Bench Locations
    /////////////////////////////////////////////////////////////////////

    private Rect p1Bench1Location = new Rect(bench1, p1BenchTop, bench1 + CARD_WIDTH, p1BenchBottom);

    private Rect p1Bench2Location = new Rect(bench2, p1BenchTop, bench2 + CARD_WIDTH, p1BenchBottom);

    private Rect p1Bench3Location = new Rect(bench3, p1BenchTop, bench3 + CARD_WIDTH, p1BenchBottom);

    /////////////////////////////////////////////////////////////////////
    // Player 2 Bench Locations
    /////////////////////////////////////////////////////////////////////

    private Rect p2Bench1Location = new Rect(bench1, p2BenchTop, bench1 + CARD_WIDTH, p2BenchBottom);

    private Rect p2Bench2Location = new Rect(bench2, p2BenchTop, bench2 + CARD_WIDTH, p2BenchBottom);

    private Rect p2Bench3Location = new Rect(bench3, p2BenchTop, bench3 + CARD_WIDTH, p2BenchBottom);

    ///////////////////////////////////////////////////
    // Zoomed image of selected card location
    ///////////////////////////////////////

    private Rect zoomCardLocation= new Rect(zoomCard, zoomCardTop, zoomCard + ZOOMCARD_WIDTH, zoomCardBottom);

    //getters

    public Rect getP1Hand1Location() {
        return p1Hand1Location;
    }

    public Rect getP1Hand2Location() {
        return p1Hand2Location;
    }

    public Rect getP1Hand3Location() {
        return p1Hand3Location;
    }

    public Rect getP1Hand4Location() {
        return p1Hand4Location;
    }

    public Rect getP1Hand5Location() {
        return p1Hand5Location;
    }

    public Rect getP1Hand6Location() {
        return p1Hand6Location;
    }


    public Rect getP2Hand1Location() {
        return p2Hand1Location;
    }

    public Rect getP2Hand2Location() {
        return p2Hand2Location;
    }

    public Rect getP2Hand3Location() {
        return p2Hand3Location;
    }

    public Rect getP2Hand4Location() {
        return p2Hand4Location;
    }

    public Rect getP2Hand5Location() {
        return p2Hand5Location;
    }

    public Rect getP2Hand6Location() {
        return p2Hand6Location;
    }

    public Rect getP1Bench1Location() {
        return p1Bench1Location;
    }

    public Rect getP1Bench2Location() {
        return p1Bench2Location;
    }

    public Rect getP1Bench3Location() {
        return p1Bench3Location;
    }

    public Rect getP2Bench1Location() {
        return p2Bench1Location;
    }

    public Rect getP2Bench2Location() {
        return p2Bench2Location;
    }

    public Rect getP2Bench3Location() {
        return p2Bench3Location;
    }

}
