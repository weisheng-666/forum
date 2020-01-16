package com.hws.domain;


/**
 * 用户数据的domain类
 * @author ScienJus
 * @date 2015/7/31.
 */
public class User {
	private long id;
    private String username;
    private String password;
    private String salt;
    private String role;
    private Integer money;
    private Integer joinDay;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	public Integer getJoinDay() {
		return joinDay;
	}
	public void setJoinDay(Integer joinDay) {
		this.joinDay = joinDay;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", role="
				+ role + ", money=" + money + ", joinDay=" + joinDay + "]";
	}
	
    
}
