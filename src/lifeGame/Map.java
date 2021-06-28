package lifeGame;
//管理与地图相关一切数据 的初始化、获取、更新等，其中含有initial(),getLiving(),update()等方法
import java.util.Random;
//Map()类： 管理与地图相关一切数据 的初始化、获取、更新等，其中含有initial(),getLiving(),update()等方法。
public class Map {
    final static public int x=30;
    final static public int y=30;
    //初始化地图
    public static Cell [][]initial() {
    	Cell [][]cell=new Cell[x][y];
    	for(int i=0;i<x;i++) {
    		for(int j=0;j<y;j++) {
    			cell[i][j]=new Cell();
    			Random random=new Random();
    			cell[i][j].setStatus(random.nextInt(2));
    		}
    	}
    	return cell;
    }   
    //获取所有细胞周围的活细胞数目，并调用Cell类的setLiving函数将其记录到该细胞的属性中
    public static void getLiving(Cell [][]cell){
    
    	//先判断除边界以外的点
    	for(int i=1;i<x-1;i++)
    	{
    		for(int j=1;j<y-1;j++)
    		{
    			int living=0;
    			 living+=cell[i-1][j-1].getStatus();
    			living+=cell[i-1][j].getStatus();
    			 living+=cell[i][j-1].getStatus();
    			living+=cell[i+1][j+1].getStatus();
    			 living+=cell[i+1][j].getStatus();
    			living+=cell[i][j+1].getStatus();
    			 living+=cell[i+1][j-1].getStatus();
    		     living+=cell[i-1][j+1].getStatus();
    			cell[i][j].setLiving(living);

    		}
    	}
    	//再判断上下两道
    	for(int i=0;i<x;i+=x-1) {
		for(int j=0;j<y;j++) {
			int living=0;
			if(i>0&&j>0) living+=cell[i-1][j-1].getStatus();
			if(i>0) living+=cell[i-1][j].getStatus();
			if(j>0) living+=cell[i][j-1].getStatus();
			if(i<x-1&&j<x-1) living+=cell[i+1][j+1].getStatus();
			if(i<x-1) living+=cell[i+1][j].getStatus();
			if(j<x-1) living+=cell[i][j+1].getStatus();
			if(i<x-1&&j>0) living+=cell[i+1][j-1].getStatus();
			if(i>0&&j<x-1) living+=cell[i-1][j+1].getStatus();
			cell[i][j].setLiving(living);
			
		}
	}
    	//左右两道
    	for(int i=1;i<x-1;i++) {
    		for(int j=0;j<y;j+=y-1) {
    			int living=0;
    			if(i>0&&j>0) living+=cell[i-1][j-1].getStatus();
    			if(i>0) living+=cell[i-1][j].getStatus();
    			if(j>0) living+=cell[i][j-1].getStatus();
    			if(i<x-1&&j<x-1) living+=cell[i+1][j+1].getStatus();
    			if(i<x-1) living+=cell[i+1][j].getStatus();
    			if(j<x-1) living+=cell[i][j+1].getStatus();
    			if(i<x-1&&j>0) living+=cell[i+1][j-1].getStatus();
    			if(i>0&&j<x-1) living+=cell[i-1][j+1].getStatus();
    			cell[i][j].setLiving(living);
    			
    		}
    	}
    }
    
    
    
  //调用Cell类的UpdateStatus()更新所有细胞状态，并使用count记录没更新的细胞数量
    public static int update(Cell [][]cell){
    	int count=0;
    	for(int i=0;i<x;i++) {
    		for(int j=0;j<y;j++) {
    			int status=cell[i][j].getStatus();
    			cell[i][j].UpdateStatus();
    			if(status==cell[i][j].getStatus()) count++;
    		}
    	}
    	return count;
    }
    public static void printMap(Cell [][]cell) {
    	for(int i=0;i<x;i++) {
    		for(int j=0;j<y;j++) {
    			System.out.print(cell[i][j].getStatus()+" ");
    		}
    		System.out.println();
    	}
    }
}


