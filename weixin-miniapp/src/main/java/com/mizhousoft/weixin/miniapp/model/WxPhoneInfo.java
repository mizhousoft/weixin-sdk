package com.mizhousoft.weixin.miniapp.model;

/**
 * 手机信息
 *
 */
public class WxPhoneInfo
{
	// 用户绑定的手机号（国外手机号会有区号）
	private String phoneNumber;

	// 没有区号的手机号
	private String purePhoneNumber;

	// 区号
	private String countryCode;

	// 数据水印
	private Watermark watermark;

	/**
	 * 获取phoneNumber
	 * 
	 * @return
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * 设置phoneNumber
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 获取purePhoneNumber
	 * 
	 * @return
	 */
	public String getPurePhoneNumber()
	{
		return purePhoneNumber;
	}

	/**
	 * 设置purePhoneNumber
	 * 
	 * @param purePhoneNumber
	 */
	public void setPurePhoneNumber(String purePhoneNumber)
	{
		this.purePhoneNumber = purePhoneNumber;
	}

	/**
	 * 获取countryCode
	 * 
	 * @return
	 */
	public String getCountryCode()
	{
		return countryCode;
	}

	/**
	 * 设置countryCode
	 * 
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}

	/**
	 * 获取watermark
	 * 
	 * @return
	 */
	public Watermark getWatermark()
	{
		return watermark;
	}

	/**
	 * 设置watermark
	 * 
	 * @param watermark
	 */
	public void setWatermark(Watermark watermark)
	{
		this.watermark = watermark;
	}
}
