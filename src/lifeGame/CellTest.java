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
		//����ϸ������Ϊ������Χ����ϸ������Ϊ0ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(0);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ0ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(0);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ1ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(1);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ1ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(1);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ4ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(4);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ4ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(4);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ5ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(5);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ5ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(5);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ6ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(6);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ6ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(6);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ7ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(7);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ7ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(7);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ8ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(8);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ8ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(8);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ3ʱ����һ����ϸ����״̬������תΪ��
		cell.setLiving(3);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ3ʱ����һ����ϸ����״̬��Ϊ��
		cell.setLiving(3);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ2ʱ����һ����ϸ����״̬������״̬������Ϊ��
		cell.setLiving(2);
		cell.setStatus(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());
		//����ϸ������Ϊ������Χ����ϸ������Ϊ2ʱ����һ����ϸ����״̬������״̬������δ��
		cell.setLiving(2);
		cell.setStatus(1);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());
		}

}


