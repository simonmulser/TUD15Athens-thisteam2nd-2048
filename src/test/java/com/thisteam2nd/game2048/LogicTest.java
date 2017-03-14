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
}
