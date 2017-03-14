package com.thisteam2nd.game2048;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class TransformationTest {

    @Test
    public void testTranspose1(){
        Integer[][] matrix = new Integer[][]{
                {2, 0, 0},
                {0, 2, 0},
                {0, 0, 4}
        };

        matrix = Transformation.transpose(matrix);

        assertThat(matrix, is(new Integer[][]{
                {2, 0, 0},
                {0, 2, 0},
                {0, 0, 4}
        }));

    }

    @Test
    public void testTranspose2(){
        Integer[][] matrix = new Integer[][]{
                {2, 0, 0},
                {1, 2, 3},
                {5, 2, 4}
        };

        matrix = Transformation.transpose(matrix);

        assertThat(matrix, is(new Integer[][]{
                {2, 1, 5},
                {0, 2, 2},
                {0, 3, 4}
        }));

    }

    @Test
    public void testTranspose3(){
        Integer[][] matrix = new Integer[][]{
                {2, 0, 0},
                {0, 2, 0},
                {0, 0, 4}
        };

        matrix = Transformation.transpose(matrix);

        assertThat(matrix, is(new Integer[][]{
                {2, 0, 0},
                {0, 2, 0},
                {0, 0, 4}
        }));

    }

}