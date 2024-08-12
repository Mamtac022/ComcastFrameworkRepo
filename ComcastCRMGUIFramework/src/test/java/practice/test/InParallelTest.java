package practice.test;

import org.testng.annotations.Test;

public class InParallelTest {
	@Test
	public void aetData() {
		System.out.println("data is executed");
	}
	@Test
	public void betData1() {
		System.out.println("data1 is executed");
	}
	@Test
	public void metData2() {
		System.out.println("data2 is executed");
	}
	@Test
	public void getData3() {
		System.out.println("data3 is executed");
	}
	@Test
	public void yetData4() {
		System.out.println("data4 is executed");
	}
	@Test
	public void retData5() {
		System.out.println("data5 is executed");
	}

}
