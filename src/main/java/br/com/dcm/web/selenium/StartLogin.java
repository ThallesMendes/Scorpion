package br.com.dcm.web.selenium;

import org.openqa.selenium.WebElement;

public class StartLogin {
	
	private Login login;
	
	private String userByName;
	private String passWordByName;
	private String buttonByName;
	
	private String userById;
	private String passWordById;
	private String buttonById;
	
	private String userByXPath;
	private String passWordByXPath;
	private String buttonByXPath;
	
	public StartLogin() {
		
	}
	
	public StartLogin(Login login, String userByName, String passWordByName, String buttonByName,
			String userById, String passWordById, String buttonById, String userByXPath, String passWordByXPath,
			String buttonByXPath) {
		super();
		this.login = login;
		this.userByName = userByName;
		this.passWordByName = passWordByName;
		this.buttonByName = buttonByName;
		this.userById = userById;
		this.passWordById = passWordById;
		this.buttonById = buttonById;
		this.userByXPath = userByXPath;
		this.passWordByXPath = passWordByXPath;
		this.buttonByXPath = buttonByXPath;
	}
	
	public StartLogin(Login login, String userByName, String passWordByName, String buttonByXPath) {
		super();
		this.login = login;
		this.userByName = userByName;
		this.passWordByName = passWordByName;
		this.buttonByXPath = buttonByXPath;
	}

	public StartLogin(SeleniumUtil selenium, Login login) {
		this.login = login;
	}
	
