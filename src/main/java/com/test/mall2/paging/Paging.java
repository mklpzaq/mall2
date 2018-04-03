package com.test.mall2.paging;

public class Paging {
	int pagePerRow; //�������� ǥ�õ� �Խù� �ִ� ����
	int firstPage;	//ù��° ������ ��ȣ
	int starRow;	//����������
	int prevPage; //����������	
	int currentPage;	//����������
	int nextPage;	//����������
	int endPage;	//��������	
	int totalPage;	//��ü������
	int totalRowCount; //��ü �Խñۼ�
	int pageView; //�������� ������ ����


	public Paging (int currentPage, int pagePerRow) {
		this.currentPage = currentPage;
		this.pageView = 5;
		this.pagePerRow = (pagePerRow != 0)	? pagePerRow : 10;
		//�Խù� �ִ� ������ 0���� �ƴ϶�� ���� �Խù� ����(pagePerRow)�̰�, ���� �Խù����� 0����� 10��ǥ���̴�(10�� �׳� ������) 3�׿�����
	
	}

	
	
	
	public int getPagePerRow() {
		return pagePerRow;
	}




	public void setPagePerRow(int pagePerRow) {
		this.pagePerRow = pagePerRow;
	}




	public int getFirstPage() {
		return firstPage;
	}




	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}




	public int getStarRow() {
		return starRow;
	}




	public void setStarRow(int starRow) {
		this.starRow = starRow;
	}




	public int getPrevPage() {
		return prevPage;
	}




	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}




	public int getCurrentPage() {
		return currentPage;
	}




	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}




	public int getNextPage() {
		return nextPage;
	}




	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}




	public int getEndPage() {
		return endPage;
	}




	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}




	public int getTotalPage() {
		return totalPage;
	}




	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}




	public int getTotalRowCount() {
		return totalRowCount;
	}




	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}




	public int getPageView() {
		return pageView;
	}




	public void setPageView(int pageView) {
		this.pageView = pageView;
	}




	public void makePaging() {
		if(totalRowCount == 0)
		return;
		
		if(currentPage == 0)
			setCurrentPage(1);
		
		if(pagePerRow == 0) {
			setPagePerRow(10);
			
		int totalPage = (totalRowCount + (pagePerRow-1))/pagePerRow;
		
		if(currentPage>totalPage)
			setCurrentPage(totalPage);
		
		if(currentPage<0)
			currentPage = 1;
		
		boolean isNowFirst = currentPage == 1 ? true : false;
		boolean isNowFinal = currentPage == totalPage ? true : false;
		
		int starRow = ((currentPage -1) /pageView) * pageView + 1;
		int endPage = starRow + pageView -1;
		
		if(endPage > totalPage)
			endPage = totalPage;
		
		setTotalPage(1);
		
		if(!isNowFirst)
			setPrevPage(((starRow-1)< 1 ? 1 : (starRow -1)));
		
		setStarRow(starRow);
		setEndPage(endPage);
		
		if(!isNowFinal)
			setNextPage(((endPage+1)> totalPage ? totalPage : (endPage+1)));
		
		setTotalPage(totalPage);
		
		}
	}
	
}
