package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTestCases {

	@Parameters("title")
	@Test(priority=1, groups = {"smoke"})
	public void method1(String titleValue)
	{
		System.out.println("This is method1 = "+titleValue);
	}
	
	@Test(priority=2)
	public void method2()
	{
		System.out.println("This is method2");
	}
	
	@Test(priority=7)
	public void method3()
	{
		System.out.println("This is method3");
	}
	
	@Test(priority=4)
	public void method4()
	{
		System.out.println("This is method4");
	}
	
	@Test(priority=5)
	public void method5()
	{
		System.out.println("This is method5");
	}
}
