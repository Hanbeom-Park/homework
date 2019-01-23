package com.ssafy.hw;

public class Sale {
	private String id,no;
	private int seq,howmany;
		public Sale(String id, String no, int howmany) {
		super();
		this.id = id;
		this.no = no;
		this.howmany = howmany;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getHowmany() {
		return howmany;
	}
	public void setHowmany(int howmany) {
		this.howmany = howmany;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", no=" + no + ", seq=" + seq + ", howmany=" + howmany + "]\n";
	}

	
}
