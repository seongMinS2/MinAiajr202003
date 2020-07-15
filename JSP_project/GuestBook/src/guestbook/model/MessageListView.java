package guestbook.model;

import java.util.List;

public class MessageListView {

	// 전체 게시물의 개수
	private int messageTotalCount;

	// 현재 페이지 번호
	private int currentPageNumber;

	// 메시지 리스트
	private List<Message> messageList;

	// 전체 페이지의 개수
	private int pageTotalCount;

	// 페이지당 표현 게시물의 개수
	private int messageCountParpage;

	// 게시물의 시작 행
	private int startRow;

	// 게시물의 마지막 행
	private int endRow;

	public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList,
			int messageCountParpage, int startRow, int endRow) {
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountParpage = messageCountParpage;
		this.startRow = startRow;
		this.endRow = endRow;
		calTotalPageCount();
	}
	
	
	// new MessageListVieww();
	
	private void calTotalPageCount() {
			
		if(messageTotalCount == 0) {
			pageTotalCount=0;
		} else {
			pageTotalCount = messageTotalCount/messageCountParpage;
			if(messageTotalCount%messageCountParpage > 0) {
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


	public List<Message> getMessageList() {
		return messageList;
	}


	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}


	public int getMessageCountParpage() {
		return messageCountParpage;
	}


	public void setMessageCountParpage(int messageCountParpage) {
		this.messageCountParpage = messageCountParpage;
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
		return "MessageListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", messageList=" + messageList + ", pageTotalCount=" + pageTotalCount + ", messageCountParpage="
				+ messageCountParpage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
	public boolean isEmpty() {
		return messageTotalCount == 0;
	}
	
	

}
