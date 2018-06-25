package zk.springboot.server.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member implements Serializable {
	
	public Member() {}
	
	public Member(String memName) {
		this.memName = memName;
	}
	
	@Id
	@Column(name="MEMID", nullable=false)
	private String memId;
	
	@Column(name="M_PWD")
	private String memPwd;
	
	@Column(name="M_NAME")
	private String memName;
	
	@Column(name="M_AUTH")
	private String memAuth;

	@Column(name="M_IMG")
	private String memImg;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemAuth() {
		return memAuth;
	}
	public void setMemAuth(String memAuth) {
		this.memAuth = memAuth;
	}
	public String getMemImg() {
		return memImg;
	}
	public void setMemImg(String memImg) {
		this.memImg = memImg;
	}
	
}
