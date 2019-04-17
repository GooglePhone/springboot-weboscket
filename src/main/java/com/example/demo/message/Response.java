package com.example.demo.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * server to client
 */
public class Response {
	private static Response instance = null;
	//取號號碼 取號時間 等候時間 完成時間 取貨數量 動作
    private String responseMessage;
    public int maxNumber;
    private int number;//取號號碼
    private Date date;//取號時間
    private Date successTime;//完成時間
    private int amount;//取貨數量
    private int number1;
    private int number2;
    private int number3;
    private List<Integer> numList;

//	public int getMaxNumber() {
//		if(maxNumber == 0) {
//			Response.maxNumber = 1;
//		}
//		return maxNumber;
//	}
//
//	public void setMaxNumber(int maxNumber) {
//		Response.maxNumber = maxNumber;
//	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public int getNumber3() {
		return number3;
	}

	public void setNumber3(int number3) {
		this.number3 = number3;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(Date successTime) {
		this.successTime = successTime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Response(String responseMessage) {
        this.responseMessage = responseMessage;
    }
	
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Response() {
	}
    public String getResponseMessage() {
        return responseMessage;
    }
    
    public static Response getInstance() {
        if (instance == null){
            synchronized(Response.class){
                if(instance == null) {
                     instance = new Response();
                }
            }
        }
        return instance;
    }

	public List<Integer> getNumList() {
		numList = new ArrayList<Integer>();
		numList.add(getNumber1());
		numList.add(getNumber2());
		numList.add(getNumber3());
		return numList;
	}
}