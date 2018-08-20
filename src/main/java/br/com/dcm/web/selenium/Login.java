package br.com.dcm.web.selenium;

import java.util.HashMap;
import java.util.Map;

public class Login {

	private String url;
	
	private String user;
	
	private String password;
	
	private Map<String, String> valuesByName = new HashMap();
	
	private boolean hasCaptcha;
	
	public Login() {
		
	}

	public Login(String url, String user, String password, Map<String, String> valuesByName, boolean hasCaptcha) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		this.valuesByName = valuesByName;
		this.hasCaptcha = hasCaptcha;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getValuesByName() {
		return valuesByName;
	}

	public void setValuesByName(Map<String, String> valuesByName) {
		this.valuesByName = valuesByName;
	}

	public boolean isHasCaptcha() {
		return hasCaptcha;
	}

	public void setHasCaptcha(boolean hasCaptcha) {
		this.hasCaptcha = hasCaptcha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasCaptcha ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((valuesByName == null) ? 0 : valuesByName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (hasCaptcha != other.hasCaptcha)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (valuesByName == null) {
			if (other.valuesByName != null)
				return false;
		} else if (!valuesByName.equals(other.valuesByName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [url=" + url + ", user=" + user + ", password=" + password + ", valuesByName=" + valuesByName
				+ ", hasCaptcha=" + hasCaptcha + "]";
	}
	
}
