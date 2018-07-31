package zk.springboot.server.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 會員Entity
 * @author Louis
 */
@Entity
@Table(name="MEMBER")
public class Member implements Serializable {

	public Member() {}
	
	@Id
	@Column(name="MEMID", nullable=false)
	private String memId;
	
	@Column(name="M_PWD", nullable=false)
	private String memPwd;
	
	@Transient
	private String memRePwd;
	
	@Column(name="M_NAME", nullable=false)
	private String memName;
	
	@Column(name="M_AUTH")
	private String memAuth;
	
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
	public String getMemRePwd() {
		return memRePwd;
	}
	public void setMemRePwd(String memRePwd) {
		this.memRePwd = memRePwd;
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
	
}
