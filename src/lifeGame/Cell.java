package lifeGame;
//��ŵ�ǰϸ��������Χϸ���Ĵ��״̬�Լ���ص����ݺͷ���
public class Cell {
	private int Status;   //0-���� 1-���
	private int Living;   //��Χ��ϸ����Ŀ
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
		return Status;//��ȡ״̬
	}
	public void setStatus(int m_Status) {
		Status=m_Status;//����״̬
	}
	public int getLiving() {
		return Living;//��ȡ��ǰ��Χ��ϸ����Ŀ
	}
	public void setLiving(int m_Living) {
		Living=m_Living;//���õ�ǰ��Χ��ϸ����Ŀ
	}
	public void UpdateStatus() {
		//����ԭ״̬
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
