package lifeGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
	private static Map map=new Map();
	private static Cell [][]cell=new Cell[31][31];
	private static Cell [][]pcell=new Cell[31][31];

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetLiving() {
		//将所有的细胞的状态置为1
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j]=new Cell();
				cell[i][j].setStatus(1);
			}
		}
		//获取每个细胞的周围活细胞数目
		map.getLiving(cell);
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				//如果不是边缘的细胞，则该细胞周围活细胞数目为8
				if(i>0&&i<29&&j>0&&j<29) assertEquals(8,cell[i][j].getLiving());
				//如果是边缘细胞但是不是四个顶角的细胞，则该细胞周围活细胞数目为5
				else if((i==0||i==29)&&(j>0&&j<29)||(j==0||j==29)&&(i>0&&i<29)) assertEquals(5,cell[i][j].getLiving());
				//如果是四个顶点的细胞，则该细胞周围活细胞数目为3
				else assertEquals(3,cell[i][j].getLiving());
			}
		}
		//将所有细胞状态置为0
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				//则每个细胞周围的活细胞数目为0
				assertEquals(0,cell[i][j].getLiving());
			}
		}

	}

	@Test
	//------当所有细胞的状态均为1时------
	public void testUpdate() {
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				//将每个细胞的状态置为1
				cell[i][j].setStatus(1);
			}
		}
		map.getLiving(cell);
		//按照生命游戏的规则，此时只有四个顶点的细胞周围的活细胞数为3，可以存活，状态保持为1，即不变，其余细胞都会因为周围存活细胞太多而死去，状态改变为0
		assertEquals(4,map.update(cell));
		//看一下每个细胞的状态
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)
			{
				if(i==0&&(j==0||j==29)||(i==29&&(j==0||j==29)))
				{
					//四个角的细胞状态为1
					assertEquals(1,cell[i][j].getStatus());
				}
			        //其余细胞状态为0	
				else assertEquals(0,cell[i][j].getStatus());
			}
		}
		
		//-------当所有细胞的状态均为0时-------
		//将所有的细胞状态置0
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		//此时所有的细胞仍然为死亡状态，即所有细胞状态均未发生改变
		assertEquals(900,map.update(cell));
		//看一下每个细胞的状态
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)
			{
						
				 assertEquals(0,cell[i][j].getStatus());
			}
		}
		
		
		//------当四个角的细胞状态为0，其余细胞的状态为1时--------
		//将所有的细胞状态置1
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j].setStatus(1);
			}
		}
		//四个角置0
		cell[0][29].setStatus(0);
		cell[0][0].setStatus(0);
		cell[29][29].setStatus(0);
		cell[29][0].setStatus(0);
		
		
		map.getLiving(cell);
		//此时四个角的细胞使活的，其他是死的，并且所有的细胞状态发生改变
		assertEquals(0,map.update(cell));
		//看一下每个细胞的状态
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)
			{
				if(i==0&&(j==0||j==29)||(i==29&&(j==0||j==29)))
				{
					assertEquals(1,cell[i][j].getStatus());
				}
				else assertEquals(0,cell[i][j].getStatus());
			}
		}
		
		
		
		 //------当最外侧细胞状态为0，内侧细胞状态均为1时
		//将所有内圈的细胞状态置1，外圈置0
				for(int i=0;i<30;i++) {
					for(int j=0;j<30;j++) {
						if(i==0||i==29||j==0||j==29)
							cell[i][j].setStatus(0);
						else cell[i][j].setStatus(1);
					}
				}
				//更新细胞状态
				map.getLiving(cell);
				//四个角周围的活细胞数目为1,其状态不改变仍未死
				//靠近四个角的八个边缘细胞周围的活细胞数目为2，其状态不变仍未死
				//内侧四个角处的细胞周围的活细胞数目为3，其状态不变仍为生
				assertEquals(16,map.update(cell));
				//中间细胞的状态
				for(int i=1;i<29;i++) {
					for(int j=1;j<29;j++) {
						if((i==1&&(j==1||j==28))||(i==28&&(j==1||j==28)))
						assertEquals(1,cell[i][j].getStatus());
						else assertEquals(0,cell[i][j].getStatus());
							
				}
				}
				//上下两行的细胞状态
				for(int i=0;i<30;i+=29)
				{
					for(int j=0;j<30;j++)
					{
						if(j==0||j==1||j==28||j==29)
							assertEquals(0,cell[i][j].getStatus());
						else 
							assertEquals(1,cell[i][j].getStatus());
							
					}
				}
				//左右两行的细胞状态
				for(int j=0;j<30;j+=29)
				{
					for(int i=1;i<29;i++)
					{
						if(i==1||i==28)
							assertEquals(0,cell[i][j].getStatus());
						else 
							assertEquals(1,cell[i][j].getStatus());
							
					}
				}
	}
}
