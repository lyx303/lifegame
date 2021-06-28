package lifeGame;
//用于实现整个控制完整游戏逻辑， 根据地图数据依照逻 辑进行相应更新
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

public class Controll {
    Controll() {
    	JFrame jframe=new JFrame();
    	//设置窗体大小
    	jframe.setSize(800,850);
    	JPanel jpanel=new JPanel();
    	jpanel.setForeground(Color.WHITE);
    	//设置背景颜色
    	//jpanel.setBackground(Color.WHITE);
    	//x y weight height
    	jpanel.setBounds(0,0,400,400);
    	int count=0;
    	//初始化为30个格子
    	Cell [][]cell=new Cell[30][30];
    	
    	//使用Map类里面的initial函数初始化地图
    	cell=Map.initial();
    	
    	
    	//调用Map类里面的getLiving()函数获取每个细胞的周围活细胞数并记录
    	Map.getLiving(cell);
    	// 设置jframe的标题
    	jframe.setTitle("第"+count+"次演化");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.getContentPane().add(jpanel);
    	jframe.setVisible(true);
    	Graphics g=jpanel.getGraphics();
    	//创建Graphics对象g用于画图
    	//设置绘制的颜色
    	g.setColor(Color.blue);
    	//如果该细胞是活的，就绘制蓝色的实心方块，如果细胞是死的就绘制矩形框
    	for(int i=0;i<30;i++) {
    		for(int j=0;j<30;j++) {
    			if(cell[i][j].getStatus()==1) {
    				g.fillRect(i*25, j*25, 25, 25);
    			}
    			else {
    				g.drawRect(i*25, j*25, 25, 25);
    			}
    		}
    	}
    	long d1= System.currentTimeMillis();
    	while(true) {
    		long d2= System.currentTimeMillis();
    		//设置更新时间为1s
    		if(d2-d1>1000) {
    			int change;
    			d1=d2;
    			//jframe.repaint();
    			// 调用Map的update()函数更新细胞状态
    			//pcell=cell;
    			/*for(int i=0;i<30;i++)
    	    	{
    	    		for(int j=0;j<30;j++)
    	    		{
    	    			pcell[i][j]=cell[i][j];
    	    			System.out.print(pcell[i][j].getStatus());
    	    		}
    	    		System.out.println();
    	    	    	    	
    	    	}*/
    			
    			
    			change=Map.update(cell);
    			Map.getLiving(cell);
    			/*for(int i=0;i<30;i++) {
    				for(int j=0;j<30;j++)
    				{
    					g.drawRect(i*25,j*25,25,25);
    				}
    			}*/
    			
    		/*	for(int i=0;i<30;i++) {
    				for(int j=0;j<30;j++) {
    					
    					{
    						if(cell[i][j].getStatus()==1) {
        	    				g.fillRect(i*25, j*25, 25, 25);
        	    			}
        	    			else {
        	    			    g.clearRect(i*25, j*25, 25,25);
        	    				g.drawRect(i*25, j*25, 25, 25);
        				    }
    					}
    					
    				}
    			}
    			*/
    			for(int i=0;i<30;i++) {
    				for(int j=0;j<30;j++) {
    					
    					{
    						
    						if(cell[i][j].getStatus()!=cell[i][j].getpStatus())
    						{
    							//System.out.print(cell[i][j].getpStatus());
    							if(cell[i][j].getStatus()==1) {
            	    				g.fillRect(i*25, j*25, 25, 25);
            	    			}
            	    			else {
            	    				g.clearRect(i*25, j*25, 25,25);
            	    				g.drawRect(i*25, j*25, 25, 25);
            				    }
    						}
    								
    					}
    					
    				}
    			}
    			
    		    count++;
    		    jframe.setTitle("第"+count+"次演化");
    			if(change==30*30) break;
    			if(count>1000) break;
    	    }	    	
      }
    	JOptionPane.showMessageDialog(jframe, "在第"+count+"次演化达到平衡", "提示", JOptionPane.PLAIN_MESSAGE);
    }
}
