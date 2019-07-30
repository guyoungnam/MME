package com.itf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OtherELE
{

	/**
	 * ������ ���� ������ 
	 */
	public static final HashMap<String, String> MGMT_PAGE_AUTH_ELE = new HashMap<String, String>()
	{
		{
			put("PAA", "Admin");
			put("PAB", "user_01");
			put("PAC", "user_02");
		}
	};
	
	/**
	 * ���� ����
	 */
	public static final HashMap<String, String> MAIL_ELE = new HashMap<String, String>()
	{
		{
			put("M00", "�����Է�");
			put("M01", "gmail.com");
			put("M02", "naver.com");
			put("M03", "daum.net");
		}
	};
	
	/**
	 * ���� ����
	 */
	public static final HashMap<String, String> AREA_ELE = new HashMap<String, String>()
	{
		{
			put("N02", "����");
			put("N51", "�λ�");
			put("N53", "�뱸");
			put("N32", "��õ");
			put("N62", "����");
			put("N42", "����");
			put("N52", "���");
			put("N44", "����");
			put("N31", "���");
			put("N33", "����");
			put("N43", "���");
			put("N41", "�泲");
			put("N63", "����");
			put("N61", "����");
			put("N54", "���");
			put("N55", "�泲");
			put("N64", "����");
		}
	};
	
	/**
	 * map ��  json ������  array �� ��ȯ
	 * @param _ele HashMap<String, String>
	 * @return List
	 */
	public static List getList(HashMap<String, String> _ele)
	{
		List list = new ArrayList();
		list.add(_ele);
		return list;
	}
	
	
	public static String getJson(HashMap<String, String> _ele)
	{ 
		StringBuilder result = new StringBuilder();
	
		result.append("{");
		Iterator<String> keys = _ele.keySet().iterator();
		boolean check = true;
		
		while( keys.hasNext() )
		{
			String key = keys.next();
			String value = _ele.get(key);
			if(check)
			{
				result.append("\""+key+"\":\""+value+"\"");
				check = false;
			}
			else
			{
				result.append(",\""+key+"\":\""+value+"\"");
			}	
		}
		
		result.append("}");
		
		return result.toString();
	}
	
	public static String getOption(HashMap<String, String> _ele)
	{
		StringBuilder result = new StringBuilder();
		
		Iterator<String> keys = _ele.keySet().iterator();
		while( keys.hasNext() )
		{
			String key = keys.next();
			String value = _ele.get(key);
			result.append("<option value='"+key+"'>"+value+"</option>");
		}
		
		return result.toString();
	}

	public static List<String> getKeys(HashMap<String, String> _ele)
	{
		return new ArrayList<String>(_ele.keySet());
	}
	
	public static List<String> getValues(HashMap<String, String> _ele)
	{
		return new ArrayList<String>(_ele.values());
	}
}
