package lifeGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private static Cell cell=new Cell();

	/*@Before
	public void setUp() throws Exception {
	}*/

	@Test
	public void testUpdateStatus() {
		//当该细胞自身为死，周围存活的细胞个数为0时，下一代该细胞的状态：为死
		cell.setLiving(0);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为0时，下一代该细胞的状态：为死
		cell.setLiving(0);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为1时，下一代该细胞的状态：为死
		cell.setLiving(1);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为1时，下一代该细胞的状态：为死
		cell.setLiving(1);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为4时，下一代该细胞的状态：为死
		cell.setLiving(4);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为4时，下一代该细胞的状态：为死
		cell.setLiving(4);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为5时，下一代该细胞的状态：为死
		cell.setLiving(5);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为5时，下一代该细胞的状态：为死
		cell.setLiving(5);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为6时，下一代该细胞的状态：为死
		cell.setLiving(6);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为6时，下一代该细胞的状态：为死
		cell.setLiving(6);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为7时，下一代该细胞的状态：为死
		cell.setLiving(7);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为7时，下一代该细胞的状态：为死
		cell.setLiving(7);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为8时，下一代该细胞的状态：为死
		cell.setLiving(8);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为8时，下一代该细胞的状态：为死
		cell.setLiving(8);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为3时，下一代该细胞的状态：由死转为生
		cell.setLiving(3);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为3时，下一代该细胞的状态：为生
		cell.setLiving(3);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
		//当该细胞自身为死，周围存活的细胞个数为2时，下一代该细胞的状态：生死状态不变仍为死
		cell.setLiving(2);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//当该细胞自身为生，周围存活的细胞个数为2时，下一代该细胞的状态：生死状态不变仍未生
		cell.setLiving(2);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
		}

}


