package webservice.test;

import com.meihuichina.webservice.PublishInformationCenterData;
import com.meihuichina.webservice.PublishInformationCenterDataService;

public class FastServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PublishInformationCenterDataService service = new PublishInformationCenterDataService();
		PublishInformationCenterData center = service.getPublishInformationCenterData();
		
		long ts = System.currentTimeMillis();
		String account = "liumm";
		String password = "111111";
		String dataName = "长三角高速路况数据";
		//计算MD5值
		String sig = PasswordMD5.encodeByMD5(account+password+ts);
//		String str = center.getDataCountByDataName(account, ts, sig, dataName);
		String str = center.getTrafficDataByDataName(account, ts, sig, dataName);
		String count= center.getDataCountByDataName(account, ts, sig, dataName);
		
		//String str1 =center.getTrafficDataByDataNameAndPage(account, ts, sig, dataName,3);
		//String str2 =center.getTrafficDataByDataNameAndPage(account, ts, sig, dataName, 4);
		System.out.print("str1-"+str);
		System.out.print("count-"+count);

	}

}
