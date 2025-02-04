package com.dmybais.notice.model.vo;

import java.sql.Timestamp;

public class Notice {
	private int noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String noticeWriter;
	private Timestamp noticeDate;
	private int viewCount;
	private String attachmentName;
	private String attachmentPath;
	private Timestamp attachmentDate;
	
	public Notice() {}
	
	public Notice(String noticeSubject, String noticeContent, String noticeWriter) {
		super();
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public String getNoticeSubject() {
		return noticeSubject;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public Timestamp getNoticeDate() {
		return noticeDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public Timestamp getAttachmentDate() {
		return attachmentDate;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeSubject=" + noticeSubject + ", noticeContent=" + noticeContent
				+ ", noticeWriter=" + noticeWriter + ", noticeDate=" + noticeDate + ", viewCount=" + viewCount
				+ ", attachmentName=" + attachmentName + ", attachmentPath=" + attachmentPath + ", attachmentDate="
				+ attachmentDate + "]";
	}
	
}
