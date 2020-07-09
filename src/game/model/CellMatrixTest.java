package game.model;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Before;
import game.Util.Utils;


public class CellMatrixTest {

    CellMatrix cellMatrix = null;
    String path = "D:\\ѧϰ\\wx_devlop\\TXGameOfLife\\test.case";

    @Before
    public void init() {
        cellMatrix = Utils.initMatrixFromFile(path);
    }

    @Test
    public void transform() throws Exception {

        int[][] expected = new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 1, 1}
        };
        Assert.assertArrayEquals(expected, cellMatrix.getMatrix());
        cellMatrix.transform();
        expected = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 1}
        };
        Assert.assertArrayEquals(expected, cellMatrix.getMatrix());
        cellMatrix.transform();
        expected = new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        Assert.assertArrayEquals(expected, cellMatrix.getMatrix());
    }


    @Test
    public void findLifedNum() throws Exception {
        Assert.assertEquals(1, cellMatrix.findLifedNum(0, 0));
        Assert.assertEquals(3, cellMatrix.findLifedNum(0, 1));
        Assert.assertEquals(1, cellMatrix.findLifedNum(0, 2));
        Assert.assertEquals(4, cellMatrix.findLifedNum(1, 0));
        Assert.assertEquals(5, cellMatrix.findLifedNum(1, 1));
        Assert.assertEquals(4, cellMatrix.findLifedNum(1, 2));
        Assert.assertEquals(2, cellMatrix.findLifedNum(2, 0));
        Assert.assertEquals(3, cellMatrix.findLifedNum(2, 1));
        Assert.assertEquals(2, cellMatrix.findLifedNum(2, 2));
    }

}