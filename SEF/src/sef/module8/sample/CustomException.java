package sef.module8.sample;

public class CustomException extends Exception{

	//overriding the toString method of Exception
	public String toString()
	{
		return "This is my Custom Exception";
	}
}
