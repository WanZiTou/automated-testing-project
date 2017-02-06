package webservice.test;

import java.util.Date;

import org.testng.annotations.Test;

import com.meihuichina.webservice.PublishInformationCenterData;
import com.meihuichina.webservice.PublishInformationCenterDataService;
import com.sand.qa.util.Base;
import com.sand.qa.util.Logger;

public class ConcurrentTest extends Base{

	
	/*
	 * 边界分析测试：业务规则边界分析
	 * 测试 (设定的访问频率是否与真实的访问频率不一致)
	 */
	@Test
	public void checkFrenquency(){
		final String[] accounts = new String[]{"liumm","liumm","liumm","liumm"};
		for(int i=0; i<accounts.length; i++){
			if(i >= accounts.length){
				break;
			}
			final String account = accounts[i];
			Thread thread = new Thread() {
				public void run() {
					System.out.println("线程 "+this.getName()+ " 开始执行...");
					PublishInformationCenterDataService service = new PublishInformationCenterDataService();
					PublishInformationCenterData soap = service.getPublishInformationCenterData();
		//				String account="";
		//				System.out.println(account);
					String password = "111111";
					long ts = new Date().getTime();
					String sig = PasswordMD5.encodeByMD5(account+password+ts);
					String dataName = "高架实况数据";//"数据名称";
		//				String xmlStr = soap.getDataCountByDataName(account, ts, sig, dataName);
					String xmlStr = soap.getDataCountByDataName(account, ts, sig, dataName);
		//				String xmlStr = soap.getImgUrlByAccount(account, ts, sig);
		//				String xmlStr = soap.getTrafficDataByDataNameAndPage(account, ts, sig, dataName, 1);
					System.out.println("线程名="+this.getName() +" 用户名="+account+" 长度="+ xmlStr.length());
					System.out.println(xmlStr);
				}
			};
			thread.start();
		}
}

}
