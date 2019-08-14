package com.dto;

import java.util.List;

public class PageDTO {
	
	private int totalCount; //전체 게시물 개수 = 54
	private int curPage; //현재 클릭한 페이징, 디폴트= 1
	private int contentNum; //	1페이지당 보여줄 게시물 개수 = 3
	private int totalPage; // 전체 페이징 갯수 => totalCount/contentNum =  (54 / 3) = 18
	private List<BoardDTO> list; //해당 페이지에 보여줄 게시물 데이터
	
	private int pageGroupSize; //1페이지 나타나는 페이징 갯수 (임의작성가능) = 5
	private int startPage; // 페이징 first
	private int endPage; // 페이징 last
	private int prev; // 이전단계로 감
	private int next; // 이전단계로 감
	
	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageDTO(int totalCount, int curPage, int contentNum, int totalPage, List<BoardDTO> list, int pageGroupSize,
			int startPage, int endPage, int prev, int next) {
		super();
		this.totalCount = totalCount;
		this.curPage = curPage;
		this.contentNum = contentNum;
		this.totalPage = totalPage;
		this.list = list;
		this.pageGroupSize = pageGroupSize;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<BoardDTO> getList() {
		return list;
	}

	public void setList(List<BoardDTO> list) {
		this.list = list;
	}

	public int getPageGroupSize() {
		return pageGroupSize;
	}

	public void setPageGroupSize(int pageGroupSize) {
		this.pageGroupSize = pageGroupSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageDTO [totalCount=" + totalCount + ", curPage=" + curPage + ", contentNum=" + contentNum
				+ ", totalPage=" + totalPage + ", list=" + list + ", pageGroupSize=" + pageGroupSize + ", startPage="
				+ startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
	



}
	
	
	
	
	



