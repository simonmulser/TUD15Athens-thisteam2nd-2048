package com.thisteam2nd.game2048;

import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class LogicTest {

    @Test
    public void testMoveLine1(){
        Integer[] line = new Integer[]{2,2,0,2};

        line = Logic.moveLine(line);

        assertThat(line, is(new Integer[]{2,2,2,0}));
    }

    @Test
    public void testMoveLine2(){
        Integer[] line = new Integer[]{0,0,0,512};

        line = Logic.moveLine(line);

        assertThat(line, is(new Integer[]{512,0,0,0}));
    }

    @Test
    public void testMoveLine3(){
        Integer[] line = new Integer[]{0,4,4,0};

        line = Logic.moveLine(line);

        assertThat(line, is(new Integer[]{4,4,0,0}));
    }

    @Test
    public void testMoveLine4(){
        Integer[] line = new Integer[]{0,0,2,2};

        line = Logic.moveLine(line);

        assertThat(line, is(new Integer[]{2,2,0,0}));
    }

    @Test
    public void testMoveLine5(){
        Integer[] line = new Integer[]{8,8,2,2};

        line = Logic.moveLine(line);

        assertThat(line, is(new Integer[]{8,8,2,2}));
    }

    @Test
    public void testMergeLine1(){
        Integer[] line = new Integer[]{2,2,0,0};

        line = Logic.mergeLine(line);

        assertThat(line, is(new Integer[]{4,0,0,0}));
    }

    @Test
    public void testMergeLine2(){
        Integer[] line = new Integer[]{512,512,2,0};

        line = Logic.mergeLine(line);

        assertThat(line, is(new Integer[]{1024,2,0,0}));
    }

    @Test
    public void testMergeLine3(){
        Integer[] line = new Integer[]{4,4,4,4};

        line = Logic.mergeLine(line);

        assertThat(line, is(new Integer[]{8,8,0,0}));
    }

    @Test
    public void testMergeLine4(){
        Integer[] line = new Integer[]{4,2,2,4};

        line = Logic.mergeLine(line);

        assertThat(line, is(new Integer[]{4,4,4,0}));
    }

    @Test
    public void testIsGameOver1(){
        Integer[][] board = new Integer[][]{{2,4,8,16},
                                            {4,8,16,32},
                                            {2,4,8,16},
                                            {4,8,16,32}};

        assertThat(Logic.isGameOver(board), is(true));
    }

    @Test
    public void testIsGameOver2(){
        Integer[][] board = new Integer[][]{{2,4,8,16},
                                            {2,8,16,32},
                                            {2,4,8,16},
                                            {4,8,16,32}};

        assertThat(Logic.isGameOver(board), is(false));
    }

    @Test
    public void testIsGameOver3(){
        Integer[][] board = new Integer[][]{{0,0,2,0},
                                            {0,0,0,0},
                                            {0,0,2,0},
                                            {0,0,0,0}};

        assertThat(Logic.isGameOver(board), is(false));
    }
}
