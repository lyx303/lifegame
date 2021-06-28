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
		//�����е�ϸ����״̬��Ϊ1
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j]=new Cell();
				cell[i][j].setStatus(1);
			}
		}
		//��ȡÿ��ϸ������Χ��ϸ����Ŀ
		map.getLiving(cell);
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				//������Ǳ�Ե��ϸ�������ϸ����Χ��ϸ����ĿΪ8
				if(i>0&&i<29&&j>0&&j<29) assertEquals(8,cell[i][j].getLiving());
				//����Ǳ�Եϸ�����ǲ����ĸ����ǵ�ϸ�������ϸ����Χ��ϸ����ĿΪ5
				else if((i==0||i==29)&&(j>0&&j<29)||(j==0||j==29)&&(i>0&&i<29)) assertEquals(5,cell[i][j].getLiving());
				//������ĸ������ϸ�������ϸ����Χ��ϸ����ĿΪ3
				else assertEquals(3,cell[i][j].getLiving());
			}
		}
		//������ϸ��״̬��Ϊ0
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				//��ÿ��ϸ����Χ�Ļ�ϸ����ĿΪ0
				assertEquals(0,cell[i][j].getLiving());
			}
		}

	}

	@Test
	//------������ϸ����״̬��Ϊ1ʱ------
	public void testUpdate() {
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				//��ÿ��ϸ����״̬��Ϊ1
				cell[i][j].setStatus(1);
			}
		}
		map.getLiving(cell);
		//����������Ϸ�Ĺ��򣬴�ʱֻ���ĸ������ϸ����Χ�Ļ�ϸ����Ϊ3�����Դ�״̬����Ϊ1�������䣬����ϸ��������Ϊ��Χ���ϸ��̫�����ȥ��״̬�ı�Ϊ0
		assertEquals(4,map.update(cell));
		//��һ��ÿ��ϸ����״̬
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)
			{
				if(i==0&&(j==0||j==29)||(i==29&&(j==0||j==29)))
				{
					//�ĸ��ǵ�ϸ��״̬Ϊ1
					assertEquals(1,cell[i][j].getStatus());
				}
			        //����ϸ��״̬Ϊ0	
				else assertEquals(0,cell[i][j].getStatus());
			}
		}
		
		//-------������ϸ����״̬��Ϊ0ʱ-------
		//�����е�ϸ��״̬��0
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		//��ʱ���е�ϸ����ȻΪ����״̬��������ϸ��״̬��δ�����ı�
		assertEquals(900,map.update(cell));
		//��һ��ÿ��ϸ����״̬
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)
			{
						
				 assertEquals(0,cell[i][j].getStatus());
			}
		}
		
		
		//------���ĸ��ǵ�ϸ��״̬Ϊ0������ϸ����״̬Ϊ1ʱ--------
		//�����е�ϸ��״̬��1
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				cell[i][j].setStatus(1);
			}
		}
		//�ĸ�����0
		cell[0][29].setStatus(0);
		cell[0][0].setStatus(0);
		cell[29][29].setStatus(0);
		cell[29][0].setStatus(0);
		
		
		map.getLiving(cell);
		//��ʱ�ĸ��ǵ�ϸ��ʹ��ģ����������ģ��������е�ϸ��״̬�����ı�
		assertEquals(0,map.update(cell));
		//��һ��ÿ��ϸ����״̬
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
		
		
		
		 //------�������ϸ��״̬Ϊ0���ڲ�ϸ��״̬��Ϊ1ʱ
		//��������Ȧ��ϸ��״̬��1����Ȧ��0
				for(int i=0;i<30;i++) {
					for(int j=0;j<30;j++) {
						if(i==0||i==29||j==0||j==29)
							cell[i][j].setStatus(0);
						else cell[i][j].setStatus(1);
					}
				}
				//����ϸ��״̬
				map.getLiving(cell);
				//�ĸ�����Χ�Ļ�ϸ����ĿΪ1,��״̬���ı���δ��
				//�����ĸ��ǵİ˸���Եϸ����Χ�Ļ�ϸ����ĿΪ2����״̬������δ��
				//�ڲ��ĸ��Ǵ���ϸ����Χ�Ļ�ϸ����ĿΪ3����״̬������Ϊ��
				assertEquals(16,map.update(cell));
				//�м�ϸ����״̬
				for(int i=1;i<29;i++) {
					for(int j=1;j<29;j++) {
						if((i==1&&(j==1||j==28))||(i==28&&(j==1||j==28)))
						assertEquals(1,cell[i][j].getStatus());
						else assertEquals(0,cell[i][j].getStatus());
							
				}
				}
				//�������е�ϸ��״̬
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
				//�������е�ϸ��״̬
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
