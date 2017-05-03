package com.javarush.task.task34.task3402;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Gia on 03.05.2017.
 */
@RunWith(Parameterized.class)
public class SolutionTest {
    Solution solution;
    int enterInt, result;

    @Before
    public void beforeTest() {
        solution = new Solution();
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {9, 362880},
                {0, 1},
                {1, 1}
        });
    }

    public SolutionTest(int enterInt, int result) {
        this.enterInt = enterInt;
        this.result = result;
    }
    @Test
    public void factorial() throws Exception {
        int x = solution.factorial(enterInt);
        assertEquals(result, x);
    }

}