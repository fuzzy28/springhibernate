package org.jrue.poc.springhibernate.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

	@Column
	private Integer delflag = 0;
	@Column
	private Integer credate;
	@Column
	private Integer cretime;
	@Column
	private String creperson;
	@Column
	private String creproid;
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public Integer getCredate() {
		return credate;
	}
	public void setCredate(Integer credate) {
		this.credate = credate;
	}
	public Integer getCretime() {
		return cretime;
	}
	public void setCretime(Integer cretime) {
		this.cretime = cretime;
	}
	public String getCreperson() {
		return creperson;
	}
	public void setCreperson(String creperson) {
		this.creperson = creperson;
	}
	public String getCreproid() {
		return creproid;
	}
	public void setCreproid(String creproid) {
		this.creproid = creproid;
	}
		
}
