package com.itf;

import java.util.HashMap;

public class CarELE
{
	
	/**
	 * ��ǰ ���� ȸ�� 
	 */
	public static final HashMap<String, String> MADE_IN_TYPE_ELE = new HashMap<String, String>()
	{
		{
			put("M1", "����");
			put("M2", "����");
		}
	};
	
	/**
	 * ��ǰ ���� ȸ�� 
	 */
	public static final HashMap<String, String> BRAND_ELE = new HashMap<String, String>()
	{
		{
			put("B01", "�����ڵ���");
			put("B02", "����ڵ���");
			put("B03", "�ֿ��ڵ���");
		}
	};

	/**
	 * �������� 
	 */
	public static final HashMap<String, String> ENGINE_ELE = new HashMap<String, String>()
	{
		{
			put("EA", "�������(���ָ�)");
			put("EB", "�������(����)");
			put("EC", "���̺긮��(���ָ�)");
			put("ED", "����(���͸�)");
			put("EE", "����(����)");
		}
	};
	
	/**
	 * �ڵ��� ���� 
	 */
	public static final HashMap<String, String> TYPE_ELE = new HashMap<String, String>()
	{
		{
			put("TA", "�¿�");
			put("TB", "SUV");
			put("TC", "MPV");
			put("TD", "����ȭ��");
		}
	};
	

	/**
	 * �ڵ��� ũ�� ����
	 */
	public static final HashMap<String, String> SIZE_ELE = new HashMap<String, String>()
	{
		{
			put("SA", "����");
			put("SB", "������");
			put("SC", "����");
			put("SD", "����");
		}
	};
	
	/**
	 * �Ǹ��� ���� 
	 */
	public static final HashMap<String, String> CYLINDER_ELE = new HashMap<String, String>()
	{
		{
			put("CA", "3����");
			put("CB", "4����");
			put("CC", "6����");
			put("CD", "8����");
			put("CE", "12����");
		}
	};
	
	/**
	 * ��� Ÿ�� 
	 */
	public static final HashMap<String, String> GEAR_TYPE_ELE = new HashMap<String, String>()
	{
		{
			put("GT1", "����");
			put("GT2", "�ڵ�");
		}
	};
	
	/**
	 * ���ܼ� 
	 */
	public static final HashMap<String, String> GEAR_COUNT_ELE = new HashMap<String, String>()
	{
		{
			put("G04", "4 ��");
			put("G05", "5 ��");
			put("G06", "6 ��");
			put("G07", "7 ��");
			put("G08", "8 ��");
			put("G09", "9 ��");
			put("G0A", "10 ��");
		}
	};
	
	/**
	 * ���� ���� 
	 */
	public static final HashMap<String, String> DOOR_ELE = new HashMap<String, String>()
	{
		{
			put("D2", "2 ��");
			put("D3", "3 ��");
			put("D4", "4 ��");
			put("D5", "5 ��");
		}
	};
	
	
	/**
	 * ���޹��
	 */
	public static final HashMap<String, String> INHALATION_TYPE_ELE = new HashMap<String, String>()
	{
		{
			put("IT1", "�ڿ����");
			put("IT2", "�ͺ�");
			put("IT3", "Ʈ���ͺ�");
			put("IT4", "Ʈ�����ͺ�");
		}
	};

	/**
	 * ���� ���� ����
	 */
	public static final HashMap<String, String> DRIVEN_SYSTEM_ELE = new HashMap<String, String>()
	{
		{
			put("DS1", "����");
			put("DS2", "�ķ�");
			put("DS3", "���4��(AWD)");
			put("DS4", "��ƮŸ��4��(4WD)");
		}
	};

	/**
	 * ���� �߰��� 
	 */
	public static final HashMap<String, String> NEW_CAR_ELE = new HashMap<String, String>()
	{
		{
			put("NC1", "����");
			put("NC2", "�߰���");
			put("NC3", "����/�߰���");
		}
	};
	
	
	
	
}