	public void doLogin() {
		// Entrando na pagina de login
		SeleniumUtil.openURL(login.getUrl());
		
		/* Pega o elemento userName */
		WebElement userName = null;
		if(userByName != null && !userByName.isEmpty()) {
			//userName = selenium.getDriver().findElement(By.name(userByName));
			userName = SeleniumUtil.getElementByName(userByName);
		}else if(userById != null && !userById.isEmpty()) {
			//userName = selenium.getDriver().findElement(By.id(userById));
			userName = SeleniumUtil.getElementById(userById);
		}else if(userByXPath != null && !userByXPath.isEmpty()) {
			//userName = selenium.getDriver().findElement(By.xpath(userByXPath));
			userName = SeleniumUtil.getElementByXPath(userByXPath);
		}else {
			//lan�ar uma exception
		}
		userName.clear();
		userName.sendKeys(login.getUser());

		/* Pega o elemento userPassword */
		WebElement userPassword = null;
		if(passWordByName != null && !passWordByName.isEmpty()) {
			//userPassword = selenium.getDriver().findElement(By.name(passWordByName));
			userPassword = SeleniumUtil.getElementByName(passWordByName);
		}else if(passWordById != null && !passWordById.isEmpty()) {
			//userPassword = selenium.getDriver().findElement(By.id(passWordById));
			userPassword = SeleniumUtil.getElementById(passWordById);
		}else if(passWordByXPath != null && !passWordByXPath.isEmpty()) {
			//userPassword = selenium.getDriver().findElement(By.xpath(passWordByXPath));
			userPassword = SeleniumUtil.getElementByXPath(passWordByXPath);
		}else {
			//lan�ar uma exception
		}
		userPassword.clear();
		userPassword.sendKeys(login.getPassword());
		
		
		/* click no botao entrar */
		WebElement btnLogin = null;
		if(buttonByName != null && !buttonByName.isEmpty()) {
			//btnLogin = selenium.getDriver().findElement(By.name(buttonByName));
			btnLogin = SeleniumUtil.getElementByName(buttonByName);
		}else if(buttonById != null && !buttonById.isEmpty()) {
			//btnLogin = selenium.getDriver().findElement(By.id(buttonById));
			btnLogin = SeleniumUtil.getElementById(buttonById);
		}else if(buttonByXPath != null && !buttonByXPath.isEmpty()) {
			//btnLogin = selenium.getDriver().findElement(By.xpath(buttonByXPath));
			btnLogin = SeleniumUtil.getElementByXPath(buttonByXPath);
		}else {
			//lan�ar uma exception
		}
		btnLogin.click();
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getUserByName() {
		return userByName;
	}

	public void setUserByName(String userByName) {
		this.userByName = userByName;
	}

	public String getPassWordByName() {
		return passWordByName;
	}

	public void setPassWordByName(String passWordByName) {
		this.passWordByName = passWordByName;
	}

	public String getButtonByName() {
		return buttonByName;
	}

	public void setButtonByName(String buttonByName) {
		this.buttonByName = buttonByName;
	}

	public String getUserById() {
		return userById;
	}

	public void setUserById(String userById) {
		this.userById = userById;
	}

	public String getPassWordById() {
		return passWordById;
	}

	public void setPassWordById(String passWordById) {
		this.passWordById = passWordById;
	}

	public String getButtonById() {
		return buttonById;
	}

	public void setButtonById(String buttonById) {
		this.buttonById = buttonById;
	}

	public String getUserByXPath() {
		return userByXPath;
	}

	public void setUserByXPath(String userByXPath) {
		this.userByXPath = userByXPath;
	}

	public String getPassWordByXPath() {
		return passWordByXPath;
	}

	public void setPassWordByXPath(String passWordByXPath) {
		this.passWordByXPath = passWordByXPath;
	}

	public String getButtonByXPath() {
		return buttonByXPath;
	}

	public void setButtonByXPath(String buttonByXPath) {
		this.buttonByXPath = buttonByXPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buttonById == null) ? 0 : buttonById.hashCode());
		result = prime * result + ((buttonByName == null) ? 0 : buttonByName.hashCode());
		result = prime * result + ((buttonByXPath == null) ? 0 : buttonByXPath.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((passWordById == null) ? 0 : passWordById.hashCode());
		result = prime * result + ((passWordByName == null) ? 0 : passWordByName.hashCode());
		result = prime * result + ((passWordByXPath == null) ? 0 : passWordByXPath.hashCode());
		result = prime * result + ((userById == null) ? 0 : userById.hashCode());
		result = prime * result + ((userByName == null) ? 0 : userByName.hashCode());
		result = prime * result + ((userByXPath == null) ? 0 : userByXPath.hashCode());
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
		StartLogin other = (StartLogin) obj;
		if (buttonById == null) {
			if (other.buttonById != null)
				return false;
		} else if (!buttonById.equals(other.buttonById))
			return false;
		if (buttonByName == null) {
			if (other.buttonByName != null)
				return false;
		} else if (!buttonByName.equals(other.buttonByName))
			return false;
		if (buttonByXPath == null) {
			if (other.buttonByXPath != null)
				return false;
		} else if (!buttonByXPath.equals(other.buttonByXPath))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (passWordById == null) {
			if (other.passWordById != null)
				return false;
		} else if (!passWordById.equals(other.passWordById))
			return false;
		if (passWordByName == null) {
			if (other.passWordByName != null)
				return false;
		} else if (!passWordByName.equals(other.passWordByName))
			return false;
		if (passWordByXPath == null) {
			if (other.passWordByXPath != null)
				return false;
		} else if (!passWordByXPath.equals(other.passWordByXPath))
			return false;
		if (userById == null) {
			if (other.userById != null)
				return false;
		} else if (!userById.equals(other.userById))
			return false;
		if (userByName == null) {
			if (other.userByName != null)
				return false;
		} else if (!userByName.equals(other.userByName))
			return false;
		if (userByXPath == null) {
			if (other.userByXPath != null)
				return false;
		} else if (!userByXPath.equals(other.userByXPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StartLogin [login=" + login + ", userByName=" + userByName
				+ ", passWordByName=" + passWordByName + ", buttonByName=" + buttonByName + ", userById=" + userById
				+ ", passWordById=" + passWordById + ", buttonById=" + buttonById + ", userByXPath=" + userByXPath
				+ ", passWordByXPath=" + passWordByXPath + ", buttonByXPath=" + buttonByXPath + "]";
	}
	
}
