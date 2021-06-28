package lifeGame;
//存放当前细胞及其周围细胞的存活状态以及相关的数据和方法
public class Cell {
	private int Status;   //0-死亡 1-存活
	private int Living;   //周围活细胞数目
	private int pStatus;
	private int pLiving;
	Cell(){
		Status=0;
		Living=0;
		pStatus=0;
		pLiving=0;
	}
	Cell(int m_Status,int m_Living){
		Status=m_Status;
		Living=m_Living;
	}
	public int getStatus() {
		return Status;//获取状态
	}
	public void setStatus(int m_Status) {
		Status=m_Status;//设置状态
	}
	public int getLiving() {
		return Living;//获取当前周围活细胞数目
	}
	public void setLiving(int m_Living) {
		Living=m_Living;//设置当前周围活细胞数目
	}
	public void UpdateStatus() {
		//保存原状态
		this.setpStatus(this.getStatus());
		if(this.getLiving()>3||this.getLiving()<2) this.setStatus(0);
		else if(this.getLiving()==3) this.setStatus(1);
		//else this.setStatus(this.Status);
	}
	public int getpStatus()
	{
		return pStatus;
		
	}
	public int getpLiving()
	{
		return pLiving;
	}
	public void setpStatus(int pStatus)
	{
		this.pStatus=pStatus;
	}


}
