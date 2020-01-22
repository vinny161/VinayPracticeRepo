package com.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassForDependency {
	
	@Test(priority=1)
	public void register() {
		System.out.println("registering the website");
		Assert.assertTrue(false);
	}
	
	@Test(priority=2, dependsOnMethods = {"register"})
	public void login() {
		System.out.println("login");
	}

	@Test(priority=3, dependsOnMethods = {"login"})
	public void logout() {
		System.out.println("logout");
	}


}
