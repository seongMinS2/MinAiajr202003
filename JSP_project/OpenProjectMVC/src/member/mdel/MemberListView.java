package member.mdel;

import java.util.List;

public class MemberListView {

	// 전체 행의 개수
	private int MemberTotalCount;

	// 현재 페이지 번호
	private int currentPageNumber;

	// 회원 리스트
	private List<Member> memberList;

	// 전체 페이지의 개수
	private int pageTotalCount;

	// 페이지당 표현 게시물의 개수
	private int MemberCountParpage;

	// 게시물의 시작 행
	private int startRow;

	// 게시물의 마지막 행
	private int endRow;

	public MemberListView(int MemberTotalCount, int currentPageNumber, List<Member> memberList,
			int MemberCountParpage, int startRow, int endRow) {
		this.MemberTotalCount = MemberTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.memberList = memberList;
		this.MemberCountParpage = MemberCountParpage;
		this.startRow = startRow;
		this.endRow = endRow;
		calTotalPageCount();
	}
	
	
	// new MemberListVieww();
	
	private void calTotalPageCount() {
			
		if(MemberTotalCount == 0) {
			pageTotalCount=0;
		} else {
			pageTotalCount = MemberTotalCount/MemberCountParpage;
			if(MemberTotalCount%MemberCountParpage > 0) {
				pageTotalCount++;
			}
		}
	}


	public int getCurrentPageNumber() {
		return currentPageNumber;
	}


	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}


	public List<Member> getMemberList() {
		return memberList;
	}


	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}


	public int getMemberCountParpage() {
		return MemberCountParpage;
	}


	public void setMemberCountParpage(int MemberCountParpage) {
		this.MemberCountParpage = MemberCountParpage;
	}


	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int eendRow) {
		this.endRow = eendRow;
	}


	@Override
	public String toString() {
		return "MemberListView [MemberTotalCount=" + MemberTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", memberList=" + memberList + ", pageTotalCount=" + pageTotalCount + ", MemberCountParpage="
				+ MemberCountParpage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
	public boolean isEmpty() {
		return MemberTotalCount == 0;
	}
	
	

}
