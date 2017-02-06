package util;

import java.util.Random;

public class MathRandom {
	
	public static int getRandom(int n){
		Random random=new Random();// 定义随机类
		int result=random.nextInt(n); //n=10  
		return result; //n=[0,10)
	}

}
