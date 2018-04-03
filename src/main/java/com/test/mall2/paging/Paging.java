package com.test.mall2.paging;

public class Paging {
	int pagePerRow; //페이지당 표시될 게시물 최대 갯수
	int firstPage;	//첫번째 페이지 번호
	int starRow;	//시작페이지
	int prevPage; //이전페이지	
	int currentPage;	//현재페이지
	int nextPage;	//다음페이지
	int endPage;	//끝페이지	
	int totalPage;	//전체페이지
	int totalRowCount; //전체 게시글수
	int pageView; //보여지는 페이지 갯수


	public Paging (int currentPage, int pagePerRow) {
		this.currentPage = currentPage;
		this.pageView = 5;
		this.pagePerRow = (pagePerRow != 0)	? pagePerRow : 10;
		//게시물 최대 갯수가 0개가 아니라면 현재 게시물 갯수(pagePerRow)이고, 만약 게시물수가 0개라면 10개표현이다(10은 그냥 고정값) 3항연산자
	
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
		
		
		}
	}
	
}
