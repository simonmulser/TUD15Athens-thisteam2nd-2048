package com.thisteam2nd.game2048;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class GameBoardBuilderTest {

    @Test
    public void testCreate(){
        Rectangle[][] rectangles = GameBoardBuilder.create();
        assertThat(rectangles[0][0].getX(), is(10));
        assertThat(rectangles[0][0].getY(), is(10));

        assertThat(rectangles[0][1].getX(), is(10));
        assertThat(rectangles[0][1].getY(), is(170));

        assertThat(rectangles[1][0].getX(), is(170));
        assertThat(rectangles[1][0].getY(), is(10));

        assertThat(rectangles[3][3].getX(), is(490));
        assertThat(rectangles[3][3].getY(), is(490));
    }
}
