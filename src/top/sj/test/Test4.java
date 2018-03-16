package top.sj.test;

import java.io.IOException;

import top.sj.tool.BaiDuIPInfoTool;
import top.sj.tool.SouHuIPInfoTool;
import top.sj.tool.TaoBaoIPInfoTool;

public class Test4 {

	public static void main(String[] args) throws IOException {
		new Test4().taobao();
		new Test4().baidu();
	}

	public void taobao() {
		System.out.println("TaoBao IP API Request：");
		System.out.println(TaoBaoIPInfoTool.getIPInfo(SouHuIPInfoTool
				.getPublishedIPAddress()));
	}

	public void baidu() {
		System.out.println("BaiDu IP API Request：");
		System.out.println(BaiDuIPInfoTool.getIPInfo(
				"http://apis.baidu.com/apistore/iplookupservice/iplookup",
				"ip=" + SouHuIPInfoTool.getPublishedIPAddress()));
	}

}